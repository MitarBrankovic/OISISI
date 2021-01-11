package model;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.List;

public class Profesor {
	String prezime;
	String ime;
	LocalDate datumRodjenja;
	String adresaStanovanja;
	String kontaktTelefon;
	String email;
	String adresaKancelarije;
	String brojLicneKarte;
	//String titula;		//enum?
	ProfesorTitula titula;
	ProfesorZvanje zvanje;
	//String zvanje;		//enum?
	ArrayList<Predmet> spisakPredmeta;	//spisak predmeta na kojima je profesor
	
	
	public Profesor(String ime, String prezime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, ProfesorTitula titula, ProfesorZvanje zvanje) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		
		this.spisakPredmeta = new ArrayList<Predmet>();
	}
	
	public Profesor() {
		this.spisakPredmeta = new ArrayList<Predmet>();
	}
	
	public Profesor(Profesor p) {
		this.prezime = p.getPrezime();
		this.ime = p.getIme();
		this.datumRodjenja = p.getDatumRodjenja();
		this.adresaStanovanja = p.getAdresaStanovanja();
		this.kontaktTelefon = p.getKontaktTelefon();
		this.email = p.getEmail();
		this.adresaKancelarije = p.getAdresaKancelarije();
		this.brojLicneKarte = p.getBrojLicneKarte();
		this.titula = p.getTitula();
		this.zvanje = p.getZvanje();
	
		this.spisakPredmeta = new ArrayList<Predmet>();

	}
	
	public String getImePrezime() {			//koristi se u AddProfePredFrame
		return ime + " " + prezime;
	}
	

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public ProfesorTitula getTitula() {
		return titula;
	}

	public void setTitula(ProfesorTitula titula) {
		this.titula = titula;
	}

	public ProfesorZvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(ProfesorZvanje zvanje) {
		this.zvanje = zvanje;
	}

	public ArrayList<Predmet> getSpisakPredmeta() {
		return spisakPredmeta;
	}

	public void setSpisakPredmeta(ArrayList<Predmet> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}
}
