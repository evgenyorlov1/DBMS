package dbms;

import java.util.ArrayList;


public class DataBase {
    
    public String name;
    ArrayList<Table> tables = new ArrayList<Table>();
    
    
    public DataBase(String name) {
        this.name = name;
    }            
}
