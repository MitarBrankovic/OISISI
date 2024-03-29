package view;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class StudentiJTable extends JTable{

	private static final long serialVersionUID = -612773620886765780L;
	

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
		this.setAutoCreateRowSorter(true);
		this.setModel(new AbstractTableStudenti());
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(Integer.class, centerRenderer);
        setDefaultRenderer(Double.class, centerRenderer);

	}


	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
}
