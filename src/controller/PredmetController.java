package controller;

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
	
	
	public void addPredmet(String sifraPredmeta, String nazivPredmeta, PredmetSemestar sem, int godinaStudija, int espb, String predmetniProfesor) 
	{
		BazaPredmeta.getInstance().dodajPredmet(sifraPredmeta, nazivPredmeta, sem, godinaStudija, espb, predmetniProfesor);
		TabPane.getInstance().azurirajPredmeti();
	}
	
	
	public void editPredmet(String sifraPredmeta, String nazivPredmeta, PredmetSemestar sem, int godinaStudija, int espb, String predmetniProfesor) {
		BazaPredmeta.getInstance().izmeniPredmet(sifraPredmeta, nazivPredmeta, sem, godinaStudija, espb, predmetniProfesor);
		TabPane.getInstance().azurirajPredmeti();	
	}
}
