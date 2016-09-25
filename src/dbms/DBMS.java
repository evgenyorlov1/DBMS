/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pc
 */
// CONVERT TO SINGLETON
public class DBMS { 

    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<DataBase> databases = new ArrayList<>();
        
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
    
    //TODO
    public void register() {
        
    }
    
    //TODO
    public void login() {
        
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
        
        for(int i=0; i<num; i++) {
            results.add(records.get(i).get());
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
        ArrayList<Record> records = get_records(DBname, Tname);
        ArrayList<String[]> results = new ArrayList<String[]>();
        for(int i=0; i<records.size(); i++) {
            results.add(records.get(i).get());
        }        
        if(order == 1) {
            return ascending_sort(results, key);
        } else {
            System.out.println("desc");
            return descending_sort(results, key);
        }
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
    private ArrayList<String[]> ascending_sort(ArrayList<String[]> records, String key) {        
        if(key.equals("integer")) {            
            records = insertion_sort_integer(records);
        } else if(key.equals("real")) {
            records = insertion_sort_real(records);
        } else if(key.equals("longint")) {
            records = insertion_sort_longint(records);
        } else if(key.equals("char")) {
            records = insertion_sort_char(records);
        }
        return records;
    }
    
    private ArrayList<String[]> descending_sort(ArrayList<String[]> records, String key) {
        
        return records;
    }         
    
    private ArrayList<String[]> insertion_sort_integer(ArrayList<String[]> records) {                  
        for(int i=1; i<records.size(); i++) {
            int key = Integer.valueOf(records.get(i)[0]);     
            System.out.println("key: " + key);
            int j = i - 1;           
            while(j>=0 && Integer.valueOf(records.get(j)[0]) > key) {
                System.out.println("j: " + j);
                
                records.get(j+1)[0] = records.get(j)[0];
                j-=1;
                records.get(i+1)[0] = String.valueOf(key);
            }
        }
        return records;
    }
    
    private ArrayList<String[]> insertion_sort_real(ArrayList<String[]> records) {
                
        return records;
    }
    
    private ArrayList<String[]> insertion_sort_longint(ArrayList<String[]> records) {
                
        return records;
    }
    
    private ArrayList<String[]> insertion_sort_char(ArrayList<String[]> records) {
                
        return records;
    }
   
 }