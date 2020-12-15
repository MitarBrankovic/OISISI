package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class BazaStudenata {

	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}

	private ArrayList<Student> studenti;
	private ArrayList<String> kolone;
	
	
	private BazaStudenata() {
	
		this.kolone = new ArrayList<String>();
		this.kolone.add("INDEKS");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("DAT. RODJENJA");
		this.kolone.add("ADRESA");
		this.kolone.add("TEL.");
		this.kolone.add("EMAIL");
		this.kolone.add("DAT. UPISA");
		this.kolone.add("GOD. STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");
		//this.kolone.add("PREDMETI");

		initStudente();
		
	}
	
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		String kolone[];
		String naredni;
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("tabele" + File.separator + "Studenti.txt")));
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
		
		try {
			while((naredni = reader.readLine()) != null) {
				if(naredni.equals(""))	continue;
				
				kolone = naredni.split("\\,");
				
				StudentStatus status;
				if(kolone[9].trim().equals("B"))
					status = StudentStatus.B;
				else
					status = StudentStatus.S;
				
				studenti.add(new Student( kolone[0].trim(), kolone[1].trim(), kolone[2].trim(), kolone[3].trim(), kolone[4].trim(), kolone[5].trim(), kolone[6].trim(), Integer.parseInt(kolone[7].trim()), Integer.parseInt(kolone[8].trim()), status, Double.parseDouble(kolone[10].trim())));
				
			}
			
			reader.close();
		} catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	
	
	
	public ArrayList<Student> getStudenti() {
		return studenti;
	}


	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	

	public int getColumnCount() {
		return 11;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrojIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return student.getDatumRodjenja();
		case 4:
			return student.getAdresa();
		case 5:
			return student.getKontakt();
		case 6:
			return student.getEmail();
		case 7:
			return Integer.toString(student.getGodinaUpisa());
		case 8:
			return Integer.toString(student.getTrenutnaGodina());
		case 9:
			if(student.getStatus() == StudentStatus.B)
				return "Budzet";
			else if (student.getStatus() == StudentStatus.S)
				return "Samofinansiranje";
		case 10:
			return Double.toString(student.getProsecnaOcena());
		default:
			return null;
		}
	}
	
	
	public void dodajStudenta(String ime, String prezime, String datumRodjenja, String adresa, String indeks, String kontakt,String mail, int godinaUpisa, int trenutnaGodina, StudentStatus status, double prosecnaOcena) {
		this.studenti.add(new Student(ime,prezime, datumRodjenja, adresa, indeks, kontakt,mail, godinaUpisa, trenutnaGodina, status, prosecnaOcena));
	}

	public void izbrisiStudenta(String indeks) {
		for (Student i : studenti) {
			if (i.getBrojIndeksa() == indeks) {
				studenti.remove(i);
				break;
			}
		}
	}
	
}
