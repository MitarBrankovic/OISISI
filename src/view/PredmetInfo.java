package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import listeners.FocusListener1;
import model.BazaPredmeta;
import model.Predmet;
import model.PredmetSemestar;




public class PredmetInfo extends JPanel{

	private static final long serialVersionUID = -8584785040635552212L;
	
	private static PredmetInfo instance = null;
	public static PredmetInfo getInstance() {
		if (instance == null) {
			instance = new PredmetInfo();
		}		
		return instance;
	}
	
	private PredmetSemestar sem;
	
	public PredmetInfo() {
		new BorderLayout();
		Dimension dim  = new Dimension(150,20);
		FocusListener1 focus = new FocusListener1();
		
		JPanel pSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lSifra = new JLabel("Sifra*: ");
		lSifra.setPreferredSize(dim);
		JTextField txtSifra = new JTextField();
		txtSifra.setPreferredSize(dim);
		txtSifra.setName("tekst");
		txtSifra.setToolTipText("npr. oisisi");
		txtSifra.setEnabled(false);
		txtSifra.addFocusListener(focus);
		
		pSifra.add(lSifra);
		pSifra.add(txtSifra);
		
		
		
		JPanel pNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lNaziv = new JLabel("Naziv*: ");
		lNaziv.setPreferredSize(dim);
		JTextField txtNaziv = new JTextField();
		txtNaziv.setPreferredSize(dim);
		txtNaziv.setName("tekst");
		txtNaziv.setToolTipText("npr. Algebra");
		txtNaziv.addFocusListener(focus);
		
		pNaziv.add(lNaziv);
		pNaziv.add(txtNaziv);
		
		
		
		String [] lista = {"Letnji","Zimski"};
		JComboBox<Object> semestri = new JComboBox<Object>(lista);
	    JPanel pSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lSemestar = new JLabel("Semestar*:");
	    lSemestar.setPreferredSize(dim);
	    pSemestar.add(lSemestar);
	    pSemestar.add(semestri);
	    
	    
		String [] lista2 = {"I (prva)","II (druga)","III (treca)","IV (cetvrta)"};
		JComboBox<Object> godine = new JComboBox<Object>(lista2);
	    JPanel pGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lGodinaStudija = new JLabel("Godina studija*:");
	    lGodinaStudija.setPreferredSize(dim);
	    pGodinaStudija.add(lGodinaStudija);
	    pGodinaStudija.add(godine);
		
		
		
		
		JPanel pEspb = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lEspb = new JLabel("Espb*: ");
		lEspb.setPreferredSize(dim);
		JTextField txtEspb = new JTextField();
		txtEspb.setPreferredSize(dim);
		txtEspb.setName("tekst");
		txtEspb.setToolTipText("npr. 6");
		txtEspb.addFocusListener(focus);
		
		pEspb.add(lEspb);
		pEspb.add(txtEspb);
		
		
		
		JPanel pPredmetniProfesor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lPredmetniProfesor = new JLabel("Predmetni profesor*: ");
		lPredmetniProfesor.setPreferredSize(dim);
		JTextField txtPredmetniProfesor = new JTextField();
		txtPredmetniProfesor.setPreferredSize(dim);
		txtPredmetniProfesor.setName("tekst");
		txtPredmetniProfesor.setToolTipText("npr. Kosta Kovacevic");
		txtPredmetniProfesor.addFocusListener(focus);
		
		pPredmetniProfesor.add(lPredmetniProfesor);
		pPredmetniProfesor.add(txtPredmetniProfesor);
		
		
		
		
		Predmet pred = new Predmet(BazaPredmeta.getInstance().getRow(PredmetiJTable.getInstance().getSelectedRow()));
		txtSifra.setText(pred.getSifraPredmeta());
		txtNaziv.setText(pred.getNazivPredmeta());
		
		if(pred.getSemestar() == PredmetSemestar.letnji) {
			semestri.setSelectedItem("Letnji");
		}else if(pred.getSemestar() == PredmetSemestar.zimski)
			semestri.setSelectedItem("Zimski");
		
		if(pred.getGodinaStudija() == 1)
			godine.setSelectedItem("I (prva)");
		else if(pred.getGodinaStudija() == 2)
			godine.setSelectedItem("II (druga)");
		else if(pred.getGodinaStudija() == 3)
			godine.setSelectedItem("III (treca)");
		else
			godine.setSelectedItem("IV (cetvrta)");
		
		txtEspb.setText(String.valueOf(pred.getEspb()));
		txtPredmetniProfesor.setText(pred.getPredmetniProfesor());
		
		
		
		
		
		JPanel donjiPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton potvrdi = new JButton("Potvrdi");
		JButton odustani = new JButton("Odustani");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EditPredmetFrame.getInstance().setVisible(false);
				//dispose();
			}	
		});
		
		potvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int god;
				String godina = godine.getSelectedItem().toString();
				if(godina.equals("I (prva)")) {
					god=1;
				}else if(godina.equals("II (druga)")){
					god=2;
				}else if(godina.equals("III (treca)")){
					god=3;
				}else {
					god=4;
				}
				
				
				String semestar1 = semestri.getSelectedItem().toString();
				if(semestar1.equals("Letnji")) {
					sem = PredmetSemestar.letnji;
				}else if(semestar1.equals("Zimski")) {
					sem = PredmetSemestar.zimski;
				}
				
				PredmetController.getInstance().editPredmet(txtSifra.getText(), txtNaziv.getText(),sem, god, Integer.parseInt(txtEspb.getText()), txtPredmetniProfesor.getText());
				
				EditPredmetFrame.getInstance().setVisible(false);
				
			}
			
			
			
		});
		
		donjiPanel.add(potvrdi);
		donjiPanel.add(odustani);
		
		
		Box boxPredmet = Box.createVerticalBox();
		boxPredmet.add(Box.createVerticalStrut(20));
		boxPredmet.add(pSifra);
		boxPredmet.add(pNaziv);
		boxPredmet.add(pSemestar);
		boxPredmet.add(pGodinaStudija);
		boxPredmet.add(pEspb);
		boxPredmet.add(pPredmetniProfesor);
		boxPredmet.add(Box.createGlue());
		
		
		add(boxPredmet, BorderLayout.CENTER);
		add(donjiPanel, BorderLayout.SOUTH);
		
	}
	
}
