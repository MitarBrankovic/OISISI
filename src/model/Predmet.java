package model;

import java.util.ArrayList;
import java.util.List;

//enum semestar {zimski, letnji;}

public class Predmet {
	String sifraPredmeta;
	String nazivPredmeta;
	int godinaStudija;
	//Profesor predmetniProfesor;
	String predmetniProfesor;
	int espb;
	PredmetSemestar semestar;
	List<Student> studentiPolozili;
	List<Student> studentiNisuPolozili;
	

	Predmet(){
		List<Student> studentiPolozili = new ArrayList<Student>();
		List<Student> studentiNisuPolozili = new ArrayList<Student>();
		
	}
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, PredmetSemestar sem, int godinaStudija, int espb, String predmetniProfesor) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
		this.espb = espb;
		this.semestar = sem;
		
		List<Student> studentiPolozili = new ArrayList<Student>();
		List<Student> studentiNisuPolozili = new ArrayList<Student>();
	}
	
	
	public Predmet(Predmet p) {
		this.sifraPredmeta = p.getSifraPredmeta();
		this.nazivPredmeta = p.getNazivPredmeta();
		this.godinaStudija = p.getGodinaStudija();
		this.predmetniProfesor = p.getPredmetniProfesor();
		this.espb = p.getEspb();
		this.semestar = p.getSemestar();
		
		List<Student> studentiPolozili = new ArrayList<Student>();
		List<Student> studentiNisuPolozili = new ArrayList<Student>();
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

	public String getPredmetniProfesor() {
		return predmetniProfesor;
	}

	public void setPredmetniProfesor(String predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	public PredmetSemestar getSemestar() {
		return semestar;
	}
	public void setSemestar(PredmetSemestar semestar) {
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
