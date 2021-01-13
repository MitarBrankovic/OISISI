package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

import controller.PredmetController;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class AddProfPredFrame extends JDialog  {

	private static final long serialVersionUID = -5279959474378525518L;
	private static int trenutniRed;
	
	Profesor objProfesor = null;
	public static String profa = null;
	
	public AddProfPredFrame() {
		
		
		setTitle("Odaberi profesora");
		setSize(300, 450);
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		new BorderLayout();

		//Predmet predm = new Predmet(BazaPredmeta.getInstance().getRow(PredmetiJTable.getInstance().getSelectedRow()));
		trenutniRed = EditPredmetFrame.getTrenutniRed();
		String editPred = (String)PredmetiJTable.getInstance().getValueAt(trenutniRed, 0);
		Predmet predm = PredmetController.getInstance().nadjiPredmet(editPred);
		
		
		DefaultListModel<String> lista = new DefaultListModel<String>();
		int i=0;
		for(Profesor prof: BazaProfesora.getInstance().getProfesori()) {
			lista.add(i++, prof.getImePrezime());
		}
		
		
		
		JList<String> lista1 = new JList<String>(lista);
		lista1.setPreferredSize(new Dimension(200,300));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(lista1);
		scrollPane.createVerticalScrollBar();
		
		

		
		JPanel donjiPanel = new JPanel();
		JButton dodaj = new JButton("Dodaj");
		
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lista1.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null,"Oznacite profesora kojeg zelite da dodate!","",JOptionPane.ERROR_MESSAGE);
				}else {
					int option = JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Dodavanje ",JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						
						for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
							if(p.getImePrezime().equals(lista1.getSelectedValue()) == true) {
								objProfesor = p;
							}
						}
						profa = objProfesor.getImePrezime();
						EditPredmetFrame.txtPredmetniProfesor.setText(profa);
						predm.setPredmetniProfesor(objProfesor);
						objProfesor.getSpisakPredmeta().add(predm);
						setVisible(false);
					}					
				}
			}	
		});
		
		
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
	
	public static String getProfa() {
		return profa;
	}

}
