/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.util.ArrayList;
import java.util.Collections;


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
        dbms.insert("db", "table1", new Record(10,11,12,'1',"13"));//1
        dbms.insert("db", "table1", new Record(2,2,2,'2',"2"));//2    
        dbms.insert("db", "table1", new Record(6,6,6,'6',"6"));//3
        dbms.insert("db", "table1", new Record(4,45,4,'4',"4"));//4
        dbms.insert("db", "table1", new Record(3,3,3,'3',"3"));//5
        dbms.insert("db", "table1", new Record(5,5,5,'5',"5"));//6
        
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
        
        ArrayList<String[]> tbls = dbms.sort("db", "table1", "integer", -1);
        
        for(int i=0; i<tbls.size(); i++) {
            System.out.println(tbls.get(i)[0] + ", " + tbls.get(i)[1] +  ", " + tbls.get(i)[2] +  ", " + tbls.get(i)[3] +  ", " + tbls.get(i)[4]); //+  ", " + tbls.get(i)[5]);
        }
    }
    
    public static void testInsertion(ArrayList<Integer> nums) {        
        for(int i=1; i < nums.size(); i++) {
            int key = nums.get(i);
            int j=i-1;            
            while(j>0) {              
                if(key<nums.get(j)) {                    
                    Collections.swap(nums, i, j);
                }
                j-=1;
            }
        }
                
        for(int i=0; i<nums.size(); i++) {
            System.out.println("elem: " + nums.get(i));
        }
    } 
    
    public static void sort(ArrayList<Integer> nums) {        
        
        
        
        
        for(int i=0; i<nums.size(); i++) {
            for(int j=0; j<nums.size(); j++) {
                    if(nums.get(i) < nums.get(j)) {
                        Collections.swap(nums, i, j);
                    }
            }
        }
        
        
        
        
        
        for(int i=0; i<nums.size(); i++) {
            System.out.println("elem: " + nums.get(i));
        }
    }
    
}
