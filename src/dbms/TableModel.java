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

    private ArrayList<ArrayList<String[]>> rows;
    private final String DBname;
    private final String Tname;
    private SingletonDBMS dbms;
    private final ArrayList<String[]> keyType;
    
    public TableModel(ArrayList<ArrayList<String[]>> rows, String DBname, String Tname) {        
        super();        
        System.out.println("TableModel.TableModel");
        this.dbms = SingletonDBMS.getInstance();
        this.DBname = DBname;
        this.Tname = Tname;
        this.rows = rows;
        this.keyType = dbms.get_metadata(DBname, Tname);        
    }
    
    @Override
    public int getRowCount() {
        return this.rows.size();
    }

    @Override
    public int getColumnCount() {        
        return keyType.size();//this.rows.get(0).length+1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {        
        return rows.get(rowIndex).get(columnIndex)[1];
    }
    
    @Override
    public String getColumnName(int columnIndex) {        
        return keyType.get(columnIndex)[0];        
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
//        if(!this.rows.get(r)[c].equals(value.toString())) {
//            this.rows.get(r)[c] = String.valueOf(value);        
//            dbms.update(rows, this.DBname, this.Tname);
//        }
    }
}
