package controller;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/

import model.BazaOcena;
import model.Ocena;
import model.Predmet;
import model.PredmetSemestar;
import model.Student;
import view.EditStudentFrame;

public class NepolozeniController {

	
	private static NepolozeniController instance = null;
	
	public static NepolozeniController getInstance() {
		if (instance == null) {
			instance = new NepolozeniController();
		}
		return instance;
	}
	
	private NepolozeniController() {}
	
	
	
	public void addNepolozeni(String indeks, String sifra) {
		BazaOcena.getInstance().dodajNepolozeni(indeks, sifra);
		EditStudentFrame.azurirajNepolozene();
	}
	
	
	public void removeNepolozeni(int rowSelectedIndex) {
		Ocena oc = BazaOcena.getInstance().getRowNepolozeni(rowSelectedIndex);
		BazaOcena.getInstance().izbrisiNepolozeni(oc.getPredmet().getSifraPredmeta());
		EditStudentFrame.azurirajNepolozene();
	}
}
