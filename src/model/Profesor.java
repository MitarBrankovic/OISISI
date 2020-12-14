package model;

import java.util.List;

public class Profesor {
	String prezime;
	String ime;
	String datumRodjenja;
	String adresaStanovanja;
	int kontaktTelefon;
	String email;
	String adresaKancelarije;
	int brojLicneKarte;
	String titula;		//enum?
	String zvanje;		//enum?
	List<String> spisakPredmeta;	//spisak predmeta na kojima je profesor
	
	/*public Profesor(String prezime, String ime, String datumRodjenja, String adresaStanovanja, int kontaktTelefon,
			String email, String adresaKancelarije, int brojLicneKarte, String titula, String zvanje,
			List<String> spisakPredmeta) {
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
		this.spisakPredmeta = spisakPredmeta;
	}*/
	
	
	public Profesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, int kontaktTelefon,
			String email, String adresaKancelarije, int brojLicneKarte, String titula, String zvanje) {
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

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public int getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(int kontaktTelefon) {
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

	public int getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(int brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public List<String> getSpisakPredmeta() {
		return spisakPredmeta;
	}

	public void setSpisakPredmeta(List<String> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}
}
