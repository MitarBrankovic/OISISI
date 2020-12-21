package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//import view.StudentiJTable;

public class BazaOcena {
    
	private static BazaOcena instance = null;
	
	public static BazaOcena getInstance() {
		if(instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}
	
	
	private ArrayList<Ocena> ocene;
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
				
				
				sifra = kolone[0].trim();
				indeks = kolone[1].trim();
				ocena = Integer.parseInt(kolone[2].trim());
				datum = kolone[3].trim();
				
				
				for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
					if(p.getSifraPredmeta().equals(sifra) == true) {
						objPredmet = p;
					}
				}
				
				for(Student s : BazaStudenata.getInstance().getStudenti()) {
					if(s.getBrojIndeksa().equals(indeks) == true) {
						objStudent = s;
					}
				}
				
				
				Ocena objOcena = new Ocena(objStudent, objPredmet, ocena, datum);
				ocene.add(objOcena);

				
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
			return ocena.getDatumPolaganja();
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
	
	public void dodajNepolozeni(String indeks, String sifra) { //String sifraPred, String naziv, int espb, int godina, PredmetSemestar semestar
			/*for(Predmet pred: BazaPredmeta.getInstance().getPredmeti()) {
				if(pred.getSifraPredmeta().equals(indeks)) {
					pred.setNazivPredmeta(naziv);
					pred.setEspb(espb);
					pred.setGodinaStudija(godina);
					pred.setSemestar(semestar);
				}
				
			}*/
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
		Ocena oc = new Ocena(st,pr, 0, null);
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