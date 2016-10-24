/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author pc
 */
public class SingletonDBMSclient {
    
    private static SingletonDBMSinterface dbms = null;

    private SingletonDBMSclient() {}
    
    public static SingletonDBMSinterface getInstance() {
        if(dbms == null) {
            try {                                         
                dbms = (SingletonDBMSinterface)Naming.lookup("SingletonDBMSimplementation");;
            } catch (NotBoundException nbe) {
                System.out.println ("Error!: " + nbe);
            } catch(RemoteException re) {System.out.println ("RMI - " + re); 
            } catch(Exception e) {System.out.println ("Error - " + e);}                                
        }
        return dbms;
    }  
        
}
