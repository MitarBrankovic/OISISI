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
		/*this.predmeti = new ArrayList<Predmet>();
		//	public Predmet(String sifraPredmeta, String nazivPredmeta, int godinaStudija, Profesor predmetniProfesor, int espb) {
		predmeti.add(new Predmet("E231","Elektronika", 2, "Jasar Ahmedovski", 8, semestar.letnji));
		predmeti.add(new Predmet("E2S1","Analiza 1", 1, "Rale Mrale", 9, semestar.zimski));
		predmeti.add(new Predmet("E2S1","Analiza 1", 1, "Rale Mrale", 9, semestar.zimski));
		predmeti.add(new Predmet("E2S1","Analiza 1", 1, "Rale Mrale", 9, semestar.zimski));
		predmeti.add(new Predmet("E2S1","Analiza 1", 1, "Rale Mrale", 9, semestar.zimski));
		predmeti.add(new Predmet("E2S1","Analiza 1", 1, "Rale Mrale", 9, semestar.zimski));
		predmeti.add(new Predmet("E2S1","Analiza 1", 1, "Rale Mrale", 9, semestar.zimski));
		*/
		
		this.predmeti = new ArrayList<Predmet>();
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
				
				semestar semestar1;
				if(kolone[5].trim().equals("zimski"))
					semestar1 = semestar.zimski;
				else
					semestar1 = semestar.letnji;
				
				predmeti.add(new Predmet( kolone[0].trim(), kolone[1].trim(), Integer.parseInt(kolone[2].trim()), kolone[3].trim(), Integer.parseInt(kolone[4].trim()), semestar1));
				
			}
			
			String s = reader.readLine();
			System.out.println(s);
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
			if(predmet.getSemestar() == semestar.letnji)
				return "Letnji";
			else if(predmet.getSemestar() == semestar.zimski)
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
	
	public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, int godinaStudija, String predmetniProfesor, int espb, semestar sem) {
		this.predmeti.add(new Predmet(sifraPredmeta, nazivPredmeta, godinaStudija, predmetniProfesor, espb, sem));
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
