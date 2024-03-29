package view;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/


import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

public class AbstractTableProfesorPredmeti extends AbstractTableModel{

	private static final long serialVersionUID = -7759782128183792134L;

	public AbstractTableProfesorPredmeti() {}
	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCountProfesoriPredmet();
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesoriPredmet().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaProfesora.getInstance().getValueAtProfesoriPredmet(row, column);
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getColumnNameProfesoriPredmet(column);
	}
	
}
