package controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

public class SerijalizacijaController implements WindowListener{

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		JFrame frame=(JFrame) arg0.getComponent();
		int argument = JOptionPane.showConfirmDialog(frame, "Da li ste sigurni?");
		
		if(argument!=JOptionPane.YES_OPTION) {
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}else {
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			BazaStudenata.getInstance().restart();
			BazaProfesora.getInstance().restart();
			BazaPredmeta.getInstance().restart();
			
			UpisPodatakaController.getInstance().savePredmet(BazaPredmeta.getInstance().getPredmeti());
			UpisPodatakaController.getInstance().saveProfesori(BazaProfesora.getInstance().getProfesori());
			UpisPodatakaController.getInstance().saveStudenti(BazaStudenata.getInstance().getStudenti());
			UpisPodatakaController.getInstance().saveOcene(BazaOcena.getInstance().getOcene());

		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
