/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

/**
 *
 * @author pc
 */
public class Comparator {
    private String key;
    private int order;
    
    public Comparator(String key, int order) {
        this.key = key;        
        this.order = order;                
    }
    
    public boolean compare(String[] arg1, String[] arg2) {        
        return (this.order == 1)? 
                ascending_order(arg1,arg2):descending_order(arg1,arg2);
    }
    
    private boolean ascending_order(String[] arg1, String[] arg2) {        
        switch(key) {
            case "integer":                
                if(Integer.parseInt(arg1[0]) > Integer.parseInt(arg2[0])) {
                    return true;
                } else {return false;}                
            case "real":
                if(Float.parseFloat(arg1[1]) > Float.parseFloat(arg2[1])) {
                    return true;
                } else {return false;}                
            case "longint":
                if(Long.parseLong(arg1[2]) > Long.parseLong(arg2[2])) {
                    return true;
                } else {return false;}
            case "char":
                if(arg1[2].charAt(0) > arg2[2].charAt(0)) {
                    return true;
                } else {return false;}
        }                
        return false;
    }
    
    private boolean descending_order(String[] arg1, String[] arg2) {
        switch(key) {
            case "integer":                
                if(Integer.parseInt(arg1[0]) < Integer.parseInt(arg2[0])) {
                    return true;
                } else {return false;}  
            case "real":
                if(Float.parseFloat(arg1[1]) < Float.parseFloat(arg2[1])) {
                    return true;
                } else {return false;}                
            case "longint":
                if(Long.parseLong(arg1[2]) < Long.parseLong(arg2[2])) {
                    return true;
                } else {return false;}
            case "char":
                if(arg1[2].charAt(0) > arg2[2].charAt(0)) {
                    return true;
                } else {return false;}                    
        }
        return false;
    }
}
