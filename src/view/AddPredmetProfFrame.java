package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.NepolozeniController;
import controller.PredmetiProfesorController;
import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Student;

public class AddPredmetProfFrame extends JDialog{

	
	private static final long serialVersionUID = 2896692937498337149L;
	
	public AddPredmetProfFrame() {
		setTitle("Dodavanje predmeta");
		setSize(300, 450);
		setModal(true);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		new BorderLayout();

		DefaultListModel<String> lista = new DefaultListModel<String>();
	    Profesor pr = new Profesor(BazaProfesora.getInstance().getRow(ProfesoriJTable.getInstance().getSelectedRow()));
		int i = 0;
		
		
		ArrayList<Predmet> sviPredmeti = new ArrayList<Predmet>();
		for(Predmet p: BazaPredmeta.getInstance().getPredmeti()) {
			sviPredmeti.add(p);
		}

		ArrayList<Predmet> predmetiPredaje = new ArrayList<Predmet>();
		for(Predmet pred : BazaProfesora.getInstance().getProfesoriPredmet()) {
			predmetiPredaje.add(pred);
		}
		
		sviPredmeti.removeAll(predmetiPredaje);
		
		for(Predmet p: sviPredmeti) {
			lista.add(i++,p.getNazivPredmeta());
		}
		
		JList<String> lista1 = new JList<String>(lista);
		lista1.setPreferredSize(new Dimension(200,300));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(lista1);
		scrollPane.createVerticalScrollBar();
		
		JPanel donjiPanel = new JPanel();
		//donjiPanel.setPreferredSize(new Dimension(450,50));
		//donjiPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton dodaj = new JButton("Potvrdi");
		JButton odustani = new JButton("Odustani");
		
		
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lista1.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null,"Oznacite predmet koji zelite da dodate!","",JOptionPane.ERROR_MESSAGE);
				}else {
					int option = JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Dodavanje ",JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						
						for(Predmet pred: BazaPredmeta.getInstance().getPredmeti()) {
							if(pred.getNazivPredmeta().equals(lista1.getSelectedValue())){
								
								PredmetiProfesorController.getInstance().addPredmet(pr.getBrojLicneKarte(), pred.getSifraPredmeta());
								setVisible(false);
							}
						}
						
					}						
				}					
			}				
		});
		
		donjiPanel.add(dodaj);
		donjiPanel.add(odustani);
		
		add(scrollPane, BorderLayout.CENTER);
		add(donjiPanel, BorderLayout.SOUTH);
	}
}
