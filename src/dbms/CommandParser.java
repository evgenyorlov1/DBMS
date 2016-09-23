/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;


import java.util.regex.*;

/**
 *
 * @author pc
 */

//TODO add regex; use state
public class CommandParser {         
    
    public static int parse(String line) {
                    
        if(clear(line)) {
            return 0;
        } else if(show_dbs(line)) {
            return 1;
        } else if(use(line)) {
            return 2;
        } else if(db(line)) {
            return 10;
        } else if(show_tables(line)) {
            return 11;
        } else if(dropDatabase(line)) {
            return 12;
        } else if(createTable(line)) {
            return 13;
        } else if(save(line)) {
            return 14;
        } else if(drop(line)) {
            return 101;
        } else if(find(line)) {
            return 102;
        } else if(limit(line)) {
            return 1001;
        } else if(sort(line)) {
            return 1002;
        } else if(skip(line)) {
            return 1003;
        } else {
            return 999;
        }        
    }         
    
    //clear 
    private static boolean clear(String testString) {  
        Pattern p = Pattern.compile("^clear$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }
    
    //show dbs 
    private static boolean show_dbs(String testString) {  
        Pattern p = Pattern.compile("^show dbs$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }
    
    //use db_name 
    private static boolean use(String testString) {  
        Pattern p = Pattern.compile("^use [a-zA-Z0-9]+$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }
    
    //db 
    private static boolean db(String testString) {  
        Pattern p = Pattern.compile("^db$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }
    
    //show tables 
    private static boolean show_tables(String testString) {  
        Pattern p = Pattern.compile("^show tables$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }
    
    //db.dropDatabase() 
    private static boolean dropDatabase(String testString) {  
        Pattern p = Pattern.compile("^db\\.dropDatabase\\(\\)$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }
    
    //db.createTable(###)
    private static boolean createTable(String testString) {  
        Pattern p = Pattern.compile("^db\\.createTable\\([a-zA-Z0-9]+\\)$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }
    
    //db.save() 
    private static boolean save(String testString) {  
        Pattern p = Pattern.compile("^db\\.save\\(\\)$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }
    
    //db.###.drop() 
    private static boolean drop(String testString) {  
        Pattern p = Pattern.compile("^db\\.[a-zA-Z0-9]+\\.drop\\(\\)$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }
    
    //db.###.find() 
    //ADD queries
    private static boolean find(String testString) {  
        Pattern p = Pattern.compile("^db\\.[a-zA-Z0-9]+\\.find\\(\\)$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }
    
    //db.###.find().limit(###) 
    private static boolean limit(String testString) {  
        Pattern p = Pattern.compile("^db\\.[a-zA-Z0-9]+\\.find\\(\\)\\.limit\\([0-9]+\\)$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }    
        
    //db.###.find().sort({key:[-1;1]}) 
    private static boolean sort(String testString) {  
        Pattern p = Pattern.compile("^db\\.[a-zA-Z0-9]+\\.find\\(\\)\\.sort\\(\\{[a-z]+\\:(-1|1)\\}\\)$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }
    
    //db.###.find().skip(###) 
    private static boolean skip(String testString) {  
        Pattern p = Pattern.compile("^db\\.[a-zA-Z0-9]+\\.find\\(\\)\\.skip\\([0-9]+\\)$");  
        Matcher m = p.matcher(testString);         
        return m.matches(); 
    }
}