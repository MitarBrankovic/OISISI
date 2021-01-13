package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import jdk.jfr.events.FileWriteEvent;
import model.Ocena;
import model.Predmet;
import model.PredmetSemestar;
import model.Profesor;
import model.ProfesorTitula;
import model.ProfesorZvanje;
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
				String profesor = "";
				if(predmet.getPredmetniProfesor() == null) {
					profesor = "null";
				}else {
					profesor = predmet.getPredmetniProfesor().getBrojLicneKarte();
				}
				StringBuilder s = new StringBuilder("");
				/*s.append(predmet.getSifraPredmeta()+", "+predmet.getNazivPredmeta()+", "+semestar+", "
						+predmet.getGodinaStudija()+", "+ predmet.getEspb() + ", " + profesor);	
				*/
				s.append(predmet.getSifraPredmeta()+", "+predmet.getNazivPredmeta()+", "+predmet.getGodinaStudija()+", "
						+predmet.getEspb()+", "+ profesor + ", " + semestar);
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
				String titula = null;
				String zvanje = null;
				
				if(profesor.getTitula() == ProfesorTitula.dr)
					titula = "DR";
				else if(profesor.getTitula() == ProfesorTitula.prof_dr)
					titula = "PROF_DR";
				else if(profesor.getTitula() == ProfesorTitula.BSc)
					titula = "BSC";
				else if(profesor.getTitula() == ProfesorTitula.MSc)
					titula = "MSC";
				
				if(profesor.getZvanje() == ProfesorZvanje.redovni_profesor)
					zvanje = "REDOVNI_PROFESOR";
				else if(profesor.getZvanje() == ProfesorZvanje.vanredni_profesor)
					zvanje = "VANREDNI_PROFESOR";
				else if(profesor.getZvanje() == ProfesorZvanje.docent)
					zvanje = "DOCENT";
				else if(profesor.getZvanje() == ProfesorZvanje.asistent)
					zvanje = "ASISTENT";
				DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

				
				StringBuilder s = new StringBuilder("");
				/*s.append(profesor.getIme() + ", " + profesor.getPrezime() + ", " + profesor.getDatumRodjenja().format(formatiran) + ", "
						+ profesor.getAdresaStanovanja() + ", " + profesor.getKontaktTelefon() + ", " + profesor.getEmail()
						+ ", " + profesor.getAdresaKancelarije() + ", " + profesor.getBrojLicneKarte() + ", " + profesor.getTitula()
						+ ", " + profesor.getZvanje());	*/
				s.append(profesor.getBrojLicneKarte() + ", " + profesor.getIme() + ", " + profesor.getPrezime() + ", " + 
						profesor.getDatumRodjenja().format(formatiran) + ", "+ profesor.getAdresaStanovanja() + ", " + 
						profesor.getKontaktTelefon() + ", " + profesor.getEmail()+ ", " + profesor.getAdresaKancelarije() + ", " + 
						titula + ", " + zvanje);
				
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
				
				//DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

				StringBuilder s = new StringBuilder("");
				/*s.append(student.getIme() + ", " + student.getPrezime() + ", " + student.getDatumRodjenja().format(formatiran) + ", " + student.getAdresa()
				 + ", " + student.getBrojIndeksa() + ", " + student.getKontakt() + ", " + student.getEmail() + ", " + student.getGodinaUpisa()
				 + ", " + student.getTrenutnaGodina() + ", " + status + ", " + student.getProsecnaOcena());	*/
				
				s.append(student.getBrojIndeksa() + ", " + student.getIme() + ", " + student.getPrezime() + ", " + 
						student.getTrenutnaGodina() + ", " + student.getDatumRodjenja().format(formatiran)
						+ ", " + student.getAdresa() + ", " + student.getKontakt() + ", " + student.getEmail() + ", " + status
						+ ", " + student.getGodinaUpisa() + ", " + student.getProsecnaOcena());
				
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
				DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				
				//String date = null;
				//if(ocena.getStudent().getBrojIndeksa() == null) {
				//	date = "null";
				//}else {
				//	date =(String) ocena.getDatumPolaganja().format(formatiran);

				//}
				String datum = null;
				if(ocena.getDatumPolaganja().format(formatiran).equals("11.11.1111.")) {
					datum = "null";
				}else {
					datum = ocena.getDatumPolaganja().format(formatiran).toString();		
				}
				
				StringBuilder s = new StringBuilder("");
				s.append(ocena.getStudent().getBrojIndeksa() + ", " + ocena.getPredmet().getSifraPredmeta() + ", " + 
						ocena.getVrednostOcene() + ", " + datum);	
				
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
