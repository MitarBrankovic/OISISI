package model;

import java.util.*;

//enum Status {B, S;} // budzet - samofinansiranje

public class Student {
	String ime;
	String prezime;
	String datumRodjenja;
	String adresa;
	int kontakt;
	String email;
	int brojIndeksa;
	int godinaUpisa;
	int trenutnaGodina;
	StudentStatus status;
	double prosecnaOcena;
	List<Ocena> spisakPolozenihPredmeta;
	List<Ocena> spisakNepolozenihPredmeta;
	
	
	public Student() {}	
	
	

	public Student(String ime, String prezime, String datumRodjenja, String adresa, int kontakt, String email,
			int brojIndeksa, int godinaUpisa, int trenutnaGodina, StudentStatus status, double prosecnaOcena) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.kontakt = kontakt;
		this.email = email;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodina = trenutnaGodina;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
	}


	public Student(String ime2, String prezime2, String datumRodjenja2, String adresa2, int indeks2, int i,
			String mail2, int godinaUpisa2, int trenutnaGodina2, StudentStatus b, double prosecnaOcena2) {
		this.ime = ime2;
		this.prezime = prezime2;
		this.datumRodjenja = datumRodjenja2;
		this.adresa = adresa2;
		this.kontakt = i;
		this.email = mail2;
		this.brojIndeksa = indeks2;
		this.godinaUpisa = godinaUpisa2;
		this.trenutnaGodina = trenutnaGodina2;
		this.status = StudentStatus.B;
		this.prosecnaOcena = prosecnaOcena2;
	}

	public int getBrojIndeksa() {
		return brojIndeksa;
	}


	public void setBrojIndeksa(int brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}


	public List<Ocena> getSpisakPolozenihPredmeta() {
		return spisakPolozenihPredmeta;
	}


	public void setSpisakPolozenihPredmeta(List<Ocena> spisakPolozenihPredmeta) {
		this.spisakPolozenihPredmeta = spisakPolozenihPredmeta;
	}


	public List<Ocena> getSpisakNepolozenihPredmeta() {
		return spisakNepolozenihPredmeta;
	}


	public void setSpisakNepolozenihPredmeta(List<Ocena> spisakNepolozenihPredmeta) {
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
	public int getKontakt() {
		return kontakt;
	}
	public void setKontakt(int kontakt) {
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
