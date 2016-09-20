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
public class DataBase {
    
    public String name;
    ArrayList<Table> tablesList = new ArrayList<Table>();
    
    public void createTable(String DBname) {
        try {
            if(!nameHasDatabase(DBname)) 
            tablesList.add(new Table(DBname));
        } catch(Exception e) {System.out.println("DataBase.createTable: " + e);}
    }
    
    public void dropTable(String DBname) {
        try {
            for(int i=0; i<tablesList.size(); i++) {
                if(name.equals(tablesList.get(i).name)) {
                    tablesList.get(i).delete();
                }   
            }
        } catch(Exception e) {System.out.println("DataBase.dropTable: " + e);}        
    }
    
    public void serialize() {
        
    }
    
    //here can be iterator
    private boolean nameHasDatabase(String name) {
        try {
            for(int i=0; i<tablesList.size(); i++) {
                if(name.equals(tablesList.get(i).name)) {
                    return true;
                }            
            }            
        } catch(Exception e) {System.out.println("DataBase.nameHasDatabase: " + e);}
        return false; //check this
    }
    
}
