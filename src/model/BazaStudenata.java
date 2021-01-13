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

import view.EditStudentFrame;
import view.PolozeniJTable;


public class BazaStudenata {

	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}

	private ArrayList<Student> studenti;
	private ArrayList<Student> tmpStudenti;
	private ArrayList<String> kolone;
	
	
	private BazaStudenata() {
	
		this.kolone = new ArrayList<String>();
		this.kolone.add("INDEKS");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("GOD. STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");

		initStudente();
		
	}
	
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		this.tmpStudenti = new ArrayList<Student>();
		String kolone[];
		String naredni;
		BufferedReader reader = null;
		String datumRodj;
		
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
				if(kolone[8].trim().equals("B"))
					status = StudentStatus.B;
				else
					status = StudentStatus.S;
				
				datumRodj = kolone[4];
				DateTimeFormatter formatiran = DateTimeFormatter.ofPattern(" dd.MM.yyyy.");
				
				studenti.add(new Student( kolone[1].trim(), kolone[2].trim(), LocalDate.parse(datumRodj, formatiran), kolone[5].trim(), kolone[0].trim(), kolone[6].trim(),
						kolone[7].trim(), Integer.parseInt(kolone[9].trim()), Integer.parseInt(kolone[3].trim()), status, Double.parseDouble(kolone[10].trim())));
				tmpStudenti.add(new Student( kolone[1].trim(), kolone[2].trim(), LocalDate.parse(datumRodj, formatiran), kolone[5].trim(), kolone[0].trim(), kolone[6].trim(),
						kolone[7].trim(), Integer.parseInt(kolone[9].trim()), Integer.parseInt(kolone[3].trim()), status, Double.parseDouble(kolone[10].trim())));
			}
			
			reader.close();
		} catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	
	public void setStudentiLista(ArrayList<Student> lista) {
		studenti = lista;
	}
	
	public void restart() {

		tmpStudenti = azurirajPomocnuListu(tmpStudenti, studenti);
		
		studenti = tmpStudenti;
		listaStudenata.removeAll(listaStudenata);
	}
	
	public ArrayList<Student> azurirajPomocnuListu(ArrayList<Student> s, ArrayList<Student> s1) {
		for(Student stud : s) {
			for(Student stud1 : s1) {
				if(stud.getBrojIndeksa().equals(stud1.brojIndeksa)) {
					int index = s.indexOf(stud);
					s.set(index, stud1);
				}
			}
		}
		return s;
	}
	
	
	
	public ArrayList<Student> getStudenti() {
		return studenti;
	}
	
	public ArrayList<Student> getSviStudenti() {
		return tmpStudenti;
	}


	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public Object getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrojIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return student.getTrenutnaGodina();
		case 4:
			if(student.getStatus() == StudentStatus.B)
				return "Budzet";
			else if (student.getStatus() == StudentStatus.S)
				return "Samofinansiranje";
		case 5:
			return student.getProsecnaOcena();
		default:
			return null;
		}
	}
	
	
	public void dodajStudenta(String ime, String prezime, LocalDate datumRodjenja, String adresa, String indeks, String kontakt,String mail, int godinaUpisa, int trenutnaGodina, StudentStatus status, double prosecnaOcena) {
		this.studenti.add(new Student(ime,prezime, datumRodjenja, adresa, indeks, kontakt,mail, godinaUpisa, trenutnaGodina, status,  5));
		tmpStudenti = azurirajPomocnuListu(tmpStudenti, studenti);
	}


	public void izmeniStudenta(String ime, String prezime, LocalDate datumRodjenja, String adresa, String indeks, String kontakt,String mail, int godinaUpisa, int trenutnaGodina, StudentStatus status, double prosecnaOcena) {
		for (Student i : studenti) {
			if (i.getBrojIndeksa().equals(indeks)) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setDatumRodjenja(datumRodjenja);
				i.setAdresa(adresa);
				i.setBrojIndeksa(indeks);
				i.setKontakt(kontakt);
				i.setEmail(mail);
				i.setGodinaUpisa(godinaUpisa);
				i.setTrenutnaGodina(trenutnaGodina);
				i.setStatus(status);
				i.setProsecnaOcena(prosecnaOcena);
			}
		}

		tmpStudenti = azurirajPomocnuListu(tmpStudenti, studenti);
	}
	
	
	public void izbrisiStudenta(String indeks) {
		for (Student i : studenti) {
			if (i.getBrojIndeksa().equals(indeks)) {
				studenti.remove(i);
				break;
			}
		}
		try {
			for (Student i : tmpStudenti) {
				if (i.getBrojIndeksa().equals(indeks)) {
					tmpStudenti.remove(i);
					break;
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	ArrayList<Student> listaStudenata = new ArrayList<Student>();
	
	public void searchStudent(String tekst) {
		
		String[] splited = tekst.split("\\s+");
		
		if(tekst.equals("")) {
			restart();
		}else {
			restart();
			
			if(splited.length == 1) {
				for(Student s : BazaStudenata.getInstance().getStudenti()) {
					if(s.getPrezime().toLowerCase().contains(splited[0].toLowerCase())) {
						listaStudenata.add(s);
					}
				
				}
			}
			
			if(splited.length == 2) {
				for(Student s : BazaStudenata.getInstance().getStudenti()) {
					if(s.getPrezime().toLowerCase().contains(splited[0].toLowerCase()) && s.getIme().toLowerCase().contains(splited[1].toLowerCase())) {
						listaStudenata.add(s);
					}
				
				}
			}
			
			
			if(splited.length == 3) {
				for(Student s : BazaStudenata.getInstance().getStudenti()) {
					if(s.getPrezime().toLowerCase().contains(splited[0].toLowerCase()) && s.getIme().toLowerCase().contains(splited[1].toLowerCase()) && s.getBrojIndeksa().toLowerCase().contains(splited[2].toLowerCase())) {
						listaStudenata.add(s);
					}
				
				}
			}

		BazaStudenata.getInstance().setStudentiLista(listaStudenata);
		}
	}
	

	public void upisiOcenu(String indeks, String sifraPredmeta, String ocena, LocalDate datum) {
		for(Student i : studenti) {
			if(i.getBrojIndeksa().equals(indeks)) {
				for(Ocena o : i.getSpisakNepolozenihPredmeta()) {
					if(o.getPredmet().getSifraPredmeta().equals(sifraPredmeta)) {
						i.getSpisakNepolozenihPredmeta().remove(o);
						o.setDatumPolaganja(datum);
						o.setVrednostOcene(Integer.parseInt(ocena));
						i.getSpisakPolozenihPredmeta().add(o);
						break;
					}
				}
			}
		}
		tmpStudenti = azurirajPomocnuListu(tmpStudenti, studenti);
	}
	
	public void ponistiOcenu(String indeks, String sifraPredmeta) {
		for(Student i : studenti) {
			if(i.getBrojIndeksa().equals(indeks)) {
				for(Ocena o : i.getSpisakPolozenihPredmeta()) {
					if(o.getPredmet().getSifraPredmeta().equals(sifraPredmeta)) {
						o.setVrednostOcene(5);
						i.getSpisakPolozenihPredmeta().remove(o);
						i.getSpisakNepolozenihPredmeta().add(o);
						break;
					}
				}
			}
		}
		tmpStudenti = azurirajPomocnuListu(tmpStudenti, studenti);
		
	}
	
	
	public void prosekOcena(Student s) {
		double avg = 0;
		int brojac = 0;
		
		PolozeniJTable tabelaPolozenih = EditStudentFrame.getPol();
		
		for(int i = 0; i< tabelaPolozenih.getRowCount();i++) {
			avg = avg + Integer.parseInt(tabelaPolozenih.getValueAt(i, 3).toString());
			brojac++;
		}

		double prosecnaOcena = avg/brojac;
		
		s.setProsecnaOcena(prosecnaOcena);
	}
	
	
}
