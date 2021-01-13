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
import javax.swing.JTextField;
import controller.StudentiController;
import model.BazaOcena;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Student;

public class UpisOceneFrame extends JDialog{

	private static int trenutniRed;
	private static final long serialVersionUID = 6008224411842683502L;

	public UpisOceneFrame() {
		setTitle("Upis ocene");
		setSize(300, 250);
		setModal(true);
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
		txtDatum.setToolTipText("npr. 01.01.2020.");
		
		pDatum.add(lDatum);
		pDatum.add(txtDatum);
	    
		
		//trenutniRed = StudentiJTable.getInstance().getSelectedRow();
		trenutniRed = EditStudentFrame.getTrenutniRed();
		String editStud = (String)StudentiJTable.getInstance().getValueAt(trenutniRed, 0);
		Student stud = StudentiController.getInstance().nadjiStudenta(editStud);
		//Student stud = new Student(BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().getSelectedRow()));
		
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
				String ocena1 = ocena.getSelectedItem().toString();
				String datum = txtDatum.getText();
				DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				
				if(validDate(datum)) {
					StudentiController.getInstance().upisiOcenu(stud.getBrojIndeksa(), pred.getSifraPredmeta(), ocena1, LocalDate.parse(datum, formatiran));
					setVisible(false);
					BazaStudenata.getInstance().prosekOcena(stud);
					String result = String.format("%.2f", stud.getProsecnaOcena());
					EditStudentFrame.getAvgOcena().setText(result);
					EditStudentFrame.izracunajUkupnoEspb();
					EditStudentFrame.setProsOcena(stud.getProsecnaOcena()); 
					TabPane.getInstance().azurirajStudenti();	
				}else {
					JOptionPane.showMessageDialog(null, "Datum nije dobro unet!","",JOptionPane.ERROR_MESSAGE);

				}
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
