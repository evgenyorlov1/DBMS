/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trash;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
//input:
//state -- choosed db
//command
public class CommandProcessor {
     
    
    public static void command(int command_code) {
        
        switch(command_code) {
                //clear 
                case 0:   
                    System.out.println("clear");
                    jTextPane1.setText(""); //FIX caret on second line                    
                    break;
                //show dbs 
                case 1:                     
                    System.out.println("show dbs");
                    ArrayList<String> dbs = dbms.show_dbs();
                    System.out.println(dbs.size());
                    for(int i=0; i<dbs.size(); i++) {
                        jTextPane1.setText(dbs.get(i) + "\n");
                    }                    
                    break;
                //use db_name
                //FIX can't add database
                case 2:
                    System.out.println("use");
                    System.out.println(use);
                    if(!use.equals("none")) {
                        System.out.println("TextPanel.create_table");
                        dbms.create_table(use, (String)command[1]);
                    } else {
                        System.out.println("TextPanel.database");
                        dbms.create_database(use);                    
                    }
                    break;
                //db   
                case 10:
                    System.out.println("db");
                    if(!use.equals("none")) 
                        jTextPane1.setText(use + "\n");
                    else 
                        jTextPane1.setText("select database with use");
                    break;                
                //show tables                                  
                case 11:
                    System.out.println("show tables");
                    if(!use.equals("none")) {
                        ArrayList<String> tables = dbms.show_tables(use);
                        for(int i=0; i<tables.size(); i++) {
                            jTextPane1.setText(tables.get(i) + "\n");
                        }  
                    } else {
                        try {
                            jTextPane1.getDocument().insertString(
                                    jTextPane1.getText().length(), 
                                    "\n".concat(lastLine.concat(" - select database")), 
                                    null);                        
                        } catch(Exception e) {}
                    }
                    break;
                //db.dropDatabase()                
                case 12:
                    System.out.println("dropDatabase");
                    if(!use.equals("none")) {
                        dbms.drop_database(use);
                    } else {
                        try {
                            jTextPane1.getDocument().insertString(
                                    jTextPane1.getText().length(), 
                                    "\n".concat(lastLine.concat(" - select database")), 
                                    null);                        
                        } catch(Exception e) {}
                    }                    
                    break;
                //db.createTable(###)                
                case 13:
                    System.out.println("createTable");
                    if(!use.equals("none")) {
                        dbms.create_table(use, (String)command[1]);
                    } else {
                        try {
                            jTextPane1.getDocument().insertString(
                                    jTextPane1.getText().length(), 
                                    "\n".concat(lastLine.concat(" - select database")), 
                                    null);                        
                        } catch(Exception e) {}
                    }                            
                    break;
                //db.save()    
                case 14:
                    System.out.println("save");
                    if(!use.equals("none")) {
                        dbms.save(use);
                    } else {
                        try {
                            jTextPane1.getDocument().insertString(
                                    jTextPane1.getText().length(), 
                                    "\n".concat(lastLine.concat(" - select database")), 
                                    null);                        
                        } catch(Exception e) {}
                    }        
                    break;                    
                //db.###.drop()                 
                case 101:
                    System.out.println("drop");
                    if(!use.equals("none")) {
                        dbms.drop_table(use, (String)command[1]);
                    } else {
                        try {
                            jTextPane1.getDocument().insertString(
                                    jTextPane1.getText().length(), 
                                    "\n".concat(lastLine.concat(" - select database")), 
                                    null);                        
                        } catch(Exception e) {}
                    }                            
                    break;
                //db.###.find()    
                case 102:
                    System.out.println("find");
                    if(!use.equals("none")) {
                        results.clear();
                        results = dbms.find(use, (String)command[1]);
                    } else {
                        try {
                            jTextPane1.getDocument().insertString(
                                    jTextPane1.getText().length(), 
                                    "\n".concat(lastLine.concat(" - select database")), 
                                    null);                        
                        } catch(Exception e) {}
                    }                           
                    break;                    
                //db.###.find().limit(###)                   
                case 1001:
                    System.out.println("limit");
                    if(!use.equals("none")) {
                        results.clear();                    
                        results = dbms.limit(use, (String)command[1], (int)command[2]);
                    } else {
                        try {
                            jTextPane1.getDocument().insertString(
                                    jTextPane1.getText().length(), 
                                    "\n".concat(lastLine.concat(" - select database")), 
                                    null);                        
                        } catch(Exception e) {}
                    }                    
                    break;
                //db.###.find().sort({key:[-1;1]})                 
                case 1002:
                    System.out.println("TextPanel.sort");
                    if(!use.equals("none")) {
                        results.clear();                    
                        results = dbms.sort(use, (String)command[1], (String)command[2], (int)command[3]);
                    } else {
                        try {
                            jTextPane1.getDocument().insertString(
                                    jTextPane1.getText().length(), 
                                    "\n".concat(lastLine.concat(" - select database")), 
                                    null);                        
                        } catch(Exception e) {}
                    }                                 
                    break;
                //db.###.find().skip(###)                
                case 1003:       
                    if(!use.equals("none")) {
                        results.clear();
                        results = dbms.skip(use, (String)command[1], (int)command[2]);
                    } else {
                        try {
                            jTextPane1.getDocument().insertString(
                                    jTextPane1.getText().length(), 
                                    "\n".concat(lastLine.concat(" - select database")), 
                                    null);                        
                        } catch(Exception e) {}
                    }                          
                    break;                    
                case 999:                
                    try {
                        jTextPane1.getDocument().insertString(
                                jTextPane1.getText().length(), 
                                "\n".concat(lastLine.concat(" is not defined")), 
                                null);
                    } catch(Exception e) {}
            }
    }
    
    
}
