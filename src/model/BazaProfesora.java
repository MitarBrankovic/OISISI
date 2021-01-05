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

import view.AbstractTableNepolozeni;

public class BazaProfesora {
	
	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance == null) {
			instance = new BazaProfesora();
			}
		return instance;
	}
	
	private ArrayList<Profesor> profesori;
	private ArrayList<Profesor> tmpProfesori;
	private ArrayList<String> kolone1;
	private ArrayList<String> kolone2;
	private ArrayList<Predmet> listaPredmeta;

	private BazaProfesora() {
		this.kolone1 = new ArrayList<String>();
		this.kolone1.add("BROJ LICNE KARTE");
		this.kolone1.add("IME");
		this.kolone1.add("PREZIME");
		this.kolone1.add("TITULA");
		this.kolone1.add("ZVANJE");
		
		this.kolone2 = new ArrayList<String>();
		this.kolone2.add("SIFRA");
		this.kolone2.add("NAZIV");
		this.kolone2.add("GODINA STUDIJA");
		this.kolone2.add("SEMESTAR");
		
		initProfesore();
	}

	
	private void initProfesore() {
		
		this.profesori = new ArrayList<Profesor>();
		this.tmpProfesori = new ArrayList<Profesor>();
		String kolone[];
		String naredni;
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("tabele" + File.separator + "Profesori.txt")));
		}catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
		try {
			while((naredni = reader.readLine()) != null) {
				if(naredni.equals(""))	continue;
				
				kolone = naredni.split("\\,");
				
				DateTimeFormatter formatiran = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				
				profesori.add(new Profesor( kolone[0].trim(), kolone[1].trim(), LocalDate.parse(kolone[2].trim(), formatiran), kolone[3].trim(), kolone[4].trim(), kolone[5].trim(), kolone[6].trim(), kolone[7].trim(), kolone[8].trim(), kolone[9].trim()));
				tmpProfesori.add(new Profesor( kolone[0].trim(), kolone[1].trim(), LocalDate.parse(kolone[2].trim(), formatiran), kolone[3].trim(), kolone[4].trim(), kolone[5].trim(), kolone[6].trim(), kolone[7].trim(), kolone[8].trim(), kolone[9].trim()));

			}
	
			reader.close();
		
		}catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	
	public void setProfesoriLista(ArrayList<Profesor> lista) {
		profesori = lista;
	}
	
	public void restart() {
		profesori = tmpProfesori;
	}
	
	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}
	
	public ArrayList<Profesor> getSviProfesori() {
		return tmpProfesori;
	}
	
	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.kolone1.get(index);
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Profesor profesori = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesori.getBrojLicneKarte();
		case 1:	
			return profesori.getIme();
		case 2:
			return profesori.getPrezime();
		case 3:
			return profesori.getTitula();
		case 4:
			return profesori.getZvanje();
		
		default:
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setBrojLicne(String brojLicneKarte) {
		this.listaPredmeta = new ArrayList<Predmet>();
		
		for(Profesor pr : BazaProfesora.getInstance().getProfesori()) {
			if(pr.getBrojLicneKarte().equals(brojLicneKarte)) {
				listaPredmeta = pr.getSpisakPredmeta();
			}
		}
	}
	
	
	public ArrayList<Predmet> getProfesoriPredmet() {
		return listaPredmeta;
	}
	
	public void setProfesoriPredmet(ArrayList<Predmet> listaPredmeta) {
		this.listaPredmeta = listaPredmeta;
	}
	
	public int getColumnCountProfesoriPredmet() {
		return 4;
	}
	
	public String getColumnNameProfesoriPredmet(int index) {
		return this.kolone2.get(index);
	}
	
	public Predmet getRowProfesoriPredmet(int rowIndex) {
		return this.listaPredmeta.get(rowIndex);
	}
	
	public String getValueAtProfesoriPredmet(int row, int column) {
		Predmet predmeti = this.listaPredmeta.get(row);
		switch (column) {
		case 0:
			return predmeti.getSifraPredmeta();
		case 1:
			return predmeti.getNazivPredmeta();
		case 2:
			return Integer.toString(predmeti.getGodinaStudija());
		case 3:
			if(predmeti.getSemestar() == PredmetSemestar.letnji)
				return "Letnji";
			else if(predmeti.getSemestar() == PredmetSemestar.zimski)
				return "Zimski";
			else
				return "Nepoznato";	
		
		default:
			return null;
		}
	}
		
	
	
	public void dodajProfesora(String ime, String prezime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje) {
		this.profesori.add(new Profesor(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, email, adresaKancelarije, brojLicneKarte, titula, zvanje));
		this.tmpProfesori.add(new Profesor(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, email, adresaKancelarije, brojLicneKarte, titula, zvanje));

	}
	
	public void izbrisiProfesora(String indeks) {
		for(Profesor i : profesori) {
			if(i.getBrojLicneKarte().equals(indeks)) {
				profesori.remove(i);
				break;
			}
		}
		
		try {
			for(Profesor i : tmpProfesori) {
				if(i.getBrojLicneKarte().equals(indeks)) {
					tmpProfesori.remove(i);
					break;
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	ArrayList<Profesor> listaProfesora = new ArrayList<Profesor>();
	
	public void searchProfesor(String tekst) {
		
		if(tekst.equals("")) {
			this.profesori=this.tmpProfesori;
			listaProfesora.removeAll(listaProfesora);
		}else {
			for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
				if(p.getPrezime().toLowerCase().contains(tekst.toLowerCase())) {
					listaProfesora.add(p);
				}
			}
		BazaProfesora.getInstance().setProfesoriLista(listaProfesora);
		}
	}
	
	
	public void izmeniProfesora(String ime, String prezime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje) {
		for(Profesor i : profesori) {
			if(i.getBrojLicneKarte().equals(brojLicneKarte)) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setDatumRodjenja(datumRodjenja);
				i.setAdresaStanovanja(adresaStanovanja);
				i.setKontaktTelefon(kontaktTelefon);
				i.setEmail(email);
				i.setAdresaKancelarije(adresaKancelarije);
				i.setBrojLicneKarte(brojLicneKarte);
				i.setTitula(titula);
				i.setZvanje(zvanje);

			}
		}
		try {
			for(Profesor i : tmpProfesori) {
				if(i.getBrojLicneKarte().equals(brojLicneKarte)) {
					i.setIme(ime);
					i.setPrezime(prezime);
					i.setDatumRodjenja(datumRodjenja);
					i.setAdresaStanovanja(adresaStanovanja);
					i.setKontaktTelefon(kontaktTelefon);
					i.setEmail(email);
					i.setAdresaKancelarije(adresaKancelarije);
					i.setBrojLicneKarte(brojLicneKarte);
					i.setTitula(titula);
					i.setZvanje(zvanje);

				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void dodajPredmet(String sifra, String brLicne) {
		Profesor prof = new Profesor();
		Predmet pred = new Predmet();
		
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			if(p.getSifraPredmeta().equals(sifra)) {
				pred = p;
			}
		}
		
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			if(p.getBrojLicneKarte().equals(brLicne)) {
				prof = p;
			}
		}
		
		prof.getSpisakPredmeta().add(pred);
		pred.setPredmetniProfesor(prof);
	}
	
	public void ukloniPredmet(String sifra, String brLicne) {
		Profesor prof = new Profesor();
		Predmet pred = new Predmet();
		
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			if(p.getSifraPredmeta().equals(sifra)) {
				pred = p;
			}
		}
		
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			if(p.getBrojLicneKarte().equals(brLicne)) {
				prof = p;
			}
		}
		
		prof.getSpisakPredmeta().remove(pred);
		pred.setPredmetniProfesor(null);
		
	}
	
}