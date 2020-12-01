package controller;

import View.TabPane;
import model.BazaStudenata;
import model.StudentStatus;

public class StudentiController {

	private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}	
	
	private StudentiController() {}
	
	
	public void addStudent(String ime, String prezime, String datumRodjenja, String adresa, int indeks, int i,String mail, int godinaUpisa, int trenutnaGodina, StudentStatus status, double prosecnaOcena) 
	{
		BazaStudenata.getInstance().dodajStudenta(ime,prezime, datumRodjenja, adresa, indeks, i,mail, godinaUpisa, trenutnaGodina, status, prosecnaOcena);
		TabPane.getInstance().azurirajStudenti();
	}
	
}
