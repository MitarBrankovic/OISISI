package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;


public class StudentiJTable extends JTable{

	private static final long serialVersionUID = -612773620886765780L;
	
	private static JTable tabela = null;
	private static StudentiJTable instance = null;
	public static StudentiJTable getInstance() {
		if (instance == null) {
			instance = new StudentiJTable();
		}
		return instance;
	}
	
	
	public StudentiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableStudenti());
		tabela = this;
	}


	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		// TODO Auto-generated method stub
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	
	public int getSelektovanRed() {
		if(tabela.getSelectedRow()!=-1)
			return tabela.convertRowIndexToModel(tabela.getSelectedRow());
		else 
			return -1;
	}
	
}
