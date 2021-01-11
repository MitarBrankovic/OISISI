package controller;


import java.time.LocalDate;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/

import model.BazaProfesora;
import model.BazaStudenata;
import model.Profesor;
import model.ProfesorTitula;
import model.ProfesorZvanje;
import model.Student;
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
	
	
	public void addProfesor(String ime, String prezime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, ProfesorTitula titula, ProfesorZvanje zvanje) 
	{
		BazaProfesora.getInstance().dodajProfesora(ime,prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, email,adresaKancelarije, brojLicneKarte, titula, zvanje);
		TabPane.getInstance().azurirajProfesori();
	}
	
	
	public void editProfesor(String ime, String prezime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, ProfesorTitula titula, ProfesorZvanje zvanje) {
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
		TabPane.getInstance().azurirajProfesori();
	}
	
	
	public Profesor nadjiProfesora(String brLicne) {
		Profesor prof = null;
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			if(p.getBrojLicneKarte().equals(brLicne) == true) {
				prof = p;
			}
		}
		return prof;
	}
	
	public void searchProfesor(String text) {
		BazaProfesora.getInstance().searchProfesor(text);
		TabPane.getInstance().azurirajProfesori();
	}

}
