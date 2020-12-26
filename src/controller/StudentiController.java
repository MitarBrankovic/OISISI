package controller;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/

import model.BazaStudenata;
import model.Student;
import model.StudentStatus;
import view.EditStudentFrame;
import view.TabPane;

public class StudentiController {

	private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}	
	
	private StudentiController() {}
	
	
	public void addStudent(String ime, String prezime, String datumRodjenja, String adresa, String indeks, String kontakt,String mail, int godinaUpisa, int trenutnaGodina, StudentStatus status, double prosecnaOcena) 
	{
		BazaStudenata.getInstance().dodajStudenta(ime,prezime, datumRodjenja, adresa, indeks, kontakt,mail, godinaUpisa, trenutnaGodina, status, prosecnaOcena);
		TabPane.getInstance().azurirajStudenti();
	}
	
	
	public void editStudent(String ime, String prezime, String datumRodjenja, String adresa, String indeks, String kontakt,String mail, int godinaUpisa, int trenutnaGodina, StudentStatus status, double prosecnaOcena) {
		BazaStudenata.getInstance().izmeniStudenta(ime,prezime, datumRodjenja, adresa, indeks, kontakt,mail, godinaUpisa, trenutnaGodina, status, prosecnaOcena);
		TabPane.getInstance().azurirajStudenti();	
	}
	
	public void removeStudent(int rowSelectedIndex) {
		Student stud = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izbrisiStudenta(stud.getBrojIndeksa());
		TabPane.getInstance().azurirajStudenti();
	}
	
	public void upisiOcenu(String indeks, String sifraPredmeta, String ocena, String datum) {
		BazaStudenata.getInstance().upisiOcenu(indeks, sifraPredmeta, ocena, datum);
		EditStudentFrame.azurirajNepolozene();
		EditStudentFrame.azurirajPolozene();
	}
	
	public void ponistiOcenu(String indeks, String sifraPredmeta) {
		BazaStudenata.getInstance().ponistiOcenu(indeks, sifraPredmeta);
		EditStudentFrame.azurirajNepolozene();
		EditStudentFrame.azurirajPolozene();
		
	}
}
