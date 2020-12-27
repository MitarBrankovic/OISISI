package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listeners.FocusListener1;
import javax.swing.*;
import controller.PredmetController;
import model.BazaPredmeta;
import model.Predmet;
import model.PredmetSemestar;

public class AddPredmetFrame extends JDialog{

	private static final long serialVersionUID = 3867794288855849609L;

	private PredmetSemestar sem;
	
	public AddPredmetFrame() {
		/*setVisible je stavljen u komentar zato sto istu funkciju pozivamo u MenuKonfiguracija/Toolbar
		 *  pa da ne bi iskakala dva prozora, a da omogucimo da dijalog bude modalan*/
		
		
		setTitle("Dodavanje Predmeta");
		setSize(400, 300);
		setModal(true);
		//setVisible(true);
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
				for(Predmet pred : BazaPredmeta.getInstance().getPredmeti()) {
					if(pred.getSifraPredmeta().equals(txtSifra.getText().trim())) {
						vecPostoji = true;
					}
				}
				
				
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
				}else if(vecPostoji){
					JOptionPane.showMessageDialog(null, "Vec postoji predmet sa istom sifrom","",JOptionPane.ERROR_MESSAGE);
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
					
					PredmetController.getInstance().addPredmet(txtSifra.getText(), txtNaziv.getText(),sem, god, Integer.parseInt(txtEspb.getText()), txtPredmetniProfesor.getText());
					
					setVisible(false);
					dispose();
					
				}			
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
}
