/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author pc
 */ 
public class ViewFrame {   
    
    public static JFrame mainFrame;
    public static TablePanel tablePanel;
    public static TextPanel textEntryPanel;                        
    
    
    public static void main (String args[]) {                
        initComponents();               
    }    
    
    public static void initComponents() {
        mainFrame = new JFrame();                
        tablePanel = new TablePanel();
        textEntryPanel = new TextPanel();
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("DataBase");
        mainFrame.setSize(500, 700);
        mainFrame.setResizable(false);
        
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(textEntryPanel, BorderLayout.NORTH);
        mainFrame.add(tablePanel, BorderLayout.SOUTH);        
        
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.WHITE); 
    }
        
}
