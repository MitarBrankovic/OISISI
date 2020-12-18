package controller;


import model.BazaProfesora;
import model.Profesor;
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
			String email, String adresaKancelarije, int brojLicneKarte, String titula, String zvanje) 
	{
		BazaProfesora.getInstance().dodajProfesora(ime,prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, email,adresaKancelarije, brojLicneKarte, titula, zvanje);
		TabPane.getInstance().azurirajProfesori();
	}
	
	
	public void editProfesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, int kontaktTelefon,
			String email, String adresaKancelarije, int brojLicneKarte, String titula, String zvanje) {
		BazaProfesora.getInstance().izmeniProfesora(ime,prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, email,adresaKancelarije, brojLicneKarte, titula, zvanje);
		TabPane.getInstance().azurirajProfesori();	
	}
	
	
	public void removeProfesor(int rowSelectedIndex) {
		Profesor prof = BazaProfesora.getInstance().getRow(rowSelectedIndex);
		BazaProfesora.getInstance().izbrisiProfesora(prof.getBrojLicneKarte());
		TabPane.getInstance().azurirajProfesori();
	}
}
