package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;


public class AbstractTableStudenti  extends AbstractTableModel{

	private static final long serialVersionUID = -9060819298402812975L;

	public AbstractTableStudenti() {}
	
	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return BazaStudenata.getInstance().getColumnName(column);
	}




}