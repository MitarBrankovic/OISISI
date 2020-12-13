package model;

import java.util.ArrayList;

public class BazaProfesora {
	
	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance == null) {
			instance = new BazaProfesora();
			}
		return instance;
	}
	
	private ArrayList<Profesor> profesori;
	private ArrayList<String> kolone;
	
	private BazaProfesora() {
		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("TITULA");
		this.kolone.add("ZVANJE");
		
		initProfesore();
	}

	
	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		profesori.add(new Profesor("Milankovic", "Milan", "24.3.1973", "bulevar 22", 0642233, "email@gmail.com", "L23", 000002134, "Doktor", "zvanje"));
		profesori.add(new Profesor("Jovanovic", "Jovan", "15.3.1980", "ulica 2", 0643313, "email123@gmail.com", "R43", 231312134, "drmr", "zvanje2"));
	}
	
	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}
	
	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Profesor profesori = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesori.getIme();
		case 1:
			return profesori.getPrezime();
		case 2:
			return profesori.getTitula();
		case 3:
			return profesori.getZvanje();
		
		default:
			return null;
		}
	}
	
	public void dodajProfesora(String prezime, String ime, String datumRodjenja, String adresaStanovanja, int kontaktTelefon,String email, String adresaKancelarije, int brojLicneKarte, String titula, String zvanje) {
		this.profesori.add(new Profesor(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon, email, adresaKancelarije, brojLicneKarte, titula, zvanje));
	}
	
	public void izbrisiProfesora(int indeks) {
		for(Profesor i : profesori) {
			if(i.getBrojLicneKarte() == indeks) {
				profesori.remove(indeks);
				break;
			}
		}
	}
}
