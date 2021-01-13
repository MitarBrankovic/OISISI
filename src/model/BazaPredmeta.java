package model;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 5
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance() {
		if(instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private ArrayList<Predmet> predmeti;
	private ArrayList<Predmet> tmpPredmeti;

	private ArrayList<String> kolone;
	
	private BazaPredmeta(){
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA");
		this.kolone.add("NAZIV");
		this.kolone.add("SEMESTAR");
		this.kolone.add("GODINA");
		this.kolone.add("ESPB");
		
		initPredmete();
		
	}
	
	private void initPredmete() {
		
		this.predmeti = new ArrayList<Predmet>();
		this.tmpPredmeti = new ArrayList<Predmet>();

		String kolone[];
		String naredni;
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("tabele" + File.separator + "Predmeti.txt")));
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
		
		try {
			while((naredni = reader.readLine()) != null) {
				if(naredni.equals(""))	continue;
				
				kolone = naredni.split("\\,");
				
				PredmetSemestar semestar1;
				if(kolone[5].trim().equals("ZIMSKI"))
					semestar1 = PredmetSemestar.zimski;
				else
					semestar1 = PredmetSemestar.letnji;
				
				
				Profesor objProfesor = null;
				Profesor objTmpProfesor = null;

				String profLicnaKarta = kolone[4].trim();
				if(profLicnaKarta.contains("null")) {
					objProfesor = null;
				}else {
					for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
						if(p.getBrojLicneKarte().equals(profLicnaKarta) == true) {
							objProfesor = p;
						}
					}
					for(Profesor p : BazaProfesora.getInstance().getTmpProfesori()) {
						if(p.getBrojLicneKarte().equals(profLicnaKarta) == true) {
							objTmpProfesor = p;
						}
					}
				}
				
				
				
				Predmet pred = new Predmet( kolone[0].trim(), kolone[1].trim(), semestar1, Integer.parseInt(kolone[2].trim()), Integer.parseInt(kolone[3].trim()), objProfesor);
				predmeti.add(pred);
				tmpPredmeti.add(pred);
				
				if(objProfesor != null) {
					objProfesor.getSpisakPredmeta().add(pred);
					objTmpProfesor.getSpisakPredmeta().add(pred);
				}
		}
			
			reader.close();
		} catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	
	public void setPredmetiLista(ArrayList<Predmet> lista) {
		predmeti = lista;
	}
	
	public void restart() {
		
		tmpPredmeti = azurirajPomocnuListu(tmpPredmeti, predmeti);
		
		predmeti = tmpPredmeti;
		listaPredmeta.removeAll(listaPredmeta);
	}
	
	public ArrayList<Predmet> azurirajPomocnuListu(ArrayList<Predmet> p, ArrayList<Predmet> p1){
		for(Predmet pred : p) {
			for(Predmet pred1 : p1) {
				if(pred.getSifraPredmeta().equals(pred1.getSifraPredmeta())) {
					int index = p.indexOf(pred);
					p.set(index, pred1);
				}
			}
		}
		return p;
	}
	
	public ArrayList<Predmet> getSviPredmeti() {
		return tmpPredmeti;
	}
	
	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}
	
	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {		
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			if(predmet.getSemestar() == PredmetSemestar.letnji)
				return "Letnji";
			else if(predmet.getSemestar() == PredmetSemestar.zimski)
				return "Zimski";
			else
				return "Nepoznato";	
		case 3:
			return Integer.toString(predmet.getGodinaStudija());
		case 4:
			return Integer.toString(predmet.getEspb());
		default:
			return null;
		}
	}
	
	public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, PredmetSemestar sem, int godinaStudija, int espb, Profesor predmetniProfesor) {
		this.predmeti.add(new Predmet( sifraPredmeta,  nazivPredmeta,  sem,  godinaStudija,  espb,  predmetniProfesor));
		//this.tmpPredmeti.add(new Predmet( sifraPredmeta,  nazivPredmeta,  sem,  godinaStudija,  espb,  predmetniProfesor));

		tmpPredmeti = azurirajPomocnuListu(tmpPredmeti, predmeti);
	}
	
	
	public void izmeniPredmet(String sifraPredmeta, String nazivPredmeta, PredmetSemestar sem, int godinaStudija, int espb, Profesor predmetniProfesor) {
		for (Predmet i : predmeti) {
			if (i.getSifraPredmeta().equals(sifraPredmeta)) {
				i.setSifraPredmeta(sifraPredmeta);
				i.setNazivPredmeta(nazivPredmeta);
				i.setSemestar(sem);
				i.setGodinaStudija(godinaStudija);
				i.setEspb(espb);
				i.setPredmetniProfesor(predmetniProfesor);				
			}
		}
		tmpPredmeti = azurirajPomocnuListu(tmpPredmeti, predmeti);

		
	}
	
	public void izbrisiProfesoraSaPredmeta(String sifra) {
		for(Predmet i : predmeti) {
			if(i.getSifraPredmeta().equals(sifra)) {
				Profesor prof = i.getPredmetniProfesor();
				i.setPredmetniProfesor(null);
				prof.getSpisakPredmeta().remove(i);
				break;
			}
		}
		tmpPredmeti = azurirajPomocnuListu(tmpPredmeti, predmeti);

		
	}
	
	public void izbrisiPredmet(String indeks) {
		for(Predmet i : predmeti) {
			if(i.getSifraPredmeta().equals(indeks)) {
				Profesor objProf = null;
				objProf = i.getPredmetniProfesor();
				if(objProf != null) {
					objProf.getSpisakPredmeta().remove(i);
				}
				ArrayList<Ocena> oceneBrisanje = new ArrayList<Ocena>();
				for(Ocena o : BazaOcena.getInstance().getOcene()) {
					if(o.getPredmet().getSifraPredmeta().equals(indeks)){
						o.getStudent().getSpisakNepolozenihPredmeta().remove(o);
						o.getStudent().getSpisakPolozenihPredmeta().remove(o);
						oceneBrisanje.add(o);
					}
				}
				predmeti.remove(i);
				BazaOcena.getInstance().getOcene().removeAll(oceneBrisanje);
				break;
			}
		}
		//tmpPredmeti = azurirajPomocnuListu(tmpPredmeti, predmeti);

		for(Predmet i : tmpPredmeti) {
			if(i.getSifraPredmeta().equals(indeks)) {
				Profesor objProf = null;
				objProf = i.getPredmetniProfesor();
				if(objProf != null) {
					objProf.getSpisakPredmeta().remove(i);
				}
				ArrayList<Ocena> oceneBrisanje = new ArrayList<Ocena>();
				for(Ocena o : BazaOcena.getInstance().getOcene()) {
					if(o.getPredmet().getSifraPredmeta().equals(indeks)){
						o.getStudent().getSpisakNepolozenihPredmeta().remove(o);
						o.getStudent().getSpisakPolozenihPredmeta().remove(o);
						oceneBrisanje.add(o);
					}
				}
				tmpPredmeti.remove(i);
				BazaOcena.getInstance().getOcene().removeAll(oceneBrisanje);
				break;
			}
		}
	}
	

	
	ArrayList<Predmet> listaPredmeta = new ArrayList<Predmet>();
	
	public void searchPredmet(String tekst) {
		
		if(tekst.equals("")) {

			restart();
		}else {
			restart();
			for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
				if(p.getNazivPredmeta().toLowerCase().contains(tekst.toLowerCase())) {
					listaPredmeta.add(p);
				}
			}
		BazaPredmeta.getInstance().setPredmetiLista(listaPredmeta);
		}
	}
}
