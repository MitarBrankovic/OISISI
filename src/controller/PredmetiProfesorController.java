package controller;

import model.BazaProfesora;
import view.EditProfesorFrame;

public class PredmetiProfesorController {
	
	private static PredmetiProfesorController instance = null;
	
	public static PredmetiProfesorController getInstance() {
		if (instance == null) {
			instance = new PredmetiProfesorController();
		}
		return instance;
	}
	
	private PredmetiProfesorController() {}
	
	public void addPredmet(String brLicne, String sifra) {
		BazaProfesora.getInstance().dodajPredmet(sifra, brLicne);
		EditProfesorFrame.azurirajPredmete();
	}
	
	public void ukloniPredmet(String sifra, String brLicne) {
		BazaProfesora.getInstance().ukloniPredmet(sifra, brLicne);
		EditProfesorFrame.azurirajPredmete();
	}
}
