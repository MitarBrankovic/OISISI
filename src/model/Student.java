package model;

import java.util.*;

//enum Status {B, S;} // budzet - samofinansiranje

public class Student {
	String ime;
	String prezime;
	String datumRodjenja;
	String adresa;
	String kontakt;
	String email;
	String brojIndeksa;
	int godinaUpisa;
	int trenutnaGodina;
	StudentStatus status;
	double prosecnaOcena;
	ArrayList<Ocena> spisakPolozenihPredmeta;
	ArrayList<Ocena> spisakNepolozenihPredmeta;
	
	
	public Student() {
		this.spisakPolozenihPredmeta = new ArrayList<Ocena>();
		this.spisakNepolozenihPredmeta = new ArrayList<Ocena>();

	}	

	public Student(String ime, String prezime, String datumRodjenja, String adresa, String indeks, String kontakt,
			String mail, int godinaUpisa, int trenutnaGodina, StudentStatus status1, double prosecnaOcena) {
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.kontakt = kontakt;
		this.email = mail;
		this.brojIndeksa = indeks;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodina = trenutnaGodina;
		this.status = status1;
		this.prosecnaOcena = prosecnaOcena;
		
		this.spisakPolozenihPredmeta = new ArrayList<Ocena>();
		this.spisakNepolozenihPredmeta = new ArrayList<Ocena>();

	}
	
	
	public Student(Student s) {
		this.ime = s.getIme();
		this.prezime = s.getPrezime();
		this.datumRodjenja = s.getDatumRodjenja();
		this.adresa = s.getAdresa();
		this.kontakt = s.getKontakt();
		this.email = s.getEmail();
		this.brojIndeksa = s.getBrojIndeksa();
		this.godinaUpisa = s.getGodinaUpisa();
		this.trenutnaGodina = s.getTrenutnaGodina();
		this.status = s.getStatus();
		this.prosecnaOcena = s.getProsecnaOcena();
		
		this.spisakPolozenihPredmeta = new ArrayList<Ocena>();
		this.spisakNepolozenihPredmeta = new ArrayList<Ocena>();
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}


	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}


	public ArrayList<Ocena> getSpisakPolozenihPredmeta() {
		return spisakPolozenihPredmeta;
	}


	public void setSpisakPolozenihPredmeta(ArrayList<Ocena> spisakPolozenihPredmeta) {
		this.spisakPolozenihPredmeta = spisakPolozenihPredmeta;
	}


	public ArrayList<Ocena> getSpisakNepolozenihPredmeta() {
		return spisakNepolozenihPredmeta;
	}


	public void setSpisakNepolozenihPredmeta(ArrayList<Ocena> spisakNepolozenihPredmeta) {
		this.spisakNepolozenihPredmeta = spisakNepolozenihPredmeta;
	}


	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getKontakt() {
		return kontakt;
	}
	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	public int getTrenutnaGodina() {
		return trenutnaGodina;
	}
	public void setTrenutnaGodina(int trenutnaGodina) {
		this.trenutnaGodina = trenutnaGodina;
	}
	public StudentStatus getStatus() {
		return status;
	}
	public void setStatus(StudentStatus status) {
		this.status = status;
	}
	public double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	
	
	
}
