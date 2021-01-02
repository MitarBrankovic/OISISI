package controller;


/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/

import model.BazaProfesora;
import model.BazaStudenata;
import model.Profesor;
import view.EditProfesorFrame;
import view.TabPane;

public class ProfesoriController {
private static ProfesoriController instance = null;
	
	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}	
	
	private ProfesoriController() {}
	
	
	public void addProfesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, int kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje) 
	{
		BazaProfesora.getInstance().dodajProfesora(ime,prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, email,adresaKancelarije, brojLicneKarte, titula, zvanje);
		TabPane.getInstance().azurirajProfesori();
	}
	
	
	public void editProfesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, int kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje) {
		BazaProfesora.getInstance().izmeniProfesora(ime,prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, email,adresaKancelarije, brojLicneKarte, titula, zvanje);
		TabPane.getInstance().azurirajProfesori();	
	}
	
	
	public void removeProfesor(int rowSelectedIndex) {
		Profesor prof = BazaProfesora.getInstance().getRow(rowSelectedIndex);
		BazaProfesora.getInstance().izbrisiProfesora(prof.getBrojLicneKarte());
		TabPane.getInstance().azurirajProfesori();
	}
	
	public void removeProfesor2(String brojLicneKarte) {
		BazaProfesora.getInstance().izbrisiProfesora(brojLicneKarte);
		TabPane.getInstance().azurirajStudenti();
	}
	
	public void ukloniPredmet(String sifra, String brLicne) {
		BazaProfesora.getInstance().ukloniPredmet(sifra, brLicne);
		EditProfesorFrame.azurirajPredmete();
	}

}
