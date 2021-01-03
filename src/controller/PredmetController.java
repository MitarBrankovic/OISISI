package controller;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/

import model.*;
import view.TabPane;

public class PredmetController {

	private static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	Profesor objProfesor = null;
	
	public void addPredmet(String sifraPredmeta, String nazivPredmeta, PredmetSemestar sem, int godinaStudija, int espb, String predmetniProfesor) 
	{
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			if(p.getImePrezime().equals(predmetniProfesor) == true) {
				objProfesor = p;
			}
		}
		BazaPredmeta.getInstance().dodajPredmet(sifraPredmeta, nazivPredmeta, sem, godinaStudija, espb, objProfesor);
		TabPane.getInstance().azurirajPredmeti();
	}
	
	
	public void editPredmet(String sifraPredmeta, String nazivPredmeta, PredmetSemestar sem, int godinaStudija, int espb, String predmetniProfesor) {
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			if(p.getImePrezime().equals(predmetniProfesor) == true) {
				objProfesor = p;
			}
		}
		BazaPredmeta.getInstance().izmeniPredmet(sifraPredmeta, nazivPredmeta, sem, godinaStudija, espb, objProfesor);
		TabPane.getInstance().azurirajPredmeti();	
	}
	
	public void removePredmet(int rowSelectedIndex) {
		Predmet pred = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		BazaPredmeta.getInstance().izbrisiPredmet(pred.getSifraPredmeta());
		TabPane.getInstance().azurirajPredmeti();
	}
	
	public void removePredmet2(String sifra) {
		BazaPredmeta.getInstance().izbrisiPredmet(sifra);
		TabPane.getInstance().azurirajPredmeti();
	}
	
	public Predmet nadjiPredmet(String sifra) {
		Predmet pred = null;
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			if(p.getSifraPredmeta().equals(sifra) == true) {
				pred = p;
			}
		}
		return pred;
	}
}
