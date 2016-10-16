package dbms;

import java.util.ArrayList;


public class Record  {        
        
    public ArrayList<String[]> keyValue;        
    
    
    public Record(ArrayList<String[]> keyValue) {
        try {            
            this.keyValue = keyValue;
        } catch(Exception e) {System.out.println("Record.Record: " + e);}
    }                  
}