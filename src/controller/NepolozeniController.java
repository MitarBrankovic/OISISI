package controller;

import model.BazaOcena;
import model.Ocena;
import model.Predmet;
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
	
	
	
	public void addNepolozeni(Student s, Predmet p, int vrednostOcene, String datum) {
		BazaOcena.getInstance().dodajNepolozeni(s, p, vrednostOcene, datum);
		EditStudentFrame.getInstance().azurirajNepolozene();	
	}
	
	
	public void removeNepolozeni(int rowSelectedIndex) {
		Ocena oc = BazaOcena.getInstance().getRowNepolozeni(rowSelectedIndex);
		BazaOcena.getInstance().izbrisiNepolozeni(oc.getPredmet().getSifraPredmeta());
		EditStudentFrame.getInstance().azurirajNepolozene();
	}
}
