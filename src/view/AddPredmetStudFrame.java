package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.BazaOcena;
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
 
		
		//u ovu listu stavljamo sve predmete koje je student ili pao ili polozio
		ArrayList<Ocena> polozeniInepolozeni = new ArrayList<Ocena>();
		for(Ocena o : BazaOcena.getInstance().getOcenePolozeni()) {
			polozeniInepolozeni.add(o);
			lista.add(i++,o.getPredmet().getNazivPredmeta());
		}
		for(Ocena o : BazaOcena.getInstance().getOceneNepolozeni()) {
			polozeniInepolozeni.add(o);
			lista.add(i++,o.getPredmet().getNazivPredmeta());
		}
		
		/*for(Ocena oc: polozeniInepolozeni) {
			if(oc != polozeniInepolozeni)
				lista.add(i++,oc.getPredmet().getNazivPredmeta());
		}*/
		
		
		
		
		
		
		
		
		
		ArrayList<Ocena> slusaniPredmeti = new ArrayList<Ocena>();
		slusaniPredmeti.addAll(stud.getSpisakNepolozenihPredmeta());
		slusaniPredmeti.addAll(stud.getSpisakPolozenihPredmeta());
		
		//ArrayList<Predmet> sviPredmeti = new ArrayList<Predmet>();
		//sviPredmeti = BazaPredmeta.getInstance().getPredmeti();
		
		
		//sviPredmeti.removeAll(polozeniInepolozeni);
		
		
		/*//ArrayList<Ocena> nijeSlusao = new ArrayList<Ocena>();
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			for(Ocena o : polozeniInepolozeni) {
			
			}
		}
		
		for(Ocena o : polozeniInepolozeni) {
			for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
				if(o.getPredmet() == p) {
					break;
				}
			}
		}*/
		
		
		
		//Predmet sviPredmeti = new Predmet(BazaPredmeta.getInstance().getPredmeti());
		//int i = 0;
 
		
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
		
		//for(Predmet p : polozeniInepolozeni) {
			//lista.add(i++, p.getNazivPredmeta());
		//}
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
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//dispose();
			}	
		});
		donjiPanel.add(dodaj);
		donjiPanel.add(odustani);
		
		add(scrollPane, BorderLayout.CENTER);
		add(donjiPanel, BorderLayout.SOUTH);
	}
}
