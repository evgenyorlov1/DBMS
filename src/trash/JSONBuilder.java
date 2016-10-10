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
public class JSONBuilder {
    
    public static final int ARRAY = 5;
    public static final int OBJECT = 4;
    public static final int NUMBER = 3;
    public static final int STRING = 2;
    public static final int BOOLEAN = 1;
    public static final int NULL = 0;    
    private String JSON = "";
    
    public JSONBuilder() {
       this.JSON = this.JSON.concat("{");     
    }
    
    public void object(String field, ArrayList<String[]> value) {
        for(String[] val : value) {
            
        }
        String record = "\n\""+field+"\""+": "+value+",";        
        JSON = JSON.concat(record);
    }
    
    public void string(String field, String value) {
        String record = "\n\""+field+"\""+": "+"\""+(String)value+"\",";        
        JSON = JSON.concat(record);
    }
    
    public void array() {}
    
    public void number(String field, float value) {
        String record = "\n\""+field+"\""+": "+value+",";        
        JSON = JSON.concat(record);
    }
        
    public void empty(String field) {
        String record = "\n\""+field+"\""+": "+null+",";              
        JSON = JSON.concat(record);
    }

    public void bool(String field, boolean value) {
        String record = "\n\""+field+"\""+": "+value+",";
        JSON = JSON.concat(record);
    }
    //DELETE last comma
    public String get_json() {          
        this.JSON = this.JSON.concat("\n}");        
        return this.JSON;
    }    
    
    
               
}
