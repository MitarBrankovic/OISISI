package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import view.StudentiJTable;

public class BazaOcena {
	
	private static BazaOcena instance = null;
	
	public static BazaOcena getInstance() {
		if(instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}
	
	private String indeks;
	
	public void setIndkes(String brojIndeksa) {
		this.indeks = brojIndeksa;
	}
	
	private ArrayList<Ocena> ocene;
	private List<String> kolonePolozeni;
	private ArrayList<Ocena> spisakPolozenih;
	List<Ocena> spisakNepolozenih = new ArrayList<Ocena>();
	
	private BazaOcena() {
		
		this.kolonePolozeni = new ArrayList<String>();
		this.kolonePolozeni.add("SIFRA PREDMETA");
		this.kolonePolozeni.add("NAZIV PREDMETA");
		this.kolonePolozeni.add("ESPB");
		this.kolonePolozeni.add("OCENE");
		this.kolonePolozeni.add("DATUM");
		
		initOcene();
	}
	
	
	
	private void initOcene(){
		this.ocene = new ArrayList<Ocena>();
		this.spisakPolozenih = new ArrayList<Ocena>();
		
		String kolone[] = null;
		String naredni = null;
		String sifra = null;
		String indeks = null;
		int ocena;
		String datum = null;
		
		//List<Ocena> spisakPolozenih = new ArrayList<Ocena>();
		//List<Ocena> spisakNepolozenih = new ArrayList<Ocena>();
		
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
				
				if(ocena > 5) {
					spisakPolozenih.add(objOcena);
				}else {
					spisakNepolozenih.add(objOcena);
				}
				
			}
			reader.close();
		}catch(IOException exception) {
			exception.printStackTrace();
		}

		
		for(Student s : BazaStudenata.getInstance().getStudenti()) {
			List<Ocena> spisakPolozenihStudent = new ArrayList<Ocena>();
			List<Ocena> spisakNepolozenihStudent = new ArrayList<Ocena>();

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
	
	
	public ArrayList<Ocena> novaLista() {
		ArrayList<Ocena> ocenee = null;
		for(Ocena o: spisakPolozenih) {
			if(o.getStudent().getBrojIndeksa() == indeks) {
				ocenee.add(o);
				
			}
		}
		return ocenee;
	}
	
	
	public ArrayList<Ocena> getOcene() {
		return spisakPolozenih;
	}


	public void setOcene(ArrayList<Ocena> spisakPolozenih) {
		this.spisakPolozenih = spisakPolozenih;
	}
	

	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.kolonePolozeni.get(index);
	}

	public Ocena getRow(int rowIndex) {
		return this.spisakPolozenih.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		
		Ocena ocena = this.spisakPolozenih.get(row);
		//List<Ocena> spisakPolozenih 

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
	
	
}
