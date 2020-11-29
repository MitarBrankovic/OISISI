package Model;

import java.util.*;

enum Status {B, S;} // budzet - samofinansiranje

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
	Status status;
	double prosecnaOcena;
	List<Ocena> spisakPolozenihPredmeta;
	List<Ocena> spisakNepolozenihPredmeta;
	
	

	public Student(String ime, String prezime, String datumRodjenja, String adresa, int kontakt, String email,
			int brojIndeksa, int godinaUpisa, int trenutnaGodina, Status status, double prosecnaOcena,
			List<Ocena> spisakPolozenihPredmeta, List<Ocena> spisakNepolozenihPredmeta) {
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
		this.spisakPolozenihPredmeta = spisakPolozenihPredmeta;
		this.spisakNepolozenihPredmeta = spisakNepolozenihPredmeta;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	
	
	
}
