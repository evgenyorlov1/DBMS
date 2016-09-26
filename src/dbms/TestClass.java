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
        
        dbms.insert("db", "table1", new Record(62,52,42,'a',"22"));//0
        dbms.insert("db", "table1", new Record(10,11,12,'b',"13"));//1
        dbms.insert("db", "table1", new Record(2,2,2,'2',"2"));//2    
        dbms.insert("db", "table1", new Record(6,6,6,'6',"6"));//3
        dbms.insert("db", "table1", new Record(4,45,4,'A',"4"));//4
        dbms.insert("db", "table1", new Record(3,3,3,'3',"3"));//5
        dbms.insert("db", "table1", new Record(5,5,5,'o',"5"));//6
        
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2); 
        nums.add(5); 
        nums.add(1); 
        nums.add(7);
        nums.add(6); 
        nums.add(4);
        nums.add(8); 
        nums.add(3);
        nums.add(9); 
        nums.add(10);
        nums.add(12); 
        nums.add(11);                            
        
        ArrayList<String[]> tbls = dbms.sort("db", "table1", "char", -1);
        
        for(int i=0; i<tbls.size(); i++) {
            System.out.println(tbls.get(i)[0] + ", " + tbls.get(i)[1] +  ", " + tbls.get(i)[2] +  ", " + tbls.get(i)[3] +  ", " + tbls.get(i)[4]); //+  ", " + tbls.get(i)[5]);
        }
    }        
}
