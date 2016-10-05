/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import static java.lang.System.out;

/**
 *
 * @author pc
 */
public class TextPanel extends javax.swing.JPanel {

    
    private static String useState = "none";
    private DBMS dbms;
    private static final String none = "none";
    
    /*
     * Creates new form TextEntryPanel
     */
    public TextPanel() {
        initComponents();
        dbms = new DBMS();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        jTextPane1.setToolTipText("Enter commands");
        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnterPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EnterPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EnterPressed
              
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) && (evt.getID() == KeyEvent.KEY_PRESSED)) {
            String currentText = jTextPane1.getText();
            String lastLine = currentText.split("\n")
                    [currentText.split("\n").length-1];           
                      
            useState = QuaeryProcessor.useState(lastLine, useState);            
            Object[] command = QuaeryProcessor.parse(lastLine);  
            
            switch((int)command[0]) {                
                case 0:   
                    clear();             
                    break;                                    
                case 1:
                    try {show_dbs();} catch(Exception e) {}
                    break;                                    
                case 2:
                    use();
                    break;                                   
                case 10:
                    db();
                    break;                
                case 11:
                    try {show_tables(lastLine);} catch(Exception e) {}                    
                    break;                
                case 12:
                    try {dropDatabase(lastLine);} catch(Exception e) {}                    
                    break;                
                case 13:
                    try {createTable(command, lastLine);} catch(Exception e) {}                                            
                    break;    
                case 14:
                    try {save(lastLine);} catch(Exception e) {}
                    break;                                    
                case 101:
                    try {drop(command, lastLine);} catch(Exception e) {}              
                    break;                
                case 102:                    
                    try {find(command, lastLine);} catch(Exception e) {}                                                      
                    break;                                    
                case 1001:
                    try {limit(command, lastLine);} catch(Exception e) {}              
                    break;                
                case 1002:
                    try {sort(command, lastLine);} catch(Exception e) {}              
                    break;                
                case 1003:       
                    try {skip(command, lastLine);} catch(Exception e) {}              
                    break;                    
                case 999:                
                    try {
                        jTextPane1.getDocument().insertString(
                                jTextPane1.getText().length(), 
                                "\n".concat(lastLine.concat(" is not defined")), 
                                null);
                    } catch(Exception e) {}
            }
        }            
    }//GEN-LAST:event_EnterPressed

    private void clear() {
        System.out.println("\nclear");
        jTextPane1.setText(""); //FIX caret on second line    
    }
    
    private void show_dbs() throws Exception{
        System.out.println("\nshow dbs");
        ArrayList<String> dbs = dbms.show_dbs();  
        
        for(String db : dbs) {
            System.out.println(db);            
            jTextPane1.getDocument().insertString(jTextPane1.getText().length(), 
                "\n".concat(db), null);             
        }
    }
    
    private void use() {
        System.out.println("\nuse");
        System.out.println(useState);
        if(dbms.is_unique_name(useState))          
            dbms.create_database(useState);
        else 
            System.out.println("TextPanel.select_database");            
    }
    
    private void db() {
        System.out.println("\ndb");
        if(!useState.equals("none")) 
            jTextPane1.setText(useState + "\n");
        else 
            jTextPane1.setText("select database with use");
    }
    
    private void show_tables(String lastLine) throws Exception{
        System.out.println("\nshow tables");
        if(!useState.equals(this.none)) {
            ArrayList<String> tables = dbms.show_tables(useState);
            for(String tb : tables)             
                jTextPane1.getDocument().insertString(jTextPane1.getText().
                        length(), "\n".concat(tb), null);                                                      
        } else {           
            jTextPane1.getDocument().insertString( jTextPane1.getText().length(), 
                    "\n".concat(lastLine.concat(" - select database")), null);                                    
        }
    }
    
    private void dropDatabase(String lastLine) throws Exception{
        System.out.println("\ndropDatabase");
        if(!useState.equals(this.none)) {
            dbms.drop_database(useState);
            useState = this.none;
        } else {            
            jTextPane1.getDocument().insertString(jTextPane1.getText().length(), 
                "\n".concat(lastLine.concat(" - select database")), null);
        }    
    }
    
    private void createTable(Object[] command, String lastLine) throws Exception {
        System.out.println("\ncreateTable");
        if(!useState.equals("none")) {
            dbms.create_table(useState, (String)command[1]);
        } else {            
            jTextPane1.getDocument().insertString(jTextPane1.getText().length(), 
                "\n".concat(lastLine.concat(" - select database")), null);                                    
        }   
    }
    
    //TODO
    private void save(String lastLine) throws Exception{
        System.out.println("\nsave");
        if(!useState.equals(this.none)) {
            dbms.save(useState);
        } else {
            jTextPane1.getDocument().insertString(jTextPane1.getText().length(), 
                "\n".concat(lastLine.concat(" - select database")), null);                                    
        }    
    }
    
    //TODO
    private void drop(Object[] command, String lastLine) throws Exception{
        System.out.println("\ndrop");
        if(!useState.equals(this.none)) {
            dbms.drop_table(useState, (String)command[1]);
        } else {            
            jTextPane1.getDocument().insertString(jTextPane1.getText().length(), 
                "\n".concat(lastLine.concat(" - select database")), null);                                    
        }      
    }
    
    //TODO
    private void find(Object[] command, String lastLine) throws Exception {
        System.out.println("\nfind");
        ArrayList<String[]> results = new ArrayList<>();
        if(!useState.equals(this.none)) {            
            results = dbms.find(useState, (String)command[1]);
        } else {           
            jTextPane1.getDocument().insertString(jTextPane1.getText().length(), 
                "\n".concat(lastLine.concat(" - select database")), null);                                   
        }       
    }
    
    //TODO
    private void limit(Object[] command, String lastLine) throws Exception {
        System.out.println("\nlimit");
        ArrayList<String[]> results = new ArrayList<>();
        if(!useState.equals(this.none)) {                  
            results = dbms.limit(useState, (String)command[1], (int)command[2]);
        } else {           
            jTextPane1.getDocument().insertString(jTextPane1.getText().length(), 
                "\n".concat(lastLine.concat(" - select database")), null);                                   
        }     
    }
    
    //TODO
    private void sort(Object[] command, String lastLine) throws Exception{
        System.out.println("\nTextPanel.sort");
        ArrayList<String[]> results = new ArrayList<>();
        if(!useState.equals(this.none)) {                                
            results = dbms.sort(useState, (String)command[1], (String)command[2], (int)command[3]);
        } else {            
            jTextPane1.getDocument().insertString(jTextPane1.getText().length(), 
                "\n".concat(lastLine.concat(" - select database")), null);
        }     
    }
    
    //TODO
    private void skip(Object[] command, String lastLine) throws Exception{
        ArrayList<String[]> results = new ArrayList<>();
        if(!useState.equals(this.none)) {            
            results = dbms.skip(useState, (String)command[1], (int)command[2]);
        } else {            
            jTextPane1.getDocument().insertString(jTextPane1.getText().length(), 
                "\n".concat(lastLine.concat(" - select database")), null);                                    
        }  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
