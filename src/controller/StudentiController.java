package controller;

import model.BazaStudenata;
import model.Student;
import model.StudentStatus;
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
}
