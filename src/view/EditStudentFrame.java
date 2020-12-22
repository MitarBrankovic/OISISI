package view;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.NepolozeniController;
import controller.StudentiController;
import listeners.FocusListener1;
import model.BazaOcena;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Student;
import model.StudentStatus;

public class EditStudentFrame extends JDialog {

	private static final long serialVersionUID = -1126183099640299201L;

	private static EditStudentFrame instance = null;
    public static EditStudentFrame getInstance() {
        if (instance == null) {
            instance = new EditStudentFrame();
        }
        return instance;
    }
	private StudentStatus studStat;
	//private static PredmetiJTable tabelaPredmeta;
	private static PolozeniJTable tabelaPolozenih;
	private static NepolozeniJTable tabelaNepolozenih;

	
	public EditStudentFrame() {
		
		setTitle("Izmena Studenta");
		setSize(500, 650);
		setModal(true);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		
		
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
		txtIndeks.setEnabled(false);
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
		
		
		
		Student st = new Student(BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().getSelectedRow()));
		txtIme.setText(st.getIme());
		txtPrezime.setText(st.getPrezime());
		txtDatum.setText(st.getDatumRodjenja());
		txtAdresa.setText(st.getAdresa());
		txtIndeks.setText(st.getBrojIndeksa());
		txtTelefon.setText(st.getKontakt());
		txtEmail.setText(st.getEmail());
		txtDatumUpisa.setText(String.valueOf(st.getGodinaUpisa()));
		txtProsek.setText(String.valueOf(st.getProsecnaOcena()));
		
		if(st.getStatus() == StudentStatus.B) {
			status.setSelectedItem("Budžet");
		}else if (st.getStatus() == StudentStatus.S) {
			status.setSelectedItem("Samofinansiranje");			
		}		
		if(st.getTrenutnaGodina() == 1)
			godine.setSelectedItem("I (prva)");
		else if(st.getTrenutnaGodina() == 2)
			godine.setSelectedItem("II (druga)");
		else if(st.getTrenutnaGodina() == 3)
			godine.setSelectedItem("III (treca)");
		else
			godine.setSelectedItem("IV (cetvrta)");	
		validate();
		
		
		
		BazaOcena.getInstance().setIndkes(st.getBrojIndeksa());
		
		/*DefaultListModel<String> tx = new DefaultListModel<String>();
		int k = 0;
		for(Ocena o : st.getSpisakPolozenihPredmeta()) {
			tx.add(k++,o.getPredmet().getSifraPredmeta());
		}*/
		
		
		JPanel donjiPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton potvrdi = new JButton("Potvrdi");
		JButton odustani = new JButton("Odustani");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//EditStudentFrame.getInstance().setVisible(false);
				setVisible(false);
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
					studStat = StudentStatus.B;
				}else if(status1.equals("Samofinansiranje")) {
					studStat = StudentStatus.S;
				}
				
				StudentiController.getInstance().editStudent(txtIme.getText(), txtPrezime.getText(),txtDatum.getText(), txtAdresa.getText(),txtIndeks.getText(), txtTelefon.getText(),
						txtEmail.getText(),Integer.parseInt(txtDatumUpisa.getText()),god, studStat, Double.parseDouble(txtProsek.getText()));
				setVisible(false);
			}
			
			
			
		});
		
		donjiPanel.add(potvrdi);
		donjiPanel.add(odustani);
		
		
		JPanel studentInfo = new JPanel();
		
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
		
		studentInfo.add(boxStudent, BorderLayout.CENTER);
		studentInfo.add(donjiPanel, BorderLayout.SOUTH);

		
		
		
		
		
	//***************************************POLOZENI TAB************************************************	

		
		
		JPanel ponistiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ponistiPanel.setPreferredSize(new Dimension(450,50));					//malo je neprakticno
		//JSeparator sep = new JSeparator();
		//sep.setPreferredSize(new Dimension(50, 1));
		JButton ponistiButton = new JButton("Ponisti ocenu");
		//ponistiPanel.add(sep);
		
		ponistiButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(PolozeniJTable.getInstance().getSelectedRow() == -1) {
				    JOptionPane.showMessageDialog(null, "Nije selektovan ni jedan predmet","",JOptionPane.ERROR_MESSAGE);
					}else {
						int option =JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da uklonite ocenu?","Ponistavanje ocene",JOptionPane.YES_NO_OPTION);
						if(option == JOptionPane.YES_OPTION) {
							Student stud = new Student(BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().getSelectedRow()));
							Ocena ocen = new Ocena(BazaOcena.getInstance().getRowPolozeni(PolozeniJTable.getInstance().getSelectedRow()));
							Predmet pred = ocen.getPredmet();
							
							StudentiController.getInstance().ponistiOcenu(stud.getBrojIndeksa(), pred.getSifraPredmeta());
						//NepolozeniController.getInstance().removeNepolozeni(NepolozeniJTable.getInstance().getSelectedRow());
						}
						
					}				
			}			
		});
		
		ponistiPanel.add(ponistiButton);
		
		
		
		tabelaPolozenih = PolozeniJTable.getInstance();
		JScrollPane skrolPredmeti = new JScrollPane(tabelaPolozenih);
		
		JPanel prosecnaOcenaPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		prosecnaOcenaPanel.setPreferredSize(new Dimension(450,50));
		JLabel lProsecnaOcena = new JLabel("Prosecna Ocena: ");
		lProsecnaOcena.setPreferredSize(dim);
		
		double sum = 0;
		for(int i = 0; i< tabelaPolozenih.getRowCount();i++) {
			sum = sum + Integer.parseInt(tabelaPolozenih.getValueAt(i, 3).toString());
		}
		double avg = sum / tabelaPolozenih.getRowCount();
		//String avg1 = String.valueOf(avg);
		String result = String.format("%.2f", avg);
		JLabel lAvgOcena = new JLabel(result);
		
		prosecnaOcenaPanel.add(lProsecnaOcena);
		prosecnaOcenaPanel.add(lAvgOcena);
		
		
		JPanel ukupnoEspbPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ukupnoEspbPanel.setPreferredSize(new Dimension(450,50));
		JLabel lUkupnoEspb = new JLabel("Ukupno ESPB: ");
		lUkupnoEspb.setPreferredSize(dim);
		
		double sum1 = 0;
		for(int i = 0; i< tabelaPolozenih.getRowCount();i++) {
			sum1 = sum1 + Integer.parseInt(tabelaPolozenih.getValueAt(i, 2).toString());
		}
		String ukupnoEspb = String.valueOf(sum1);
		JLabel lUkupEspb = new JLabel(ukupnoEspb);
		
		ukupnoEspbPanel.add(lUkupnoEspb);
		ukupnoEspbPanel.add(lUkupEspb);
		
		
		Box boxProsecni = Box.createVerticalBox();
		boxProsecni.add(Box.createVerticalStrut(5));
		boxProsecni.add(prosecnaOcenaPanel);
		boxProsecni.add(ukupnoEspbPanel);
		boxProsecni.add(Box.createGlue());
		
		
		JPanel polozeni = new JPanel();
		polozeni.add(ponistiPanel, BorderLayout.NORTH);
		polozeni.add(skrolPredmeti, BorderLayout.CENTER);
		polozeni.add(boxProsecni, BorderLayout.SOUTH);
		
		
		
		
		
		//***************************************************************************************NEPOLOZENI TAB**************************************************************************************
		
		JPanel ponistiPanel2 = new JPanel();
		ponistiPanel2.setPreferredSize(new Dimension(450,50));
		ponistiPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton dodaj = new JButton("Dodaj");
		JButton obrisi = new JButton("Obrisi");
		JButton polaganje = new JButton("Polaganje");
		
		
		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				AddPredmetStudFrame apsf = new AddPredmetStudFrame();
				apsf.setVisible(true);
			}
			
			
			
		});
		
		
		polaganje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(NepolozeniJTable.getInstance().getSelectedRow() == -1) {
				    JOptionPane.showMessageDialog(null, "Nije selektovan ni jedan predmet","",JOptionPane.ERROR_MESSAGE);
					}else {
						UpisOceneFrame uof = new UpisOceneFrame();
						uof.setVisible(true);
					}				
					
			}
		});
		
		
	
		obrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				try {	
					int option =JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da uklonite predmet?","Uklanjanje predmeta?",JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
				
					NepolozeniController.getInstance().removeNepolozeni(NepolozeniJTable.getInstance().getSelectedRow());
					//setVisible(false);
					//StudentiController.getInstance().removeStudent(StudentiJTable.getInstance().getSelectedRow());
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Morate selektovati predmet!","",JOptionPane.ERROR_MESSAGE);
					System.out.println(e.getMessage());	
				}	
			}
			
			
			
		});
		
		ponistiPanel2.add(dodaj);
		ponistiPanel2.add(obrisi);
		ponistiPanel2.add(polaganje);

		
		
		tabelaNepolozenih = NepolozeniJTable.getInstance();
		JScrollPane skrolNepolozeni = new JScrollPane(tabelaNepolozenih);
		
		
		
		
		
		JPanel nepolozeni = new JPanel();
		nepolozeni.add(ponistiPanel2, BorderLayout.NORTH);
		nepolozeni.add(skrolNepolozeni, BorderLayout.CENTER);
		//Nepolozeni.add(boxProsecni, BorderLayout.SOUTH);
		
		

		
		JTabbedPane studentin = new JTabbedPane();
		studentin.addTab("Informacije", studentInfo);
		studentin.addTab("Polozeni", polozeni);
		studentin.addTab("Nepolozeni", nepolozeni);
		
		add(studentin, BorderLayout.CENTER);
	}
	
	public void azurirajNepolozene() {
		AbstractTableNepolozeni model=(AbstractTableNepolozeni)tabelaNepolozenih.getModel();
		model.fireTableDataChanged();
		//validate();
		
	}
	
	public void azurirajPolozene() {
		AbstractTablePolozeni model = (AbstractTablePolozeni)tabelaPolozenih.getModel();
		model.fireTableDataChanged();
	}

	
}
