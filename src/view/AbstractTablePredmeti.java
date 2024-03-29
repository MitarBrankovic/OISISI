package view;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/


import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class AbstractTablePredmeti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3599256610720218865L;

	public AbstractTablePredmeti() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		if(BazaPredmeta.getInstance().getPredmeti().isEmpty()) {
			return Object.class;
		}
		return getValueAt(0, columnIndex).getClass();
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
