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
        switch(line) {
                case "clear": return 0; //clear screen                
                
                case "show dbs": return 1; //view all available databases
                case "use ###": return 2; // FIX: use + db_name/tb_name
                case "save ###": return 3; //save database
                
                case "db": return 10; //check current database
                case "###.dropDatabase()": return 11; //drop current database
                case "db.createTable(###)": return 12; //create table in a current database
                case "show tables": return 13; //show all tables in a current database                
                
                case "db.###.drop()": return 101; //drop currnet table in a current database
                case "db.###.find()": return 102; //view table in a current database
                
                case "db.###.find().limit(###)": return 1001; //limit output to ### number
                case "db.###.find().sort(###)": return 1002; //sort by key
                case "db.###.find().skip(###)": return 1003; //skpi first ### numbers
                
                default: return 999;
        }                        
    }
}
