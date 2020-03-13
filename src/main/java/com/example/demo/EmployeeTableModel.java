package com.example.demo;

import javax.swing.table.AbstractTableModel;

public class EmployeeTableModel extends AbstractTableModel{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] columnNames = 
					{
						"ID",
						"RFC"
					};
	
	private Object[][] data =
						{
							{ 1, "REPS890903975"}
						};

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
    
    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    
}
