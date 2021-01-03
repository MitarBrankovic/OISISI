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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.PredmetController;
import controller.StudentiController;
import listeners.FocusListener1;
import model.BazaPredmeta;
import model.Predmet;
import model.PredmetSemestar;
import model.Student;

public class EditPredmetFrame extends JDialog {


	private static final long serialVersionUID = 9105513801690139962L;
	private static int trenutniRed;
	/*private static EditPredmetFrame instance = null;
    public static EditPredmetFrame getInstance() {
        if (instance == null) {
            instance = new EditPredmetFrame();
        }
        return instance;
    }*/
	public String profa = null;
	private PredmetSemestar sem;
	public static JTextField txtPredmetniProfesor;
	
	public EditPredmetFrame() {
		
		
		setTitle("Izmena Predmeta");
		setSize(440, 400);
		setModal(true);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(Glavni_Prozor.getInstance());
		
		
		
		new BorderLayout();
		Dimension dim  = new Dimension(170,20);
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
		txtPredmetniProfesor = new JTextField();
		txtPredmetniProfesor.setPreferredSize(new Dimension(130, 20));
		txtPredmetniProfesor.setName("tekst");
		txtPredmetniProfesor.setToolTipText("npr. Kosta Kovacevic");
		//txtPredmetniProfesor.addFocusListener(focus);
		
		trenutniRed = PredmetiJTable.getInstance().getSelectedRow();
		String editPred = (String)PredmetiJTable.getInstance().getValueAt(trenutniRed, 0);
		Predmet pred = PredmetController.getInstance().nadjiPredmet(editPred);
		
		JButton btnAddProfesor = new JButton("+");
		
		btnAddProfesor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(txtPredmetniProfesor.getText().isEmpty()){
					AddProfPredFrame apf = new AddProfPredFrame();
					apf.setVisible(true);
				}	
			}				
		});
		
		
		JButton btnDeleteProfesor = new JButton("-");
		
		btnDeleteProfesor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtPredmetniProfesor.setText("");
				PredmetController.getInstance().ukloniProfesora(editPred);
			}				
		});
		
		pPredmetniProfesor.add(lPredmetniProfesor);
		pPredmetniProfesor.add(txtPredmetniProfesor);
		pPredmetniProfesor.add(btnAddProfesor);
		pPredmetniProfesor.add(btnDeleteProfesor);
		
		
		
		//Predmet pred = new Predmet(BazaPredmeta.getInstance().getRow(PredmetiJTable.getInstance().getSelectedRow()));
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
		//txtPredmetniProfesor.setText(String.valueOf(pred.getPredmetniProfesor()));
		txtPredmetniProfesor.setText(pred.getPredmetniProfesor().getImePrezime());
		
		
		
		
		JPanel donjiPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton potvrdi = new JButton("Potvrdi");
		JButton odustani = new JButton("Odustani");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//dispose();
			}	
		});
		
		potvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtSifra.getText().equals("") || txtNaziv.getText().equals("") || txtEspb.getText().equals("") || txtPredmetniProfesor.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva polja!", "",JOptionPane.ERROR_MESSAGE);
				}else if(txtSifra.getText().matches("[a-žA-Ž0-9]+") == false) {
						JOptionPane.showMessageDialog(null, "Sifra nije dobro uneta","",JOptionPane.ERROR_MESSAGE);
				}else if(txtNaziv.getText().matches("[a-žA-Ž ]*[0-9]*") == false) {
					JOptionPane.showMessageDialog(null, "Naziv nije dobro unet","",JOptionPane.ERROR_MESSAGE);	
				}else if(isNumber(txtEspb.getText()) == false) {
					JOptionPane.showMessageDialog(null, "ESPB nije dobro unet","",JOptionPane.ERROR_MESSAGE);
				}else if(txtPredmetniProfesor.getText().matches("[a-žA-Ž ]*") == false) {
					JOptionPane.showMessageDialog(null, "Profesor nije dobro unet","",JOptionPane.ERROR_MESSAGE);	
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
					
					
					String semestar1 = semestri.getSelectedItem().toString();
					if(semestar1.equals("Letnji")) {
						sem = PredmetSemestar.letnji;
					}else if(semestar1.equals("Zimski")) {
						sem = PredmetSemestar.zimski;
					}
					
					PredmetController.getInstance().editPredmet(txtSifra.getText(), txtNaziv.getText(),sem, god, Integer.parseInt(txtEspb.getText()), txtPredmetniProfesor.getText());
					setVisible(false);
				}				
			}									
		});
		
		donjiPanel.add(potvrdi);
		donjiPanel.add(odustani);
		
		
		JPanel predmetInfo = new JPanel();
		
		Box boxPredmet = Box.createVerticalBox();
		boxPredmet.add(Box.createVerticalStrut(20));
		boxPredmet.add(pSifra);
		boxPredmet.add(pNaziv);
		boxPredmet.add(pSemestar);
		boxPredmet.add(pGodinaStudija);
		boxPredmet.add(pEspb);
		boxPredmet.add(pPredmetniProfesor);
		boxPredmet.add(Box.createGlue());
		
		
		predmetInfo.add(boxPredmet, BorderLayout.CENTER);
		predmetInfo.add(donjiPanel, BorderLayout.SOUTH);
		
		
			
		
		JTabbedPane predmetIn = new JTabbedPane();
		predmetIn.addTab("Informacije", predmetInfo);
		
		add(predmetIn, BorderLayout.CENTER);

		
	}
	
	public boolean isNumber(String st) {
		try {
			Integer.parseInt(st);
			return true;
		}catch(NumberFormatException ex){
			return false;
		}
	}
	
	//public void setProfa(String profa1) {
		//profa = profa1;
	//}
}
