package view;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/


import javax.swing.table.AbstractTableModel;

import model.BazaOcena;

public class AbstractTableNepolozeni extends AbstractTableModel{

	
	private static final long serialVersionUID = 4394442920233291508L;

	//public public AbstractTableNepolozeni() {}
	
	@Override
	public int getColumnCount() {
		return BazaOcena.getInstance().getColumnCountNepolozeni();
	}

	@Override
	public int getRowCount() {
		return BazaOcena.getInstance().getOceneNepolozeni().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaOcena.getInstance().getValueAtNepolozeni(row, column);
	}

	@Override
	public String getColumnName(int column) {
		return BazaOcena.getInstance().getColumnNameNepolozeni(column);
	}

}
