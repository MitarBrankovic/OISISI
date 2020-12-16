package view;

//import java.awt.BorderLayout;
//import java.awt.Color;

//import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class TabPane extends JTabbedPane {

	private static final long serialVersionUID = -999382837272623090L;
	
	private static StudentiJTable tabelaStudenata;
	
	private static PredmetiJTable tabelaPredmeta;
	
	private static ProfesoriJTable tabelaProfesora;
	
	public static int stanje = 0;
	
	
	private static TabPane instance = null;
	
	public static TabPane getInstance() {
		if (instance == null) {
			instance = new TabPane();
		}
		return instance;
	}
	
	public TabPane() {
		
		tabelaStudenata = StudentiJTable.getInstance();
		JScrollPane skrolStudenti=new JScrollPane(tabelaStudenata);
		
		tabelaPredmeta = PredmetiJTable.getInstance();
		JScrollPane skrolPredmeti = new JScrollPane(tabelaPredmeta);
		
		tabelaProfesora = ProfesoriJTable.getInstance();
		JScrollPane skrolProfesori = new JScrollPane(tabelaProfesora);
		
		addTab("Studenti", skrolStudenti);
		addTab("Profesori", skrolProfesori);
		addTab("Predmeti", skrolPredmeti);
		
		addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("Tab: " + getSelectedIndex());
				stanje = getSelectedIndex();
				//System.out.println(stanje);
			}
		});
		}
	
	public void azurirajStudenti() {
		AbstractTableStudenti model=(AbstractTableStudenti)tabelaStudenata.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	
	public void azurirajProfesori() {
		AbstractTableProfesori model=(AbstractTableProfesori)tabelaProfesora.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	
	public void azurirajPredmeti() {
		AbstractTablePredmeti model=(AbstractTablePredmeti)tabelaPredmeta.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	
	public static int getStanje() {
		return stanje;
	}
}