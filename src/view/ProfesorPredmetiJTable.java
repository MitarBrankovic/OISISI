package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class ProfesorPredmetiJTable extends JTable{

	
	private static final long serialVersionUID = -7770393051159002426L;

	private static ProfesorPredmetiJTable instance = null;
	public static ProfesorPredmetiJTable getInstance() {
		if(instance == null) {
			instance = new ProfesorPredmetiJTable();
		}
	return instance;
	}
	
	public ProfesorPredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setAutoCreateRowSorter(true);
		this.setModel(new AbstractTableProfesorPredmeti());
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if(isRowSelected(row))
			c.setBackground(Color.LIGHT_GRAY);
		else
			c.setBackground(Color.white);
		
		return c;
	}
}
