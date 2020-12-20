package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class NepolozeniJTable extends JTable {


	private static final long serialVersionUID = 3973858297808962300L;

	
	private static NepolozeniJTable instance = null;
	public static NepolozeniJTable getInstance() {
		if(instance == null) {
			instance = new NepolozeniJTable();
		}
		return instance;
	}
	
	public NepolozeniJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableNepolozeni());
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
