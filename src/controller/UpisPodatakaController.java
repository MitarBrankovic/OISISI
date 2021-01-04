package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import jdk.jfr.events.FileWriteEvent;
import model.Ocena;
import model.Predmet;
import model.PredmetSemestar;
import model.Profesor;
import model.Student;
import model.StudentStatus;

public class UpisPodatakaController {
	
	private static UpisPodatakaController instance = null;
	
	public static UpisPodatakaController getInstance() {
		if (instance == null) {
			instance = new UpisPodatakaController();
		}
		return instance;
	}
	
	private UpisPodatakaController() {}
	
	public void savePredmet(ArrayList<Predmet> predmeti) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("tabele" + File.separator + "Predmeti.txt"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			for (Predmet predmet : predmeti) {
				String semestar = null;
				if(predmet.getSemestar() == PredmetSemestar.letnji) {
					semestar = "LETNJI";
				}else if(predmet.getSemestar() == PredmetSemestar.zimski){
					semestar = "ZIMSKI";
				}
				StringBuilder s = new StringBuilder("");
				s.append(predmet.getSifraPredmeta()+", "+predmet.getNazivPredmeta()+", "+semestar+", "
						+predmet.getGodinaStudija()+", "+ predmet.getEspb() + ", " +predmet.getPredmetniProfesor().getImePrezime());	
				
				out.write(s.toString());
				out.write("\n");
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	public void saveProfesori(ArrayList<Profesor> profesori) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("tabele" + File.separator + "Profesori.txt"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			for (Profesor profesor : profesori) {
				
				StringBuilder s = new StringBuilder("");
				s.append(profesor.getIme() + ", " + profesor.getPrezime() + ", " + profesor.getDatumRodjenja() + ", "
						+ profesor.getAdresaStanovanja() + ", " + profesor.getKontaktTelefon() + ", " + profesor.getEmail()
						+ ", " + profesor.getAdresaKancelarije() + ", " + profesor.getBrojLicneKarte() + ", " + profesor.getTitula()
						+ ", " + profesor.getZvanje());	
				
				out.write(s.toString());
				out.write("\n");
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void saveStudenti(ArrayList<Student> studenti) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("tabele" + File.separator + "Studenti.txt"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			for (Student student : studenti) {
				String status = null;
				if(student.getStatus() == StudentStatus.B) {
					status = "B";
				}else if(student.getStatus() == StudentStatus.S) {
					status = "S";
				}
				
				DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				
				StringBuilder s = new StringBuilder("");
				s.append(student.getIme() + ", " + student.getPrezime() + ", " + student.getDatumRodjenja().format(formatiran) + ", " + student.getAdresa()
				 + ", " + student.getBrojIndeksa() + ", " + student.getKontakt() + ", " + student.getEmail() + ", " + student.getGodinaUpisa()
				 + ", " + student.getTrenutnaGodina() + ", " + status + ", " + student.getProsecnaOcena());	
				
				out.write(s.toString());
				out.write("\n");
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void saveOcene(ArrayList<Ocena> ocene) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("tabele" + File.separator + "Ocene.txt"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			for (Ocena ocena : ocene) {
				DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd-MM-yyyy");

				StringBuilder s = new StringBuilder("");
				s.append(ocena.getPredmet().getSifraPredmeta() + ", " + ocena.getStudent().getBrojIndeksa() + ", " + 
						ocena.getVrednostOcene() + ", " + ocena.getDatumPolaganja().format(formatiran));	
				
				out.write(s.toString());
				out.write("\n");
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
