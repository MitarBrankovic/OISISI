package model;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class BazaOcena {
    
	private static BazaOcena instance = null;
	
	public static BazaOcena getInstance() {
		if(instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}
	
	
	private ArrayList<Ocena> ocene;
	private ArrayList<Ocena> tmpOcene;
	private List<String> kolonePolozeni;
	private List<String> koloneNepolozeni;
	
	private ArrayList<Ocena> listaPolozenih;
	private ArrayList<Ocena> listaNepolozenih;
	
	private BazaOcena() {
		
		this.kolonePolozeni = new ArrayList<String>();
		this.kolonePolozeni.add("SIFRA PREDMETA");
		this.kolonePolozeni.add("NAZIV PREDMETA");
		this.kolonePolozeni.add("ESPB");
		this.kolonePolozeni.add("OCENE");
		this.kolonePolozeni.add("DATUM");
		
		
		this.koloneNepolozeni = new ArrayList<String>();
		this.koloneNepolozeni.add("SIFRA PREDMETA");
		this.koloneNepolozeni.add("NAZIV PREDMETA");
		this.koloneNepolozeni.add("ESPB");
		this.koloneNepolozeni.add("GODINA STUDIJA");
		this.koloneNepolozeni.add("SEMESTAR");
		
		initOcene();
	}
	
	
	
	private void initOcene(){
		this.ocene = new ArrayList<Ocena>();
		this.tmpOcene = new ArrayList<Ocena>();

		
		String kolone[] = null;
		String naredni = null;
		String sifra = null;
		String indeks = null;
		int ocena;
		String datum = null;

		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("tabele" + File.separator + "Ocene.txt")));
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
		try {
			while((naredni = reader.readLine()) != null) {
				if(naredni.equals(""))	continue;
				
				kolone = naredni.split("\\,");
				
				Predmet objPredmet = null;
				Student objStudent = null;
				Predmet objTmpPredmet = null;
				Student objTmpStudent = null;
				
				indeks = kolone[0].trim();
				sifra = kolone[1].trim();
				ocena = Integer.parseInt(kolone[2].trim());
				datum = kolone[3].trim();

				DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				
				/*if(datum.equals("null")) {
					datum = "11.11.1111.";
				}*/
				
				for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
					if(p.getSifraPredmeta().equals(sifra) == true) {
						objPredmet = p;
					}
				}
				
				for(Student s : BazaStudenata.getInstance().getStudenti()) {
					if(s.getBrojIndeksa().equals(indeks) == true) {
						objTmpStudent = s;
					}
				}
				
				for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
					if(p.getSifraPredmeta().equals(sifra) == true) {
						objTmpPredmet = p;
					}
				}
				
				for(Student s : BazaStudenata.getInstance().getStudenti()) {
					if(s.getBrojIndeksa().equals(indeks) == true) {
						objStudent = s;
					}
				}
				
				
				Ocena objOcena = new Ocena(objStudent, objPredmet, ocena, LocalDate.parse(datum, formatiran));
				ocene.add(objOcena);
				Ocena objTmpOcena = new Ocena(objTmpStudent, objTmpPredmet, ocena, LocalDate.parse(datum, formatiran));
				tmpOcene.add(objTmpOcena);
				
			}
			reader.close();
		}catch(IOException exception) {
			exception.printStackTrace();
		}
		
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("tabele" + File.separator + "NepolozeniPredmeti.txt")));
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
		try {
			while((naredni = reader.readLine()) != null) {
				if(naredni.equals(""))	continue;
				
				kolone = naredni.split("\\,");
				
				Predmet objPredmet = null;
				Student objStudent = null;
				Predmet objTmpPredmet = null;
				Student objTmpStudent = null;
				
				indeks = kolone[0].trim();
				sifra = kolone[1].trim();
				
				ocena = 5;
				datum = "11.11.1111.";
				DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				
				
				for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
					if(p.getSifraPredmeta().equals(sifra) == true) {
						objPredmet = p;
					}
				}
				
				for(Student s : BazaStudenata.getInstance().getStudenti()) {
					if(s.getBrojIndeksa().equals(indeks) == true) {
						objTmpStudent = s;
					}
				}
				
				for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
					if(p.getSifraPredmeta().equals(sifra) == true) {
						objTmpPredmet = p;
					}
				}
				
				for(Student s : BazaStudenata.getInstance().getStudenti()) {
					if(s.getBrojIndeksa().equals(indeks) == true) {
						objStudent = s;
					}
				}
				
				
				Ocena objOcena = new Ocena(objStudent, objPredmet, ocena, LocalDate.parse(datum, formatiran));
				ocene.add(objOcena);
				Ocena objTmpOcena = new Ocena(objTmpStudent, objTmpPredmet, ocena, LocalDate.parse(datum, formatiran));
				tmpOcene.add(objTmpOcena);
				
			}
			reader.close();
		}catch(IOException exception) {
			exception.printStackTrace();
		}
		
		for(Student s : BazaStudenata.getInstance().getStudenti()) {
			ArrayList<Ocena> spisakPolozenihStudent = new ArrayList<Ocena>();
			ArrayList<Ocena> spisakNepolozenihStudent = new ArrayList<Ocena>();

			for(Ocena o : ocene) {
				if(o.getStudent() == s) {
					if(o.getVrednostOcene() > 5) {
						spisakPolozenihStudent.add(o);
					}else {
						spisakNepolozenihStudent.add(o);
					}
				}
				
			}
			s.setSpisakNepolozenihPredmeta(spisakNepolozenihStudent);
			s.setSpisakPolozenihPredmeta(spisakPolozenihStudent);
		}
		
		for(Student s : BazaStudenata.getInstance().getSviStudenti()) {
			ArrayList<Ocena> spisakPolozenihStudent = new ArrayList<Ocena>();
			ArrayList<Ocena> spisakNepolozenihStudent = new ArrayList<Ocena>();

			for(Ocena o : tmpOcene) {
				if(o.getStudent() == s) {
					if(o.getVrednostOcene() > 5) {
						spisakPolozenihStudent.add(o);
					}else {
						spisakNepolozenihStudent.add(o);
					}
				}
				
			}
			s.setSpisakNepolozenihPredmeta(spisakNepolozenihStudent);
			s.setSpisakPolozenihPredmeta(spisakPolozenihStudent);
		}
		
		
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			List<Student> spisakStudentiPolozili = new ArrayList<Student>();
			List<Student> spisakStudentiNisuPolozili = new ArrayList<Student>();
			
			for(Ocena o : ocene) {
				if(o.getPredmet() == p) {
					if(o.getVrednostOcene() > 5) {
						spisakStudentiPolozili.add(o.getStudent());
					}else {
						spisakStudentiNisuPolozili.add(o.getStudent());
					}
				}
				
			}
			p.setStudentiNisuPolozili(spisakStudentiNisuPolozili);
			p.setStudentiPolozili(spisakStudentiPolozili);
		}	
		
		for(Predmet p : BazaPredmeta.getInstance().getSviPredmeti()) {
			List<Student> spisakStudentiPolozili = new ArrayList<Student>();
			List<Student> spisakStudentiNisuPolozili = new ArrayList<Student>();
			
			for(Ocena o : tmpOcene) {
				if(o.getPredmet() == p) {
					if(o.getVrednostOcene() > 5) {
						spisakStudentiPolozili.add(o.getStudent());
					}else {
						spisakStudentiNisuPolozili.add(o.getStudent());
					}
				}
				
			}
			p.setStudentiNisuPolozili(spisakStudentiNisuPolozili);
			p.setStudentiPolozili(spisakStudentiPolozili);
		}	
		
		
	}
	
	
	public ArrayList<Ocena> getOcene(){
		return ocene;
	}
	
	private String indeks;
	public void setIndkes(String brojIndeksa) {
		this.indeks = brojIndeksa;
		this.listaPolozenih = new ArrayList<Ocena>();
		
		for(Student st : BazaStudenata.getInstance().getStudenti()) {
			if(st.getBrojIndeksa().equals(indeks)) {
				listaPolozenih = st.getSpisakPolozenihPredmeta();
				listaNepolozenih = st.getSpisakNepolozenihPredmeta();
			}
		}
	}
	
	public ArrayList<Ocena> getOcenePolozeni() {
		return listaPolozenih;
	}


	public void setOcenePolozeni(ArrayList<Ocena> spisakPolozenih) {
		this.listaPolozenih = spisakPolozenih;
	}
	

	public int getColumnCountPolozeni() {
		return 5;
	}
	
	public String getColumnNamePolozeni(int index) {
		return this.kolonePolozeni.get(index);
	}

	public Ocena getRowPolozeni(int rowIndex) {
		return this.listaPolozenih.get(rowIndex);
	}
	
	public String getValueAPolozenit(int row, int column) {
		
		Ocena ocena = this.listaPolozenih.get(row); 

		switch (column) {
		case 0:
			return ocena.getPredmet().getSifraPredmeta();
		case 1:
			return ocena.getPredmet().getNazivPredmeta();
		case 2:
			return Integer.toString(ocena.getPredmet().getEspb());
		case 3:
			return Integer.toString(ocena.getVrednostOcene());
		case 4:
			return String.valueOf(ocena.getDatumPolaganja());
		default:
			return null;
		}
	}
	
/*	------------------------------------------------------	*/
	
	public ArrayList<Ocena> getOceneNepolozeni() {
		return listaNepolozenih;
	}


	public void setOceneNepolozeni(ArrayList<Ocena> spisakNepolozenih) {
		this.listaNepolozenih = spisakNepolozenih;
	}
	

	public int getColumnCountNepolozeni() {
		return 5;
	}
	
	public String getColumnNameNepolozeni(int index) {
		return this.koloneNepolozeni.get(index);
	}

	public Ocena getRowNepolozeni(int rowIndex) {
		return this.listaNepolozenih.get(rowIndex);
	}
	
	public String getValueAtNepolozeni(int row, int column) {
		
		Ocena ocena = this.listaNepolozenih.get(row); 

		switch (column) {
		case 0:
			return ocena.getPredmet().getSifraPredmeta();
		case 1:
			return ocena.getPredmet().getNazivPredmeta();
		case 2:
			return Integer.toString(ocena.getPredmet().getEspb());
		case 3:
			return Integer.toString(ocena.getPredmet().getGodinaStudija());
		case 4:
			if(ocena.getPredmet().getSemestar() == PredmetSemestar.letnji)
				return "Letnji";
			else if(ocena.getPredmet().getSemestar() == PredmetSemestar.zimski)
				return "Zimski";
			else
				return "Nepoznato";			
		default:
			return null;
		}
	}
	
	public void dodajNepolozeni(String indeks, String sifra) { 
		Student st = new Student();
		Predmet pr = new Predmet();
	
		
		
		for(Student i : BazaStudenata.getInstance().getStudenti()) {
				if(i.getBrojIndeksa().equals(indeks)) {
					st = i;
				}
		}
		
		for(Predmet p: BazaPredmeta.getInstance().getPredmeti()) {
			if(p.getSifraPredmeta().equals(sifra)) {
				pr = p;
			}
			
		}
		String date = "11.11.1111.";
		DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		Ocena oc = new Ocena(st,pr, 5, LocalDate.parse(date, formatiran));
		BazaOcena.getInstance().getOcene().add(oc);
		st.getSpisakNepolozenihPredmeta().add(oc);
		
	}
		
	
	
	
	public void izbrisiNepolozeni(String indeks) {
		for(Ocena i : listaNepolozenih) {
			if(i.getPredmet().getSifraPredmeta() == indeks) {
				listaNepolozenih.remove(i);
				break;
			}
		}
	}
	
	
}