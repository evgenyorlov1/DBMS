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
    public static String[] metadata = {"Integer","Real","Longint","Char","HTML"};
    
    public Table(String name) {        
        this.name = name;        
    }        
}
