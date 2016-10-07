/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class TableModel extends AbstractTableModel{

    private ArrayList<String[]> rows;
    
    public TableModel(ArrayList<String[]> rows) {
        super();
        this.rows = rows;
    }
    
    @Override
    public int getRowCount() {
        return this.rows.size();
    }

    @Override
    public int getColumnCount() {        
        return this.rows.get(0).length;
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
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        String result = "";
        switch (columnIndex) {
            case 0:
                result = "Tag1";
                break;
            case 1:
                result = "Tag2";
                break;
            case 2:
                result = "Tag3";
                break;
            case 3:
                result = "Date";            
                break;
        }
        return result;        
    }     
    
}
