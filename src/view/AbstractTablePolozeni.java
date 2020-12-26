package view;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/

import javax.swing.table.AbstractTableModel;

import model.BazaOcena;

public class AbstractTablePolozeni extends AbstractTableModel{


	private static final long serialVersionUID = 102517488993778767L;
	
	public AbstractTablePolozeni() {}

	@Override
	public int getColumnCount() {
		return BazaOcena.getInstance().getColumnCountPolozeni();
	}

	@Override
	public int getRowCount() {
		return BazaOcena.getInstance().getOcenePolozeni().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaOcena.getInstance().getValueAPolozenit(row, column);
	}

	@Override
	public String getColumnName(int column) {
		return BazaOcena.getInstance().getColumnNamePolozeni(column);
	}

}
