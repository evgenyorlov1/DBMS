/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JFrame;

/**
 *
 * @author pc
 */
public class ViewFrame {   
    
    public static void main (String args[]) {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("DataBase");
        mainFrame.setSize(500, 500);
        
        GroupLayout layout = new GroupLayout(mainFrame);
        mainFrame.setLayout(layout);
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.WHITE);
        
        
    }    
}
