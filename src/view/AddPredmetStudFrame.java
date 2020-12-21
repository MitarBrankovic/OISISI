package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.NepolozeniController;
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
		setSize(300, 450);
		setModal(true);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	
		
		new BorderLayout();

		DefaultListModel<String> lista = new DefaultListModel<String>();
		Student stud = new Student(BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().getSelectedRow()));
		int i = 0;
 
		
		
		
		ArrayList<Predmet> polozeniInepolozeni = new ArrayList<Predmet>();
		for(Ocena o : BazaOcena.getInstance().getOcenePolozeni()) {
			//if(stud.getTrenutnaGodina() >= o.getPredmet().getGodinaStudija()) {
			polozeniInepolozeni.add(o.getPredmet());
		}
		for(Ocena o : BazaOcena.getInstance().getOceneNepolozeni()) {
			polozeniInepolozeni.add(o.getPredmet());
		}
		
		
		ArrayList<Predmet> sviPredmeti = new ArrayList<Predmet>();
		
		for(Predmet p: BazaPredmeta.getInstance().getPredmeti()) {
			sviPredmeti.add(p);
		}
		
		//Collection<Predmet> razlika = CollectionUtils.substract(sviPredmeti,polozeniInepolozeni);
		
		sviPredmeti.removeAll(polozeniInepolozeni);
		
		for(Predmet p: sviPredmeti) {
			lista.add(i++,p.getNazivPredmeta());
			//lista.add(i++,String.valueOf(p.getGodinaStudija()));
		}
		

		
		//if(stud.getTrenutnaGodina() <= lista1.getSelectedValue()) {}
		
		
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
		
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lista1.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null,"Oznacite predmet koji zelite da dodate!","",JOptionPane.ERROR_MESSAGE);
				}else {
					int option = JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Dodavanje ",JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {

						for(Predmet pr: BazaPredmeta.getInstance().getPredmeti()) {
							if(pr.getNazivPredmeta().equals(lista1.getSelectedValue())){
								if(stud.getGodinaUpisa() >= pr.getGodinaStudija()) {
									NepolozeniController.getInstance().addNepolozeni(stud.getBrojIndeksa(), pr.getSifraPredmeta());
									setVisible(false);
								}
								
							}
						}
						
						
					}					
				}
			}	
		});
		
		
		
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
