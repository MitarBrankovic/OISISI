package model;

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
		String kolone[];
		String naredni;
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("tabele" + File.separator + "predmeti.txt")));
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
		
		try {
			while((naredni = reader.readLine()) != null) {
				if(naredni.equals(""))	continue;
				
				kolone = naredni.split("\\,");
				
				ProfesorSemestar semestar1;
				if(kolone[2].trim().equals("ZIMSKI"))
					semestar1 = ProfesorSemestar.zimski;
				else
					semestar1 = ProfesorSemestar.letnji;
				
				predmeti.add(new Predmet( kolone[0].trim(), kolone[1].trim(), semestar1, Integer.parseInt(kolone[3].trim()), Integer.parseInt(kolone[4].trim()), kolone[5].trim()));
				
			}
			
			reader.close();
		} catch(IOException exception) {
			exception.printStackTrace();
		}

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
			if(predmet.getSemestar() == ProfesorSemestar.letnji)
				return "Letnji";
			else if(predmet.getSemestar() == ProfesorSemestar.zimski)
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
	
	public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, ProfesorSemestar sem, int godinaStudija, int espb, String predmetniProfesor) {
		this.predmeti.add(new Predmet( sifraPredmeta,  nazivPredmeta,  sem,  godinaStudija,  espb,  predmetniProfesor));
	}
	
	public void izbrisiPredmet(String indeks) {
		for(Predmet i : predmeti) {
			if(i.getSifraPredmeta() == indeks) {
				predmeti.remove(i);
				break;
			}
		}
	}

}
