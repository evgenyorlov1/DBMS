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
public class Table {
    
    public String name;
    ArrayList<Record> recordList = new ArrayList<Record>();
    
    public Table(String name) {
        this.name = name;        
    }
          
    public void insert(Record record) {
        recordList.add(record);
    }
    
    public ArrayList<Record> view() {
        return recordList;
    }
    
    public void delete() {}
    
    public void update() {}
    
    public void sortByKey() {}       
}
