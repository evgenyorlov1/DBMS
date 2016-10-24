/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author pc
 */

//implement singletones
public class SingletonDBMSimplementation extends java.rmi.server.UnicastRemoteObject implements SingletonDBMSinterface {

    private static SingletonDBMS instance;    
    private static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<DataBase> databases = new ArrayList<>();
    private static final String admin = "admin";
    private static final String user = "user";
    private static boolean isAdmin = true; //TESTING true
    
    public SingletonDBMSimplementation() throws java.rmi.RemoteException {
        super();
    }
    
    @Override
    public ArrayList<String> show_dbs() throws RemoteException {
        ArrayList<String> databaseNames = new ArrayList<String>();        
        
        for(int i=0; i<databases.size(); i++) {
            databaseNames.add(databases.get(i).name);
        }
        return databaseNames;
    }

    @Override
    public ArrayList<String> show_tables(String DBname) throws RemoteException {
        ArrayList<String> tables = new ArrayList<String>();
        
        for(int i=0; i<databases.size(); i++) {
            if(databases.get(i).name.equals(DBname)) {               
                for(int j=0; j<databases.get(i).tables.size(); j++) {                    
                    tables.add(databases.get(i).tables.get(j).name);
                }
            }
        }
        return tables;
    }

    @Override
    public void drop_database(String DBname) throws RemoteException {
        if(isAdmin) {
            for(int i=0; i<databases.size(); i++) {
                if(databases.get(i).name.equals(DBname)) {
                    databases.remove(i);
                }
            }
        }
    }

    @Override
    public void drop_table(String DBname, String Tname) throws RemoteException {
        if(isAdmin) {
            for(int i=0; i<databases.size(); i++) {
                if(databases.get(i).name.equals(DBname)) {
                    for(int j=0; j<databases.get(i).tables.size(); j++) {
                       if(databases.get(i).tables.get(j).name.equals(Tname)) {
                           databases.get(i).tables.remove(j);
                       }
                    }
                }
            }
        }
    }

    @Override
    public void create_database(String DBname) throws RemoteException {
        if(isAdmin) {
            DataBase db = new DataBase(DBname);
            databases.add(db);
        }
    }

    @Override
    public void create_table(String DBname, String Tname, ArrayList<String[]> keyType) throws RemoteException {
        final String[] id = new String[] {"_id", "integer"};
        keyType.add(id);
        
        if(isAdmin) {            
            for(int i=0; i<databases.size(); i++) {
                if(databases.get(i).name.equals(DBname)) {                    
                    databases.get(i).tables.add(new Table(Tname, keyType));
                }
            }        
        }
    }

    @Override
    public void save_serialization(String DBname, String fileName) throws RemoteException {
        try {    
            for(DataBase db : databases) {
                if (db.name.equals(DBname)) {
                    FileOutputStream out = new FileOutputStream(fileName);
                    ObjectOutputStream oos = new ObjectOutputStream(out);
                    oos.writeObject(db);
                    oos.flush();
                }
            }
        } catch(Exception e) {}
    }

    @Override
    public void save_serialization(String DBname, String Tname, String fileName) throws RemoteException {
        try {
            for(DataBase db : databases) {
                if(db.name.equals(DBname)) {
                    for(Table tb : db.tables) {
                        if(tb.name.equals(Tname)) {
                            FileOutputStream out = new FileOutputStream(fileName);
                            ObjectOutputStream oos = new ObjectOutputStream(out);
                            oos.writeObject(tb);
                            oos.flush();
                        }
                    }
                }
            }
        } catch(Exception e) {}
    }

    @Override
    public void load_serialization(String file) throws RemoteException {
        try {
            FileInputStream in = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(in);
            DataBase db = (DataBase) (ois.readObject());
            this.databases.add(db);        
        } catch(Exception e) {}
    }

    @Override
    public void load_serialization(String DBname, String file) throws RemoteException {
        try {
            FileInputStream in = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(in);
            Table tb = (Table) (ois.readObject());        

            for(DataBase db : databases) {
                if(db.name.equals(DBname)) {
                    db.tables.add(tb);
                }
            }  
        } catch(Exception e) {}
    }

    @Override
    public boolean register(User login) throws RemoteException {
        users.add(login);
        try {
            serialize();
        } catch (Exception ex) {}        
        return true;
    }

    @Override
    public boolean login(User login) throws RemoteException {
        try {
            deserialize();            
        } catch (Exception ex) {}            
        
        for(User user : users) {
            if(user.password.equals(login.password) && user.username.equals(login.username)) {
                if(login.username.equals(admin)) {
                    this.isAdmin = true;
                    return true;                    
                } 
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<ArrayList<String[]>> find(String DBname, String Tname) throws RemoteException {
        ArrayList<Record> recs = get_records(DBname, Tname);  
        ArrayList<ArrayList<String[]>> records = new ArrayList<>();
        
        for(int i=0; i<recs.size(); i++) 
            records.add(recs.get(i).keyValue); 
        
        return records;
    }

    @Override
    public ArrayList<String[]> get_metadata(String DBname, String Tname) throws RemoteException {
        System.out.println("SingletonDBMS.get_metadata");        
        ArrayList<String[]> metadata = new ArrayList<>();
                
        for(DataBase db : databases) {
            if(db.name.equals(DBname)) {
                for(Table tb : db.tables) {
                    if(tb.name.equals(Tname))
                        metadata = tb.keyType;                    
                }
            }
        }                                             
        
        return metadata;
    }

    @Override
    public ArrayList<ArrayList<String[]>> limit(String DBname, String Tname, int num) throws RemoteException {
        System.out.println("SingletonDBMS.limit");
        ArrayList<Record> result = get_records(DBname, Tname);        
        ArrayList<ArrayList<String[]>> records = new ArrayList<>();
        for(int i=0; i<result.size(); i++) 
            records.add(result.get(i).keyValue); 
        
        ArrayList<ArrayList<String[]>> res = new ArrayList<ArrayList<String[]>>();                
        for(int i=0; i<Math.min(num, result.size()); i++) {
            res.add(records.get(i));
        }                
        return res;
    }

    @Override
    public ArrayList<ArrayList<String[]>> skip(String DBname, String Tname, int num) throws RemoteException {
        System.out.println("SingletonDBMS.skip");
        ArrayList<Record> recs = get_records(DBname, Tname);  
        ArrayList<ArrayList<String[]>> records = new ArrayList<>();        
        for(int i=0; i<recs.size(); i++) 
            records.add(recs.get(i).keyValue); 
        
        ArrayList<ArrayList<String[]>> result = new ArrayList<>();        
        int count = Math.min(records.size(), num);
        for(int i=count; i>0; i--) 
            result.add(records.get(i));
        
        return result;
    }

    @Override
    public ArrayList<ArrayList<String[]>> sort(String DBname, String Tname, String key, int order) throws RemoteException {
        System.out.println("SingletonDBMS.sort");
        ArrayList<Record> recs = get_records(DBname, Tname);  
        ArrayList<ArrayList<String[]>> records = new ArrayList<>();        
        for(int i=0; i<recs.size(); i++) 
            records.add(recs.get(i).keyValue); 
        
        String type = "";
        
        ArrayList<String[]> KeyType = get_metadata(DBname, Tname); 
        for(String[] tp : KeyType) {
            System.out.println(tp[0]);System.out.println(tp[1]);
        }
        for(String[] keyType : KeyType) {
            if(keyType[0].equals(key))
                type = keyType[1];
        }        
        Comparator comparator = new Comparator(type, order);
        
        return bubble_sort(recs, comparator, key);
    }

    @Override
    public int count(String DBname, String Tname) throws RemoteException {
        System.out.println("SingletonDBMS.count");
        int count = 0;
        for(DataBase db : databases) {
            if(db.name.equals(DBname)) {
                for(Table tb : db.tables) {
                    if(tb.name.equals(Tname)) {
                        count = tb.records.size();
                    }
                }
            }
        }
        return count;
    }

    @Override
    public void insert(String DBname, String Tname, ArrayList<String[]> keyValue) throws RemoteException {
        System.out.println("SingletonDBMS.insert");
        String[] id = new String[2];
        id[0] = "_id";
        for(String[] row : keyValue) 
            id[1] += row[1];        
        
        id[1] = String.valueOf(id[1].hashCode());
        keyValue.add(id);
        
        for(DataBase db : databases) {
            if(db.name.equals(DBname)) {
                for(Table tb : db.tables) {
                    tb.insert(keyValue);
                }
            }
        }       
    }

    @Override
    public void update(String _id, ArrayList<String[]> keyVal, String DBname, String Tname) throws RemoteException {
        System.out.println("SingletonDBMS.update");
        ArrayList<Record> records = new ArrayList<Record>();
        System.out.println(keyVal.size());
        for(DataBase db : databases) {
            if(db.name.equals(DBname))
                for(Table tb : db.tables) {
                    if(tb.name.equals(Tname))
                        records = tb.records;
                }
        }
        
        for(Record record : records) {
            if(record.get_by_key("_id").equals(_id)) {
                System.out.println(record.get_by_key("_id"));
                for(String[] kv : keyVal) {
                    System.out.println(kv[0] + ", " + kv[1]);
                    record.set_by_key(kv[0], kv[1]);
                }
            }            
        }
    }

    @Override
    public boolean is_unique_name(String useState) throws RemoteException {
        for(int i=0; i<databases.size(); i++) {
            if(databases.get(i).name.equals(useState))
                return false;
        }
        return true;
    }

    @Override
    public void remove(String DBname, String Tname, String id) throws RemoteException {
        System.out.println("SingletonDBMS.remove id");
        for(DataBase db : databases) 
            if(db.name.equals(DBname)) 
                for(Table tb : db.tables) 
                    if(tb.name.equals(Tname)) 
                        for(int i=0; i<tb.records.size(); i++) 
                            if(tb.records.get(i).get_by_key("_id").equals(id))
                                tb.records.remove(i);    
    }

    @Override
    public void remove(String DBname, String Tname, ArrayList<String[]> keyValues) throws RemoteException {
        System.out.println("SingletonDBMS.remove key");
        ArrayList<Record> records = new ArrayList<Record>();
        for(DataBase db : databases) 
            if(db.name.equals(DBname)) 
                for(Table tb : db.tables) 
                    if(tb.name.equals(Tname)) 
                        records = tb.records;                
        
        for(Record record : records) {
            int count = keyValues.size();
            for(String[] keyval : keyValues) {                
                String valRec = record.get_by_key(keyval[0]);
                String valRem = keyval[1];
                if(valRec.equals(valRem))
                    count--;
            }
            if(count == 0)
                records.remove(record);
        }
    }

    @Override
    public ArrayList<Record> get_records(String DBname, String Tname) throws RemoteException {
        System.out.println("SingletonDBMS.get_records");
        
        ArrayList<Record> rec = new ArrayList<>();
        
        for(DataBase db : databases) {
            if(db.name.equals(DBname)) {
                for(Table tb : db.tables) {
                    if(tb.name.equals(Tname)) 
                        rec = tb.records;                    
                }
            }
        }
                                                       
        return rec;
    }

    @Override
    public ArrayList<ArrayList<String[]>> bubble_sort(ArrayList<Record> records, Comparator camparator, String key) throws RemoteException {
        
        for(int i=0; i<records.size(); i++) {                        
            for(int j=0; j<records.size(); j++) {                
                if(camparator.compare(records.get(i).get_by_key(key),records.get(j).get_by_key(key))) {                
                    Collections.swap(records, j, i);
                }
            }
        }
        
        ArrayList<ArrayList<String[]>> result = new ArrayList<>();        
        for(int i=0; i<records.size(); i++) 
            result.add(records.get(i).keyValue); 
        
        return result;
    }

    @Override
    public void serialize() throws RemoteException {
        try {
            FileOutputStream out = new FileOutputStream("config");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(users);
            oos.flush();      
        } catch(Exception e) {}
    }

    @Override
    public void deserialize() throws RemoteException {
        try {
            ArrayList<User> users = new ArrayList<User>();
            FileInputStream in = new FileInputStream("config");
            ObjectInputStream ois = new ObjectInputStream(in);
            users = (ArrayList<User>) (ois.readObject());
            this.users = users;
        } catch(Exception e) {}
    }

    @Override
    public String hello() throws RemoteException {
        return "Hello";
    }
    
}
