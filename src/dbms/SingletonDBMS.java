/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class SingletonDBMS {
    
    private static SingletonDBMS instance;    
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<DataBase> databases = new ArrayList<>();
    private static final String admin = "admin";
    private static final String user = "user";
    private static boolean isAdmin = false;
    
    
    private SingletonDBMS() {}
    
    public static synchronized SingletonDBMS getInstance(){
        if(instance == null){
            instance = new SingletonDBMS();
        }
        return instance;
    }
    
    //TESTED
    public ArrayList<String> show_dbs() {        
        ArrayList<String> databaseNames = new ArrayList<String>();        
        
        for(int i=0; i<databases.size(); i++) {
            databaseNames.add(databases.get(i).name);
        }
        return databaseNames;
    }
    
    //TESTED
    public ArrayList<String> show_tables(String DBname) {
        ArrayList<String> tables = new ArrayList<String>();
        
        for(int i=0; i<databases.size(); i++) {
            if(databases.get(i).name.equals(DBname)) {               
                for(int j=0; j<databases.get(i).tablesList.size(); j++) {                    
                    tables.add(databases.get(i).tablesList.get(j).name);
                }
            }
        }
        return tables;
    }
    
    //isAdmin modifier
    public void drop_database(String DBname) {
        if(isAdmin) {
            for(int i=0; i<databases.size(); i++) {
                if(databases.get(i).name.equals(DBname)) {
                    databases.remove(i);
                }
            }
        }
    }
    
    //isAdmin modifier
    public void drop_table(String DBname, String Tname) {   
        if(isAdmin) {
            for(int i=0; i<databases.size(); i++) {
                if(databases.get(i).name.equals(DBname)) {
                    for(int j=0; j<databases.get(i).tablesList.size(); j++) {
                       if(databases.get(i).tablesList.get(j).name.equals(Tname)) {
                           databases.get(i).tablesList.remove(j);
                       }
                    }
                }
            }
        }
    }
    
    //isAdmin modifier
    public void create_database(String DBname) {
        if(isAdmin) {
            DataBase db = new DataBase(DBname);
            databases.add(db);
        }
    }
    
    //isAdmin modifier
    public void create_table(String DBname, String Tname) {   
        if(isAdmin) {
            for(int i=0; i<databases.size(); i++) {
                if(databases.get(i).name.equals(DBname)) {
                    //System.out.println("create_table: " + Tname);
                    databases.get(i).tablesList.add(new Table(Tname));
                }
            }        
        }
    }
    
    //isAdmin modifier
    public void save(String DBname, String fileName) {
        if(isAdmin) {
            String json = "";
            JSONGenerator generator = new JSONGenerator();
            for(DataBase db : databases) {
                if(db.name.equals(DBname))
                    json = generator.database_to_json(db);
            }

            try {
                File file = new File(fileName);
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(json);            
                fileWriter.flush();
                fileWriter.close();
            } catch(Exception e) {}
        }        
    }
    
    //isAdmin modifier
    public void save(String DBname, String Tname, String fileName) {
        if(isAdmin) {
            String json = "";
            JSONGenerator generator = new JSONGenerator();
            for(DataBase db : databases) {
                if(db.name.equals(DBname))
                    for(Table tb : db.tablesList) {
                        if(tb.name.equals(Tname))
                            json = generator.table_to_json(tb);
                    }
            }

            try {
                File file = new File(fileName);
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(json);            
                fileWriter.flush();
                fileWriter.close();
            } catch(Exception e) {}
        }        
    }
    
    //isAdmin modifier
    public void load(String file) {
        BufferedReader br = null;
        String json = "";
        try {
            String sCurrentLine;
            br = new BufferedReader(
                    new FileReader(System.getProperty("user.dir").concat("/"+file))
            );
            while ((sCurrentLine = br.readLine()) != null) {
                json = json.concat(sCurrentLine);
            }
        } catch(Exception e) {}
        JSONGenerator generator = new JSONGenerator();
        DataBase db = generator.json_to_database(json);
        databases.add(db);
    }
    
    //isAdmin modifier
    public void load(String DBname, String file) {
        BufferedReader br = null;
        String json = "";
        
        try {
            String sCurrentLine;
            br = new BufferedReader(
                    new FileReader(System.getProperty("user.dir").concat("/"+file))
            );
            while ((sCurrentLine = br.readLine()) != null) {
                json = json.concat(sCurrentLine);
            }
        } catch(Exception e) {}
        
        JSONGenerator generator = new JSONGenerator();
        Table tb = generator.json_to_table(json);
        
        for(DataBase db : databases) {
            if(db.name.equals(DBname)) {
                db.tablesList.add(tb);
            }
        }                
    }
    
    //TESTED
    public boolean register(User login) {        
        users.add(login);
        try {
            serialize();
        } catch (Exception ex) {}        
        return true;
    }
        
    //TESTED
    public boolean login(User login) {        
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
    
    //TESTED
    public ArrayList<String[]> find(String DBname, String Tname) {
        ArrayList<Record> records = get_records(DBname, Tname);
        ArrayList<String[]> results = new ArrayList<String[]>();
        
        for(int i=0; i<records.size(); i++) {
            results.add(records.get(i).get());
        }        
        
        return results;
    }
    
    //TESTED
    public ArrayList<String[]> limit(String DBname, String Tname, int num) {
        ArrayList<Record> records = get_records(DBname, Tname);
        ArrayList<String[]> results = new ArrayList<String[]>();
        
        int i=0;
        while(i<num && i<records.size()) {
            results.add(records.get(i).get());
            i++;
        }
              
        return results;
    }
            
    //TESTED
    public ArrayList<String[]> skip(String DBname, String Tname, int num) {
        ArrayList<Record> records = get_records(DBname, Tname);        
        ArrayList<String[]> results = new ArrayList<String[]>();
        
        for(int i=num; i<records.size(); i++) {
            results.add(records.get(i).get());
        }        
        return results;
    }
    
    //TESTED
    public ArrayList<String[]> sort(String DBname, String Tname, String key, int order) {
        System.out.println("DBMS.sort");
        ArrayList<Record> records = get_records(DBname, Tname);
        ArrayList<String[]> results = new ArrayList<String[]>();
        for(int i=0; i<records.size(); i++) {
            results.add(records.get(i).get());
        }
        
        Comparator comparator = new Comparator(key, order);
        return bubble_sort(results, comparator);
    }
    
    //TESTED
    public void insert(String DBname, String Tname, 
            int integer, float real, long longint, char symbol, String html) {     
        Record record = new Record(integer, real, longint, symbol, html);
        
        for(int i=0; i<databases.size(); i++) {
            if(databases.get(i).name.equals(DBname)) {
                for(int j=0; j<databases.get(i).tablesList.size(); j++) {
                   if(databases.get(i).tablesList.get(j).name.equals(Tname)) {
                       databases.get(i).tablesList.get(j).recordList.add(record);
                   }
                }
            }
        }
    }
    
    //TESTED
    public void insert(String DBname, String Tname, Record record) {
        for(int i=0; i<databases.size(); i++) {
            if(databases.get(i).name.equals(DBname)) {                
                for(int j=0; j<databases.get(i).tablesList.size(); j++) {
                   if(databases.get(i).tablesList.get(j).name.equals(Tname)) {
                       databases.get(i).tablesList.get(j).recordList.add(record);
                   }
                }                
            }
        }
    }
    
    public void update(ArrayList<String[]> rows, String DBname, String Tname) {
        Table tb = new Table(Tname);
        for(int i=0; i<rows.size(); i++) {
            int integer = Integer.valueOf(rows.get(i)[0]);
            float real = Float.valueOf(rows.get(i)[1]);
            long longint = Long.valueOf(rows.get(i)[2]);
            char symbol = rows.get(i)[3].charAt(0);
            String html = rows.get(i)[4];
            Record record = new Record(integer, real, longint, symbol, html);
            tb.recordList.add(record);
        }
        for(int i=0; i<databases.size(); i++) {
            if(databases.get(i).name.equals(DBname)) {
                for(int j=0; j<databases.get(i).tablesList.size(); j++) {
                    if(databases.get(i).tablesList.get(j).name.equals(Tname)) {
                       databases.get(i).tablesList.set(j, tb);                        
                    }
                }
            }
        }
    }
    
    //TEST
    public boolean is_unique_name(String useState) {
        for(int i=0; i<databases.size(); i++) {
            if(databases.get(i).name.equals(useState))
                return false;
        }
        return true;
    }
    
    //TESTED
    private ArrayList<Record> get_records(String DBname, String Tname) {        
        ArrayList<Record> records = new ArrayList<Record>();
        
        for(int i=0; i<databases.size(); i++) {
            if(databases.get(i).name.equals(DBname)) {
                for(int j=0; j<databases.get(i).tablesList.size(); j++) {
                   if(databases.get(i).tablesList.get(j).name.equals(Tname)) {
                       records = databases.get(i).tablesList.get(j).recordList;
                   }
                }
            }
        } 
        
        return records;
    }
    
    //TESTED
    private ArrayList<String[]> bubble_sort(ArrayList<String[]> records, Comparator camparator) {        
        for(int i=0; i<records.size(); i++) {                        
            for(int j=0; j<records.size(); j++) {   
                System.out.println(camparator.compare(records.get(i),records.get(j)));
                if(camparator.compare(records.get(i),records.get(j))) {                
                    Collections.swap(records, j, i);
                }
            }
        }
        return records;
    }        

    private void serialize() throws Exception {
        FileOutputStream out = new FileOutputStream("config");
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(users);
        oos.flush();            
    }    
    
    private void deserialize() throws Exception {
        ArrayList<User> users = new ArrayList<User>();
        FileInputStream in = new FileInputStream("config");
        ObjectInputStream ois = new ObjectInputStream(in);
        users = (ArrayList<User>) (ois.readObject());
        this.users = users;
    }
        
 }
