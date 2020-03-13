package com.example.demo;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableController extends JPanel implements ActionListener {

	private JTable table;
	
	public TableController() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		table = new JTable(new EmployeeTableModel());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.getSelectionModel().addListSelectionListener(new RowListener(this.table));
        table.getColumnModel().getSelectionModel().
            addListSelectionListener(new ColumnListener(this.table));
        add(new JScrollPane(table));
	}
}

