/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import static java.lang.System.out;

/**
 *
 * @author pc
 */
public class TableModel extends AbstractTableModel{

    private ArrayList<String[]> rows;
    private final String DBname;
    private final String Tname;
    private SingletonDBMS dbms;
    
    public TableModel(ArrayList<String[]> rows, String DBname, String Tname) {        
        super();
        this.dbms = SingletonDBMS.getInstance();
        this.DBname = DBname;
        this.Tname = Tname;
        this.rows = rows;
    }
    
    @Override
    public int getRowCount() {
        return this.rows.size();
    }

    @Override
    public int getColumnCount() {        
        return this.rows.get(0).length+1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return this.rows.get(rowIndex)[0];
            case 1:
                return this.rows.get(rowIndex)[1];
            case 2:
                return this.rows.get(rowIndex)[2];
            case 3:
                return this.rows.get(rowIndex)[3];
            case 4:
                return this.rows.get(rowIndex)[4];
            case 5:
                return false;
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        String result = "";
        switch (columnIndex) {
            case 0:
                result = "Integer";
                break;
            case 1:
                result = "Real";
                break;
            case 2:
                result = "Longint";
                break;
            case 3:
                result = "Symbol";            
                break;
            case 4:
                result = "html";
                break;
            case 5:
                result = "Delete?";
        }
        return result;        
    }   
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(rowIndex == 0) 
            return false;
        else 
            return true;                
    }
    
//    @Override
//    public Class getColumnClass(int c) {
//        switch(c) {
//            case 0:
//                return Integer.class;                
//            case 1:
//                return Float.class;
//            case 2:
//                return Long.class;
//            case 3:
//                return Character.class;
//            case 4:
//                return String.class;
//            case 5:
//                return Boolean.class;
//        }
//        return Integer.class;
//    }
    
    @Override
    public void setValueAt(Object value, int r, int c) {
        if(!this.rows.get(r)[c].equals(value.toString())) {
            this.rows.get(r)[c] = String.valueOf(value);        
            dbms.update(rows, this.DBname, this.Tname);
        }
    }
}
