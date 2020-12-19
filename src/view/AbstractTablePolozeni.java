package view;

import javax.swing.table.AbstractTableModel;

import model.BazaOcena;

public class AbstractTablePolozeni extends AbstractTableModel{


	private static final long serialVersionUID = 102517488993778767L;
	
	public AbstractTablePolozeni() {}

	@Override
	public int getColumnCount() {
		return BazaOcena.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaOcena.getInstance().getOcene().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaOcena.getInstance().getValueAt(row, column);
	}

	@Override
	public String getColumnName(int column) {
		return BazaOcena.getInstance().getColumnName(column);
	}

}
