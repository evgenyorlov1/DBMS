/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class DBMS {

    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<DataBase> databases = new ArrayList<>();
        
    public String[] show_dbs() {
        int size = databases.size();
        String[] databaseNames = new String[size];
        for(int i=0; i<size; i++) {
            databaseNames[i] = databases.get(i).name;
        }
        return databaseNames;
    }
    
    public ArrayList<String> show_tables(String DBname) {
        ArrayList<String> tables = new ArrayList<String>();
        int size = databases.size();
        for(int i=0; i<size; i++) {
            if(databases.get(i).name.equals(DBname)) {
                for(int j=0; j<databases.get(i).tablesList.size(); j++) {
                    tables.add(databases.get(i).tablesList.get(i).name);
                }
            }
        }
        return tables;
    }
    
    public void drop_database(String DBname) {
        int size = databases.size();
        for(int i=0; i<size; i++) {
            if(databases.get(i).name.equals(DBname)) {
                databases.remove(i);
            }
        }
    }
    
    public void drop_table(String DBname, String Tname) {
        int size = databases.size();
        for(int i=0; i<size; i++) {
            if(databases.get(i).name.equals(DBname)) {
                for(int j=0; j<databases.get(i).tablesList.size(); j++) {
                   if(databases.get(i).tablesList.get(j).name.equals(Tname)) {
                       databases.get(i).tablesList.remove(j);
                   }
                }
            }
        }
    }
    
    public void create_database(String DBname) {
        DataBase db = new DataBase(DBname);
        databases.add(db);
    }
    
    public void create_table(String DBname, String Tname) {        
        int size = databases.size();
        for(int i=0; i<size; i++) {
            if(databases.get(i).name.equals(DBname)) {
                databases.get(i).tablesList.add(new Table(Tname));
            }
        }        
    }
    
    //TODO
    public void save(String DBname) {
        
    }
    
    public ArrayList<String[]> find(String DBname, String Tname) {
        ArrayList<Record> records = get_records(DBname, Tname);
        ArrayList<String[]> results = new ArrayList<String[]>();
        
        for(int i=0; i<records.size(); i++) {
            results.add(records.get(i).get());
        }        
        return results;
    }
    
    public ArrayList<String[]> limit(String DBname, String Tname, int num) {
        ArrayList<Record> records = get_records(DBname, Tname);
        ArrayList<String[]> results = new ArrayList<String[]>();
        
        for(int i=0; i<num; i++) {
            results.add(records.get(i).get());
        }        
        return results;
    }
    
    public ArrayList<String[]> skip(String DBname, String Tname, int num) {
        ArrayList<Record> records = get_records(DBname, Tname);
        ArrayList<String[]> results = new ArrayList<String[]>();
        
        for(int i=num; i<records.size(); i++) {
            results.add(records.get(i).get());
        }        
        return results;
    }
    
    public ArrayList<String[]> sort(String DBname, String Tname, String key, int order) {
        ArrayList<Record> records = get_records(DBname, Tname);
        ArrayList<String[]> results = new ArrayList<String[]>();
        
        for(int i=0; i<records.size(); i++) {
            results.add(records.get(i).get());
        }
        
        if(order == 1) {
            return ascending(results, key);
        } else {
            return descending(results, key);
        }
    }
    
    public void insert(String DBname, String Tname, 
            int integer, float real, long longint, char symbol, String html) {
        int size = databases.size();
        Record record = new Record(integer, real, longint, symbol, html);
        
        for(int i=0; i<size; i++) {
            if(databases.get(i).name.equals(DBname)) {
                for(int j=0; j<databases.get(i).tablesList.size(); j++) {
                   if(databases.get(i).tablesList.get(j).name.equals(Tname)) {
                       databases.get(i).tablesList.get(j).recordList.add(record);
                   }
                }
            }
        }
    }
    
    private ArrayList<Record> get_records(String DBname, String Tname) {
        int size = databases.size();
        ArrayList<Record> records = new ArrayList<Record>();
        
        for(int i=0; i<size; i++) {
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
    
    //ascending sort
    private ArrayList<String[]> ascending(ArrayList<String[]> records, String key) {
        return null;
    }
    
    //descending sort
    private ArrayList<String[]> descending(ArrayList<String[]> records, String key) {
        return null;
    }    
    
 }