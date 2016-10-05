/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.util.ArrayList;
import java.util.Collections;

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
    
    //TESTED
    public void drop_database(String DBname) {        
        for(int i=0; i<databases.size(); i++) {
            if(databases.get(i).name.equals(DBname)) {
                databases.remove(i);
            }
        }
    }
    
    //TESTED
    public void drop_table(String DBname, String Tname) {        
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
    
    //TESTED, add name unique test
    public void create_database(String DBname) {
        DataBase db = new DataBase(DBname);
        databases.add(db);
    }
    
    //TESTED, add name unique test
    public void create_table(String DBname, String Tname) {   
        System.out.println("DBMS.create_table");
        for(int i=0; i<databases.size(); i++) {
            if(databases.get(i).name.equals(DBname)) {
                //System.out.println("create_table: " + Tname);
                databases.get(i).tablesList.add(new Table(Tname));
            }
        }        
    }
    
    //TODO
    public void save(String DBname) {
        
    }
    
    //TEST
    public String register(User login) {
        users.add(login);
        return user;
    }
    
    //TODO
    //FIX
    public String login(User login) {
        if(users.contains(login)) {
            for(int i=0; i<users.size(); i++) {
                if(users.get(i).username.equals(admin)) {
                    return admin;
                }
            }
        } 
        return admin;
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

}
