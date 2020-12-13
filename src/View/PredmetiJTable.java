package View;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PredmetiJTable extends JTable{
	private static PredmetiJTable instance = null;
	public static PredmetiJTable getInstance() {
		if(instance == null) {
			instance = new PredmetiJTable();
		}
		return instance;
	}
	
	public PredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTablePredmeti());
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
