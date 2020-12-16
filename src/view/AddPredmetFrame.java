package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listeners.FocusListener1;
import javax.swing.*;

public class AddPredmetFrame extends JFrame{

	private static final long serialVersionUID = 3867794288855849609L;

	
	public AddPredmetFrame() {
		
		setTitle("Dodavanje Predmeta");
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
		
		
		
		
		JPanel pEpsb = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lEpsb = new JLabel("EPSB*: ");
		lEpsb.setPreferredSize(dim);
		JTextField txtEpsb = new JTextField();
		txtEpsb.setPreferredSize(dim);
		txtEpsb.setName("tekst");
		txtEpsb.setToolTipText("npr. 6");
		txtEpsb.addFocusListener(focus);
		
		pEpsb.add(lEpsb);
		pEpsb.add(txtEpsb);
		
		
		
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
		
		
		
		JPanel donjiPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton potvrdi = new JButton("Potvrdi");
		JButton odustani = new JButton("Odustani");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
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
		boxPredmet.add(pEpsb);
		boxPredmet.add(pPredmetniProfesor);
		boxPredmet.add(Box.createGlue());
		
		
		add(boxPredmet, BorderLayout.CENTER);
		add(donjiPanel, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		
		}
		
}
