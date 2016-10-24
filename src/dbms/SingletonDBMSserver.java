/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;


import java.rmi.*;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author pc
 */
public class SingletonDBMSserver {
    public static void main(String args[]) {
        try {
            LocateRegistry.createRegistry(1099);
            SingletonDBMSimplementation dbms = new SingletonDBMSimplementation();
            Naming.rebind("SingletonDBMSimplementation", dbms);
            System.out.println("Server started");
        } catch (Exception e) {System.out.println("Error: " + e);} 
    } 
}
