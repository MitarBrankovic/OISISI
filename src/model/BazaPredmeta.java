package model;

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
		//	public Predmet(String sifraPredmeta, String nazivPredmeta, int godinaStudija, Profesor predmetniProfesor, int espb) {
		predmeti.add(new Predmet("E231","Elektronika", 2, "Jasar Ahmedovski", 8, semestar.letnji));
		predmeti.add(new Predmet("E2S1","Analiza 1", 1, "Rale Mrale", 9, semestar.zimski));

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
