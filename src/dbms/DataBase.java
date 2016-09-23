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
public class DataBase {
    
    public String name;
    ArrayList<Table> tablesList = new ArrayList<Table>();
    
    public DataBase(String name) {
        this.name = name;
    }            
}
