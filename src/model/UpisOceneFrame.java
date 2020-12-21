package model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import controller.StudentiController;
import listeners.FocusListener1;
import view.NepolozeniJTable;
import view.PredmetiJTable;
import view.StudentiJTable;

public class UpisOceneFrame extends JDialog{

	
	private static final long serialVersionUID = 6008224411842683502L;

	public UpisOceneFrame() {
		setTitle("Upis ocene");
		setSize(300, 250);
		setModal(true);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		new BorderLayout();
		Dimension dim  = new Dimension(100,20);
		
		JPanel pSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lSifra = new JLabel("Sifra*:");
		lSifra.setPreferredSize(dim);
		JTextField txtSifra = new JTextField();
		txtSifra.setEnabled(false);
		txtSifra.setPreferredSize(dim);
		txtSifra.setName("tekst");
		txtSifra.setToolTipText("npr. fiz");
		
		pSifra.add(lSifra);
		pSifra.add(txtSifra);
		
		JPanel pNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lNaziv = new JLabel("Naziv*:");
		lNaziv.setPreferredSize(dim);
		JTextField txtNaziv = new JTextField();
		txtNaziv.setEnabled(false);
		txtNaziv.setPreferredSize(dim);
		txtNaziv.setName("tekst");
		txtNaziv.setToolTipText("npr. Fizika");
		
		pNaziv.add(lNaziv);
		pNaziv.add(txtNaziv);
		
		Integer [] lista = {6,7,8,9,10};
		JComboBox<Object> ocena = new JComboBox<Object>(lista);
		JPanel pOcena = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lOcena = new JLabel("Ocena*:");
	    lOcena.setPreferredSize(dim);
	    pOcena.add(lOcena);
	    pOcena.add(ocena);
	    
	    
	    JPanel pDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lDatum = new JLabel("Datum*:");
		lDatum.setPreferredSize(dim);
		JTextField txtDatum = new JTextField();
		txtDatum.setPreferredSize(dim);
		txtDatum.setName("tekst");
		txtDatum.setToolTipText("npr. Fizika");
		
		pDatum.add(lDatum);
		pDatum.add(txtDatum);
	    
		Student stud = new Student(BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().getSelectedRow()));
		Ocena ocen = new Ocena(BazaOcena.getInstance().getRowNepolozeni(NepolozeniJTable.getInstance().getSelectedRow()));
		Predmet pred = ocen.getPredmet();
		txtSifra.setText(pred.getSifraPredmeta());
		txtNaziv.setText(pred.getNazivPredmeta());
		
		JPanel donjiPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton potvrdi = new JButton("Potvrdi");
		JButton odustani = new JButton("Odustani");
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}	
		});
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//nepolozenom predmetu dodeliti ocenu i datum i prebaciti ga u polozene
				String ocena1 = ocena.getSelectedItem().toString();
				StudentiController.getInstance().upisiOcenu(stud.getBrojIndeksa(), pred.getSifraPredmeta(), ocena1, txtDatum.getText());
				setVisible(false);
			}
		});
		
		
		donjiPanel.add(potvrdi);
		donjiPanel.add(odustani);
		
		JPanel upisOcene = new JPanel();
		
		Box boxUpis = Box.createVerticalBox();
		boxUpis.add(Box.createVerticalStrut(20));
		boxUpis.add(pSifra);
		boxUpis.add(pNaziv);
		boxUpis.add(pOcena);
		boxUpis.add(pDatum);
		boxUpis.add(Box.createGlue());
		
		upisOcene.add(boxUpis);
		upisOcene.add(donjiPanel);
		add(upisOcene);
		
	}
}
