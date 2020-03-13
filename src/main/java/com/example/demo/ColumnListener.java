package com.example.demo;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ColumnListener implements ListSelectionListener {
	
	private JTextArea output;
	JTable table;
	
	public ColumnListener(JTable table){
		this.table = table;
	}
    public void valueChanged(ListSelectionEvent event) {
        if (event.getValueIsAdjusting()) {
            return;
        }
        output.append("COLUMN SELECTION EVENT. ");
        outputSelection();
    }
    
    private void outputSelection() {
        output.append(String.format("Lead: %d, %d. ",
                    table.getSelectionModel().getLeadSelectionIndex(),
                    table.getColumnModel().getSelectionModel().
                        getLeadSelectionIndex()));
        output.append("Rows:");
        for (int c : table.getSelectedRows()) {
            output.append(String.format(" %d", c));
        }
        output.append(". Columns:");
        for (int c : table.getSelectedColumns()) {
            output.append(String.format(" %d", c));
        }
        output.append(".\n");
    }
}