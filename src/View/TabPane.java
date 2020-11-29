package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabPane extends JTabbedPane {
		
	public TabPane() {
		
		
		
		JPanel pStudenti = new JPanel();
		JPanel pProfesori = new JPanel();
		JPanel pPredmeti = new JPanel();
		
		addTab("Studenti", pStudenti);
		addTab("Profesori", pProfesori);
		addTab("Predmeti", pPredmeti);
	}
}