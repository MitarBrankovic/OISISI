package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import listeners.FocusListener1;
import javax.swing.*;
import controller.StudentiController;
import model.*;

public class AddStudentFrame extends JDialog {
	
	private static final long serialVersionUID = -7995869934266012394L;
	private StudentStatus stat;
	
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
		JLabel lDatum = new JLabel("Datum rodjenja*: ");
		lDatum.setPreferredSize(dim);
		JTextField txtDatum = new JTextField();
		txtDatum.setPreferredSize(dim);
		txtDatum.setName("tekst");
		txtDatum.setToolTipText("npr. 10.07.1856.");
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
		txtIndeks.setToolTipText("npr. RA/132");
		txtIndeks.addFocusListener(focus);
		
		pIndeks.add(lIndeks);
		pIndeks.add(txtIndeks);
		
		
		
		JPanel pGodinaUpisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lGodinaUpisa = new JLabel("Godina upisa*: ");
		lGodinaUpisa.setPreferredSize(dim);
		JTextField txtGodinaUpisa = new JTextField();
		txtGodinaUpisa.setPreferredSize(dim);
		txtGodinaUpisa.setName("tekst");
		txtGodinaUpisa.setToolTipText("npr. 2020");
		txtGodinaUpisa.addFocusListener(focus);
		
		pGodinaUpisa.add(lGodinaUpisa);
		pGodinaUpisa.add(txtGodinaUpisa);

		
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
		
		
		/*JPanel pProsek = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lProsek = new JLabel("Prosek*: ");
		lProsek.setPreferredSize(dim);
		JTextField txtProsek = new JTextField();
		txtProsek.setPreferredSize(dim);
		txtProsek.setName("tekst");
		txtProsek.setToolTipText("npr. 9.11");
		txtProsek.addFocusListener(focus);
		
		pProsek.add(lProsek);
		pProsek.add(txtProsek);*/
		
		
		
		
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
				
				
				boolean vecPostoji = false;
				for(Student stud : BazaStudenata.getInstance().getStudenti()) {
					if(stud.getBrojIndeksa().equals(txtIndeks.getText().trim())) {
						vecPostoji = true;
					}
				}
				
				//String[] datumRodj = txtDatum.getText().split("\\.");
				//LocalDate lDate = LocalDate.of(Integer.parseInt(datumRodj[2]), Integer.parseInt(datumRodj[1]), Integer.parseInt(datumRodj[0]));
				
				
				if(txtIme.getText().equals("") || txtPrezime.getText().equals("") || txtDatum.getText().equals("") || txtAdresa.getText().equals("") || 
						txtTelefon.getText().equals("") || txtEmail.getText().equals("") || txtIndeks.getText().equals("") || txtGodinaUpisa.getText().equals(""))  {
					JOptionPane.showMessageDialog(null, "Niste popunili sva polja!", "",JOptionPane.ERROR_MESSAGE);
				}else if(txtIme.getText().matches("[A-Ž][a-ž]+") == false) {
						JOptionPane.showMessageDialog(null, "Ime nije dobro uneto","",JOptionPane.ERROR_MESSAGE);
				}else if(txtPrezime.getText().matches("[A-Ž][a-ž]+") == false) {
					JOptionPane.showMessageDialog(null, "Prezime nije dobro uneto","",JOptionPane.ERROR_MESSAGE);	
				}else if(validDate(txtDatum.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Datum nije dobro unet","",JOptionPane.ERROR_MESSAGE);	
				}else if(txtAdresa.getText().trim().matches("[a-žA-Ž0-9 ]*") == false) {
					JOptionPane.showMessageDialog(null, "Adresa nije uneta kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(isNumber(txtTelefon.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Broj telefona nije dobro unet","",JOptionPane.ERROR_MESSAGE);
				}else if(txtEmail.getText().matches("[a-žA-Ž0-9.]+@[a-žA-Ž0-9.]+") == false) {
					JOptionPane.showMessageDialog(null, "Email nije dobro unet","",JOptionPane.ERROR_MESSAGE);
				}else if(txtIndeks.getText().matches("[A-Ž]+[0-9]+/[0-9]+") == false) {
					JOptionPane.showMessageDialog(null, "Indeks nije dobro unet","",JOptionPane.ERROR_MESSAGE);
				//}else if(isNumber(txtGodinaUpisa.getText()) == false){
					//JOptionPane.showMessageDialog(null, "Godina upisa nije dobro unet","",JOptionPane.ERROR_MESSAGE);
				}else if(vecPostoji){
					JOptionPane.showMessageDialog(null, "Vec postoji student sa istim indeksom","",JOptionPane.ERROR_MESSAGE);
				}else {
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
						stat = StudentStatus.B;
					}else if(status1.equals("Samofinansiranje")) {
						stat = StudentStatus.S;
					}
					
					String datumRodj = txtDatum.getText();
					DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
					
					StudentiController.getInstance().addStudent(txtIme.getText(), txtPrezime.getText(),LocalDate.parse(datumRodj, formatiran), txtAdresa.getText(), txtIndeks.getText(),
							txtTelefon.getText(),txtEmail.getText(),Integer.parseInt(txtGodinaUpisa.getText()),god, stat, 5);
					
					setVisible(false);
					dispose();
				}
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
		boxStudent.add(pGodinaUpisa);
		boxStudent.add(pGodinaStudija);
		boxStudent.add(pStatus);
		//boxStudent.add(pProsek);
		boxStudent.add(Box.createGlue());
		
		add(boxStudent, BorderLayout.CENTER);
		add(donjiPanel, BorderLayout.SOUTH);
		
		setLocationRelativeTo(Glavni_Prozor.getInstance());
	}	
	
	
	public boolean isNumber(String st) {
		try {
			Integer.parseInt(st);
			return true;
		}catch(NumberFormatException ex){
			return false;
		}
	}
	
	public boolean validDate(String st) {
		String[] datum = st.split("\\.");
		int dan;
		int mesec;
		
		try {
			dan = Integer.parseInt(datum[0]);
		}catch(Exception e) {
			return false;
		}
		
		try {
			mesec = Integer.parseInt(datum[1]);
		}catch(Exception e) {
			return false;
		}	
		
		try {
			 Integer.parseInt(datum[2]);
		}catch(Exception e) {
			return false;
		}	
			
		if(datum[2].length() != 4) {
			return false;
		}else if(datum[2] == null) {
			return false;
		}

		
		
		if(mesec > 12 || mesec < 1) {
			return false;
		}else if(dan < 1) {
			return false;
		}else if(mesec == 2) {
			if(dan > 29) {
				return false;
			}
		}else if(mesec==1 || mesec==3 || mesec==5 || mesec==7 ||mesec==8 || mesec==10 || mesec==12) {
			if(dan>31) {
				return false;
			}
		}else if(mesec==4 || mesec==6 || mesec==9 || mesec==11) {
			if(dan>30) {
				return false;
			}
		}
		return true;
	}
}
