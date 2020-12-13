package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class AbstractTablePredmeti extends AbstractTableModel{

	public AbstractTablePredmeti() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	
}
