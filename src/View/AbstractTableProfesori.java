package View;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.BazaStudenata;

public class AbstractTableProfesori extends AbstractTableModel{
	
	public AbstractTableProfesori() {}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getColumnName(column);
	}
	
	
}
