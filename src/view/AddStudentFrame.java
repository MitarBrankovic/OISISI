package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listeners.FocusListener1;

import javax.swing.*;

import controller.StudentiController;
import model.*;

public class AddStudentFrame extends JDialog {
	
	private static final long serialVersionUID = -7995869934266012394L;
	private StudentStatus st;
	
	public AddStudentFrame() {
		/*setVisible je stavljen u komentar zato sto istu funkciju pozivamo u MenuKonfiguracija/Toolbar
		 *  pa da ne bi iskakala dva prozora, a da omogucimo da dijalog bude modalan*/
		
		
		setTitle("Dodavanje Studenta");
		setSize(400, 500);
		setModal(true);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		new BorderLayout();
		Dimension dim  = new Dimension(150,20);
		FocusListener1 focus = new FocusListener1();
		
		JPanel pIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lIme = new JLabel("Ime*: ");
		lIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setName("tekst");
		txtIme.setToolTipText("npr. Nikola");
		txtIme.addFocusListener(focus);
		
		pIme.add(lIme);
		pIme.add(txtIme);
		
		
		
		JPanel pPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lPrezime = new JLabel("Prezime*: ");
		lPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setName("tekst");
		txtPrezime.setToolTipText("npr. Tesla");
		txtPrezime.addFocusListener(focus);
		
		pPrezime.add(lPrezime);
		pPrezime.add(txtPrezime);
		
		
		JPanel pDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lDatum = new JLabel("DatumRodj*: ");
		lDatum.setPreferredSize(dim);
		JTextField txtDatum = new JTextField();
		txtDatum.setPreferredSize(dim);
		txtDatum.setName("tekst");
		txtDatum.setToolTipText("npr. 10.7.1856.");
		txtDatum.addFocusListener(focus);
		
		pDatum.add(lDatum);
		pDatum.add(txtDatum);
		
		
		JPanel pAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lAdresa = new JLabel("Adresa*: ");
		lAdresa.setPreferredSize(dim);
		JTextField txtAdresa = new JTextField();
		txtAdresa.setPreferredSize(dim);
		txtAdresa.setName("tekst");
		txtAdresa.setToolTipText("npr. Futoska 10");
		txtAdresa.addFocusListener(focus);
		
		pAdresa.add(lAdresa);
		pAdresa.add(txtAdresa);
		
		
		JPanel pTelefon = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lTelefon = new JLabel("Telefon*: ");
		lTelefon.setPreferredSize(dim);
		JTextField txtTelefon = new JTextField();
		txtTelefon.setPreferredSize(dim);
		txtTelefon.setName("tekst");
		txtTelefon.setToolTipText("npr. 021123456");
		txtTelefon.addFocusListener(focus);
		
		pTelefon.add(lTelefon);
		pTelefon.add(txtTelefon);
		
		
		JPanel pEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lEmail = new JLabel("Email*: ");
		lEmail.setPreferredSize(dim);
		JTextField txtEmail = new JTextField();
		txtEmail.setPreferredSize(dim);
		txtEmail.setName("tekst");
		txtEmail.setToolTipText("npr. NikolaTesla@gmail.com");
		txtEmail.addFocusListener(focus);
		
		pEmail.add(lEmail);
		pEmail.add(txtEmail);
		
		
		JPanel pIndeks = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lIndeks = new JLabel("Indeks*: ");
		lIndeks.setPreferredSize(dim);
		JTextField txtIndeks = new JTextField();
		txtIndeks.setPreferredSize(dim);
		txtIndeks.setName("tekst");
		txtIndeks.setToolTipText("npr. RA/123");
		txtIndeks.addFocusListener(focus);
		
		pIndeks.add(lIndeks);
		pIndeks.add(txtIndeks);
		
		
		
		JPanel pDatumUpisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lDatumUpisa = new JLabel("DatumUpisa*: ");
		lDatumUpisa.setPreferredSize(dim);
		JTextField txtDatumUpisa = new JTextField();
		txtDatumUpisa.setPreferredSize(dim);
		txtDatumUpisa.setName("tekst");
		txtDatumUpisa.setToolTipText("npr. 2020");
		txtDatumUpisa.addFocusListener(focus);
		
		pDatumUpisa.add(lDatumUpisa);
		pDatumUpisa.add(txtDatumUpisa);

		
		/*
		JRadioButton prva = new JRadioButton("1");
		JRadioButton druga = new JRadioButton("2");
		JRadioButton treca = new JRadioButton("3");
		JRadioButton cetvrta = new JRadioButton("4");
	    ButtonGroup godinaStudija = new ButtonGroup();
	    godinaStudija.add(prva);
	    godinaStudija.add(druga);
	    godinaStudija.add(treca);
	    godinaStudija.add(cetvrta);
	    JPanel pGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lGodinaStudija = new JLabel("Godina studija*: ");
	    pGodinaStudija.add(lGodinaStudija);
	    pGodinaStudija.add(prva);
	    pGodinaStudija.add(druga);
	    pGodinaStudija.add(treca);
	    pGodinaStudija.add(cetvrta);
		*/
		String [] lista = {"I (prva)","II (druga)","III (treca)","IV (cetvrta)"};
		JComboBox<Object> godine = new JComboBox<Object>(lista);
	    JPanel pGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lGodinaStudija = new JLabel("Godina studija*:");
	    lGodinaStudija.setPreferredSize(dim);
	    pGodinaStudija.add(lGodinaStudija);
	    pGodinaStudija.add(godine);
		
		
		/*JRadioButton budzet = new JRadioButton("Budzet");
		JRadioButton samofinansiranje = new JRadioButton("Samofinansiranje");
	    ButtonGroup status = new ButtonGroup();
	    status.add(budzet);
	    status.add(samofinansiranje);
	    JPanel pStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lStatus = new JLabel("Status*: ");
	    pStatus.add(lStatus);
	    pStatus.add(budzet);
	    pStatus.add(samofinansiranje);*/

	    
		String [] lista2 = {"Budžet","Samofinansiranje"};
		JComboBox<Object> status = new JComboBox<Object>(lista2);
	    JPanel pStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lStatus = new JLabel("Status*:");
	    lStatus.setPreferredSize(dim);
	    pStatus.add(lStatus);
	    pStatus.add(status);
		
		
		JPanel pProsek = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lProsek = new JLabel("Prosek*: ");
		lProsek.setPreferredSize(dim);
		JTextField txtProsek = new JTextField();
		txtProsek.setPreferredSize(dim);
		txtProsek.setName("tekst");
		txtProsek.setToolTipText("npr. 9.11");
		txtProsek.addFocusListener(focus);
		
		pProsek.add(lProsek);
		pProsek.add(txtProsek);	
		
		
		
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
				

				String status1 = status.getSelectedItem().toString();
				if(status1.equals("Budžet")) {
					st = StudentStatus.B;
				}else if(status1.equals("Samofinansiranje")) {
					st = StudentStatus.S;
				}
				
				StudentiController.getInstance().addStudent(txtIme.getText(), txtPrezime.getText(),txtDatum.getText(), txtAdresa.getText(), txtTelefon.getText(),
						txtEmail.getText(),txtIndeks.getText(),Integer.parseInt(txtDatumUpisa.getText()),god, st, Double.parseDouble(txtProsek.getText()));
				
				setVisible(false);
				dispose();
			}
			
			
			
		});
		
		donjiPanel.add(potvrdi);
		donjiPanel.add(odustani);
		
		
		Box boxStudent = Box.createVerticalBox();
		boxStudent.add(Box.createVerticalStrut(20));
		boxStudent.add(pIme);
		boxStudent.add(pPrezime);
		boxStudent.add(pDatum);
		boxStudent.add(pAdresa);
		boxStudent.add(pTelefon);
		boxStudent.add(pEmail);
		boxStudent.add(pIndeks);
		boxStudent.add(pDatumUpisa);
		boxStudent.add(pGodinaStudija);
		boxStudent.add(pStatus);
		boxStudent.add(pProsek);
		boxStudent.add(Box.createGlue());
		
		add(boxStudent, BorderLayout.CENTER);
		add(donjiPanel, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		
	}	
}
