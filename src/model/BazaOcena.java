package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	private BazaOcena(){
		this.ocene = new ArrayList<Ocena>();
		
		String kolone[];
		String naredni;
		String sifra;
		String indeks;
		int ocena;
		String datum;
		
		/*List<Ocena> spisakPolozenih = new ArrayList<Ocena>();
		List<Ocena> spisakNepolozenih = new ArrayList<Ocena>();*/
		
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
				
				/*if(ocena > 5) {
					spisakPolozenih.add(objOcena);
				}else {
					spisakNepolozenih.add(objOcena);
				}*/
				
			}
			reader.close();
		}catch(IOException exception) {
			exception.printStackTrace();
		}
		
		/*for(Ocena o : ocene) {
			for(Student s : BazaStudenata.getInstance().getStudenti()) {
				if(s == o.getStudent()) {}
			}
			
			o.getStudent().setSpisakNepolozenihPredmeta(spisakNepolozenih);
			o.getStudent().setSpisakPolozenihPredmeta(spisakPolozenih);
		}*/
		
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
}
