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
public class TestClass {
        
    public static void main(String args[]) {
        DBMS dbms = new DBMS();
        dbms.create_database("db");        
        
        //ArrayList<String> tbls = dbms.show_dbs();
               
        dbms.create_table("db", "table1");     
        
        dbms.insert("db", "table1", new Record(2,2,2,'2',"2"));
        dbms.insert("db", "table1", new Record(1,1,1,'1',"1"));
        dbms.insert("db", "table1", new Record(2,2,2,'2',"2"));        
        dbms.insert("db", "table1", new Record(6,6,6,'6',"6"));
        dbms.insert("db", "table1", new Record(4,4,4,'4',"4"));
        dbms.insert("db", "table1", new Record(3,3,3,'3',"3"));
        dbms.insert("db", "table1", new Record(5,5,5,'5',"5"));
        
        
        
        ArrayList<String[]> tbls = dbms.sort("db", "table1", "integer", 1);
        
        for(int i=0; i<tbls.size(); i++) {
            System.out.println(tbls.get(i)[0] + ", " + tbls.get(i)[1] +  ", " + tbls.get(i)[2] +  ", " + tbls.get(i)[3] +  ", " + tbls.get(i)[4]); //+  ", " + tbls.get(i)[5]);
        }
    }
    
}
