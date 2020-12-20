package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Student;
import model.Ocena;

public class AddPredmetStudFrame extends JDialog{

	private static final long serialVersionUID = -3315128639685663235L;

	public AddPredmetStudFrame() {
		
		setTitle("Dodavanje predmeta");
		setSize(300, 400);
		setModal(true);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	
		
		new BorderLayout();

		DefaultListModel<String> lista = new DefaultListModel<String>();
		Student stud = new Student(BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().getSelectedRow()));
		//Predmet sviPredmeti = new Predmet(BazaPredmeta.getInstance().getPredmeti());
		int i = 0;
 
		
		ArrayList<Ocena> polInepol = new ArrayList<Ocena>();
		for(Ocena o: stud.getSpisakPolozenihPredmeta()) {
			polInepol.add(o);
			lista.add(i++,o.getPredmet().getSifraPredmeta());
		}
		for(Ocena o: stud.getSpisakNepolozenihPredmeta()) {
			polInepol.add(o);
			lista.add(i++,o.getPredmet().getSifraPredmeta());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		/*for(Predmet p: BazaPredmeta.getInstance().getPredmeti()) {
			
			
			lista.add(i++,p.getSifraPredmeta());
		}*/
		
		
		/*for(Ocena temp : stud.getSpisakPolozenihPredmeta()) {
			//if(temp.getPredmet().getSifraPredmeta() != sviPredmeti.getSifraPredmeta()) {
				//for(Ocena temp1: stud.getSpisakNepolozenihPredmeta()) {
					//if(temp1.getPredmet().getSifraPredmeta() != sviPredmeti.getSifraPredmeta()) {
						lista.add(i++,temp.getPredmet().getSifraPredmeta());
					//}
				//}
				
			//}
		}*/
		JList<String> lista1 = new JList<String>(lista);
		lista1.setPreferredSize(new Dimension(200,300));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(lista1);
		scrollPane.createVerticalScrollBar();
		
		
		JPanel donjiPanel = new JPanel();
		//donjiPanel.setPreferredSize(new Dimension(450,50));
		//donjiPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton dodaj = new JButton("Dodaj");
		JButton odustani = new JButton("Odustani");
		donjiPanel.add(dodaj);
		donjiPanel.add(odustani);
		
		add(scrollPane, BorderLayout.CENTER);
		add(donjiPanel, BorderLayout.SOUTH);
	}
}
