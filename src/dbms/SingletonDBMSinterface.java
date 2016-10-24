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
public interface SingletonDBMSinterface extends java.rmi.Remote {  
    
    public String hello() throws java.rmi.RemoteException;
    
    public ArrayList<String> show_dbs() throws java.rmi.RemoteException;
    
    public ArrayList<String> show_tables(String DBname) throws java.rmi.RemoteException;
    
    public void drop_database(String DBname) throws java.rmi.RemoteException;
    
    public void drop_table(String DBname, String Tname) throws java.rmi.RemoteException;
    
    public void create_database(String DBname) throws java.rmi.RemoteException;
    
    public void create_table(String DBname, String Tname, ArrayList<String[]> keyType) throws java.rmi.RemoteException;
    
    public void save_serialization(String DBname, String fileName) throws java.rmi.RemoteException;
    
    public void save_serialization(String DBname, String Tname, String fileName) throws java.rmi.RemoteException;
    
    public void load_serialization(String file) throws java.rmi.RemoteException;
    
    public void load_serialization(String DBname, String file) throws java.rmi.RemoteException;   
    
    public boolean register(User login) throws java.rmi.RemoteException;
    
    public boolean login(User login) throws java.rmi.RemoteException;
    
    public ArrayList<ArrayList<String[]>> find(String DBname, String Tname) throws java.rmi.RemoteException;
    
    public ArrayList<String[]> get_metadata(String DBname, String Tname) throws java.rmi.RemoteException;
    
    public ArrayList<ArrayList<String[]>> limit(String DBname, String Tname, int num) throws java.rmi.RemoteException;
    
    public ArrayList<ArrayList<String[]>> skip(String DBname, String Tname, int num) throws java.rmi.RemoteException;
    
    public ArrayList<ArrayList<String[]>> sort(String DBname, String Tname, String key, int order) throws java.rmi.RemoteException;
    
    public int count(String DBname, String Tname) throws java.rmi.RemoteException;
    
    public void insert(String DBname, String Tname, ArrayList<String[]> keyValue) throws java.rmi.RemoteException;
    
    public void update(String _id, ArrayList<String[]> keyVal, String DBname, String Tname) throws java.rmi.RemoteException;
    
    public boolean is_unique_name(String useState) throws java.rmi.RemoteException;
    
    public void remove(String DBname, String Tname, String id) throws java.rmi.RemoteException;
    
    public void remove(String DBname, String Tname, ArrayList<String[]> keyValues) throws java.rmi.RemoteException;
    
    public ArrayList<Record> get_records(String DBname, String Tname) throws java.rmi.RemoteException;
    
    public ArrayList<ArrayList<String[]>> bubble_sort(ArrayList<Record> records, 
            Comparator camparator, String key) throws java.rmi.RemoteException;
    
    public void serialize() throws java.rmi.RemoteException;
    
    public void deserialize() throws java.rmi.RemoteException;
}
