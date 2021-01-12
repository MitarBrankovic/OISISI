package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.PredmetiProfesorController;
import controller.ProfesoriController;
import listeners.FocusListener1;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.ProfesorTitula;
import model.ProfesorZvanje;

public class EditProfesorFrame extends JDialog{


	private static final long serialVersionUID = -4447068004097483905L;
	
	private ProfesorTitula tit;
	private ProfesorZvanje zva;
	
	private static ProfesorPredmetiJTable tabelaProfesorPredmeti;
	private static int trenutniRed;
	
	public static void azurirajPredmete() {
		AbstractTableProfesorPredmeti model=(AbstractTableProfesorPredmeti)tabelaProfesorPredmeti.getModel();
		model.fireTableDataChanged();
		//validate();
		
	}
	
	public EditProfesorFrame() {
		/*setVisible je stavljen u komentar zato sto istu funkciju pozivamo u MenuKonfiguracija/Toolbar
		 *  pa da ne bi iskakala dva prozora, a da omogucimo da dijalog bude modalan*/
		
		
		setTitle("Izmena Profesora");
		setSize(400, 500);
		setModal(true);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(Glavni_Prozor.getInstance());

		
		new BorderLayout();
		Dimension dim = new Dimension(150,20);
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
		
		
		JPanel pAdresaKancelarije = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lAdresaKancelarije = new JLabel("Adresa Kancelarije*: ");
		lAdresaKancelarije.setPreferredSize(dim);
		JTextField txtAdresaKancelarije = new JTextField();
		txtAdresaKancelarije.setPreferredSize(dim);
		txtAdresaKancelarije.setName("tekst");
		txtAdresaKancelarije.setToolTipText("npr. Futoska 10");
		txtAdresaKancelarije.addFocusListener(focus);
		
		pAdresaKancelarije.add(lAdresaKancelarije);
		pAdresaKancelarije.add(txtAdresaKancelarije);
		
		
		JPanel pLicna = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lLicna = new JLabel("Broj Licne Karte*: ");
		lLicna.setPreferredSize(dim);
		JTextField txtLicna = new JTextField();
		txtLicna.setPreferredSize(dim);
		txtLicna.setName("tekst");
		txtLicna.setToolTipText("npr. 523951123");
		txtLicna.addFocusListener(focus);
		
		pLicna.add(lLicna);
		pLicna.add(txtLicna);
		
		String [] lista1 = {"DR", "PROF_DR", "BSc", "MSc"};
		JComboBox<Object> titula = new JComboBox<Object>(lista1);
	    JPanel pTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lTitula = new JLabel("Titula*: ");
	    lTitula.setPreferredSize(dim);
	    pTitula.add(lTitula);
	    pTitula.add(titula);
	    
	    
	    String [] lista2 = {"REDOVNI_PROFESOR", "VANREDNI_PROFESOR", "DOCENT", "ASISTENT"};
		JComboBox<Object> zvanje = new JComboBox<Object>(lista2);
	    JPanel pZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lZvanje = new JLabel("Zvanje*: ");
	    lZvanje.setPreferredSize(dim);
	    pZvanje.add(lZvanje);
	    pZvanje.add(zvanje);
	    
	    trenutniRed = ProfesoriJTable.getInstance().getSelectedRow();
	    String profEdit = (String)ProfesoriJTable.getInstance().getValueAt(trenutniRed, 0);
	    
		Profesor pr = ProfesoriController.getInstance().nadjiProfesora(profEdit);
	    
		
	   // Profesor pr = new Profesor(BazaProfesora.getInstance().getRow(ProfesoriJTable.getInstance().getSelectedRow()));
		DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

		txtIme.setText(pr.getIme());
	    txtPrezime.setText(pr.getPrezime());
	    txtDatum.setText(formatiran.format(pr.getDatumRodjenja()));
	    txtAdresa.setText(pr.getAdresaStanovanja());
	    txtTelefon.setText(String.valueOf(pr.getKontaktTelefon()));
	    txtEmail.setText(pr.getEmail());
	    txtAdresaKancelarije.setText(pr.getAdresaKancelarije());
	    txtLicna.setText(String.valueOf(pr.getBrojLicneKarte()));
	    
	    titula.setSelectedItem(pr.getTitula());
	    zvanje.setSelectedItem(pr.getZvanje());

	    
		validate();
	    
	    BazaProfesora.getInstance().setBrojLicne(pr.getBrojLicneKarte());
		
		JPanel donjiPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    JButton potvrdi = new JButton("Potvrdi");
	    JButton odustani = new JButton("Odustani");
	    
	    odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
			}
		});
	    
	    
	    potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
					
					if(txtIme.getText().equals("") || txtPrezime.getText().equals("") || txtDatum.getText().equals("") || txtAdresa.getText().equals("") || 
							txtTelefon.getText().equals("") || txtEmail.getText().equals("") || txtAdresaKancelarije.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Niste popunili sva polja!", "",JOptionPane.ERROR_MESSAGE);
					}else if(txtIme.getText().matches("[A-Ž][a-ž]+") == false) {
							JOptionPane.showMessageDialog(null, "Ime nije dobro uneto","",JOptionPane.ERROR_MESSAGE);
					}else if(txtPrezime.getText().matches("[A-Ž][a-ž]+") == false) {
						JOptionPane.showMessageDialog(null, "Prezime nije dobro uneto","",JOptionPane.ERROR_MESSAGE);	
					}else if(txtAdresa.getText().trim().matches("[a-žA-Ž0-9 ]*") == false) {
						JOptionPane.showMessageDialog(null, "Adresa nije uneta kako treba!","",JOptionPane.ERROR_MESSAGE);
					}else if(validDate(txtDatum.getText()) == false) {
						JOptionPane.showMessageDialog(null, "Datum nije dobro unet","",JOptionPane.ERROR_MESSAGE);		
					}else if(isNumber(txtTelefon.getText()) == false) {
						JOptionPane.showMessageDialog(null, "Broj telefona nije dobro unet","",JOptionPane.ERROR_MESSAGE);
					}else if(txtEmail.getText().matches("[a-žA-Ž0-9.]+@[a-žA-Ž0-9.]+") == false) {
						JOptionPane.showMessageDialog(null, "Email nije dobro unet","",JOptionPane.ERROR_MESSAGE);
					}else if(txtAdresaKancelarije.getText().trim().matches("[a-žA-Ž0-9 ]*") == false) {
						JOptionPane.showMessageDialog(null, "Adresa kancelarije nije uneta kako treba!","",JOptionPane.ERROR_MESSAGE);
					}else if(txtLicna.getText().length() != 9) {
						JOptionPane.showMessageDialog(null, "Broj lične karte nije dobro unet","",JOptionPane.ERROR_MESSAGE);
					}else if(isNumber(txtLicna.getText()) == false){
						JOptionPane.showMessageDialog(null, "Licna karta sadrzi slova","",JOptionPane.ERROR_MESSAGE);
					}
					else {

						
						String titula1 = titula.getSelectedItem().toString();
						if(titula1.equals("DR")) {
							tit = ProfesorTitula.dr;
						}else if(titula1.equals("PROF_DR")) {
							tit = ProfesorTitula.prof_dr;
						}else if(titula1.equals("BSc")) {
							tit = ProfesorTitula.BSc;
						}else if(titula1.equals("MSc")) {
							tit = ProfesorTitula.MSc;
						}
						
						
						String zvanje1 = zvanje.getSelectedItem().toString();
						if(zvanje1.equals("REDOVNI_PROFESOR")) {
							zva = ProfesorZvanje.redovni_profesor;
						}else if(zvanje1.equals("VANREDNI_PROFESOR")) {
							zva = ProfesorZvanje.vanredni_profesor;
						}else if(zvanje1.equals("DOCENT")) {
							zva = ProfesorZvanje.docent;
						}else if(zvanje1.equals("ASISTENT")) {
							zva = ProfesorZvanje.asistent;
						}
						
						DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

						ProfesoriController.getInstance().editProfesor(txtIme.getText(), txtPrezime.getText(), LocalDate.parse(txtDatum.getText(), formatiran), txtAdresa.getText(), 
								txtTelefon.getText(), txtEmail.getText(), txtAdresaKancelarije.getText(), txtLicna.getText(), tit, zva);
						setVisible(false);
					}
				}
						
		});
	    
	    
	    
	    
	    
	    
	    donjiPanel.add(potvrdi);
	    donjiPanel.add(odustani);
		
		Box boxProfesor = Box.createVerticalBox();
		boxProfesor.add(Box.createVerticalStrut(10));
		boxProfesor.add(pIme);
		boxProfesor.add(pPrezime);
		boxProfesor.add(pDatum);
		boxProfesor.add(pAdresa);
		boxProfesor.add(pTelefon);
		boxProfesor.add(pEmail);
		boxProfesor.add(pAdresaKancelarije);
		boxProfesor.add(pLicna);
		boxProfesor.add(pTitula);
		boxProfesor.add(pZvanje);
		boxProfesor.add(Box.createGlue());
		//boxProfesor.add(Box.createRigidArea(new Dimension(5,0)));
		
		JPanel profesorInfo = new JPanel();
		
		profesorInfo.add(boxProfesor, BorderLayout.CENTER);
		profesorInfo.add(donjiPanel, BorderLayout.SOUTH);
		
		
		
/****************************************** predmeti koje profesor predaje *********************************/
		
		JPanel predmeti = new JPanel();
		predmeti.setPreferredSize(new Dimension(370,50));
		predmeti.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton dodaj = new JButton("Dodaj predmet");
		JButton ukloni = new JButton("Ukloni predmet");
		
		ukloni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {	
					int option =JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da uklonite predmet?","Uklanjanje predmeta?",JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						Profesor prof = new Profesor(BazaProfesora.getInstance().getRow(ProfesoriJTable.getInstance().getSelectedRow()));
						Predmet predm = new Predmet(BazaProfesora.getInstance().getRowProfesoriPredmet(ProfesorPredmetiJTable.getInstance().getSelectedRow()));

						PredmetiProfesorController.getInstance().ukloniPredmet(predm.getSifraPredmeta(), prof.getBrojLicneKarte());

					}
				}catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Morate selektovati predmet!","",JOptionPane.ERROR_MESSAGE);
					System.out.println(exc.getMessage());	
				};
			}
		});
		
		
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddPredmetProfFrame appf = new AddPredmetProfFrame();
				appf.setVisible(true);
			}
		});
		
		
		
		
		predmeti.add(dodaj);
		predmeti.add(ukloni);
		
		tabelaProfesorPredmeti = ProfesorPredmetiJTable.getInstance();
		JScrollPane skrolPredmeti = new JScrollPane(tabelaProfesorPredmeti);
		skrolPredmeti.setPreferredSize(new Dimension(370, 300));
		JPanel predmetiTab = new JPanel();
		predmetiTab.add(predmeti, BorderLayout.NORTH);
		predmetiTab.add(skrolPredmeti, BorderLayout.CENTER);
		
		JTabbedPane profesorin = new JTabbedPane();
		profesorin.add("Informacije", profesorInfo);
		profesorin.add("Predmeti", predmetiTab);
		add(profesorin, BorderLayout.CENTER);
				
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
