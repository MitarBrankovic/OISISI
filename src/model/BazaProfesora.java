package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BazaProfesora {
	
	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance == null) {
			instance = new BazaProfesora();
			}
		return instance;
	}
	
	private ArrayList<Profesor> profesori;
	private ArrayList<String> kolone;
	
	private BazaProfesora() {
		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("TITULA");
		this.kolone.add("ZVANJE");
		
		initProfesore();
	}

	
	private void initProfesore() {
		/*
		this.profesori = new ArrayList<Profesor>();
		profesori.add(new Profesor("Milankovic", "Milan", "24.3.1973", "bulevar 22", 0642233, "email@gmail.com", "L23", 000002134, "Doktor", "zvanje"));
		profesori.add(new Profesor("Jovanovic", "Jovan", "15.3.1980", "ulica 2", 0643313, "email123@gmail.com", "R43", 231312134, "drmr", "zvanje2"));
		profesori.add(new Profesor("Jovanovic", "Jovan", "15.3.1980", "ulica 2", 0643313, "email123@gmail.com", "R43", 212314134, "drmr", "zvanje2"));
		profesori.add(new Profesor("Jovanovic", "Jovan", "15.3.1980", "ulica 2", 0643313, "email123@gmail.com", "R43", 233121234, "drmr", "zvanje2"));
		profesori.add(new Profesor("Jovanovic", "Jovan", "15.3.1980", "ulica 2", 0643313, "email123@gmail.com", "R43", 222312134, "drmr", "zvanje2"));
		*/
	
		this.profesori = new ArrayList<Profesor>();
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
				
				profesori.add(new Profesor( kolone[0].trim(), kolone[1].trim(), kolone[2].trim(), kolone[3].trim(), Integer.parseInt(kolone[4].trim()), kolone[5].trim(), kolone[6].trim(), Integer.parseInt(kolone[7].trim()), kolone[8].trim(), kolone[9].trim()));
			}
		

			//String s = reader.readLine();
			//System.out.println(s);
			reader.close();
		
		}catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	
	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}
	
	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Profesor profesori = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesori.getIme();
		case 1:
			return profesori.getPrezime();
		case 2:
			return profesori.getTitula();
		case 3:
			return profesori.getZvanje();
		
		default:
			return null;
		}
	}
	
	public void dodajProfesora(String prezime, String ime, String datumRodjenja, String adresaStanovanja, int kontaktTelefon,String email, String adresaKancelarije, int brojLicneKarte, String titula, String zvanje) {
		this.profesori.add(new Profesor(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon, email, adresaKancelarije, brojLicneKarte, titula, zvanje));
	}
	
	public void izbrisiProfesora(int indeks) {
		for(Profesor i : profesori) {
			if(i.getBrojLicneKarte() == indeks) {
				profesori.remove(indeks);
				break;
			}
		}
	}
}
