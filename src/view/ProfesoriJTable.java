package view;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/


import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class ProfesoriJTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1292371854849166398L;
	private static ProfesoriJTable instance = null;
	public static ProfesoriJTable getInstance() {
		if(instance == null) {
			instance = new ProfesoriJTable();
		}
	return instance;
	}
	
	public ProfesoriJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setAutoCreateRowSorter(true);
		this.setModel(new AbstractTableProfesori());
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
