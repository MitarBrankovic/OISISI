package View;

//import java.awt.BorderLayout;
//import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;



public class TabPane extends JTabbedPane {

	private static final long serialVersionUID = -999382837272623090L;
	
	private static StudentiJTable tabelaStudenata;
	
	private static PredmetiJTable tabelaPredmeta;
	
	private static ProfesoriJTable tabelaProfesora;
	
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
		
		//JPanel pStudenti = new JPanel();
		//JPanel pProfesori = new JPanel();
		//JPanel pPredmeti = new JPanel();
		
		addTab("Studenti", skrolStudenti);
		addTab("Profesori", skrolProfesori);
		addTab("Predmeti", skrolPredmeti);
		
		}
	
	public void azurirajStudenti() {
		AbstractTableStudenti model=(AbstractTableStudenti)tabelaStudenata.getModel();
		model.fireTableDataChanged();
		validate();
	}
}