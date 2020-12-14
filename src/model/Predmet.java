package model;

import java.util.List;

enum semestar {zimski, letnji;}

public class Predmet {
	String sifraPredmeta;
	String nazivPredmeta;
	int godinaStudija;
	//Profesor predmetniProfesor;
	String predmetniProfesor;
	int espb;
	semestar semestar;
	List<Student> studentiPolozili;
	List<Student> studentiNisuPolozili;
	
	
	
	/*public Predmet(String sifraPredmeta, String nazivPredmeta, int godinaStudija, Profesor predmetniProfesor, int espb,
			List<Student> studentiPolozili, List<Student> studentiNisuPolozili) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
		this.espb = espb;
		this.studentiPolozili = studentiPolozili;
		this.studentiNisuPolozili = studentiNisuPolozili;
	}*/
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, semestar sem, int godinaStudija, int espb, String predmetniProfesor) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
		this.espb = espb;
		this.semestar = sem;
		}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	/*public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}

	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}*/

	public semestar getSemestar() {
		return semestar;
	}
	public void setSemestar(semestar semestar) {
		this.semestar = semestar;
	}
	
	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public List<Student> getStudentiPolozili() {
		return studentiPolozili;
	}

	public void setStudentiPolozili(List<Student> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}

	public List<Student> getStudentiNisuPolozili() {
		return studentiNisuPolozili;
	}

	public void setStudentiNisuPolozili(List<Student> studentiNisuPolozili) {
		this.studentiNisuPolozili = studentiNisuPolozili;
	}
	
	
}
