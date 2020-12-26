package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelpFrame extends JFrame {

	private static final long serialVersionUID = -9156817893265858821L;

	public HelpFrame() {
		setLocationRelativeTo(null);
		setTitle("Uputstvo");
		
		JPanel ukrasniPanel = new JPanel(new FlowLayout());
		ukrasniPanel.setBackground(Color.DARK_GRAY);
		ukrasniPanel.setPreferredSize(new Dimension(100,20));
		
		TextArea tekst = new TextArea();
		tekst.setText("Deo projekta pripremljen za drugu kontrolnu tacku \r\n" + 
				"\r\n" + 
				"Glavni prozor se sastoji iz: MenuBar, Toolbar, TabPane(sastoji se iz 3 taba na kojem se nalaze tabele) i StatusBar-a.\r\n" + 
				"MenuBar kao i Toolbar ima opcije za dodavanje/izmenu/brisanje entiteta unutar tabela u zavisnosti od izabranog taba, a menuBar ima dodatne opcije za otvaranje help/about dijaloga.\r\n" + 
				"MenuBar mneumonici: File(ALT+F) -> New(ALT+F) / Close(ALT+C) \r\n" + 
				"		    Edit(ALT+E) -> Edit(ALT+E) / Delete(ALT+D) \r\n" + 
				"		    Help(ALT+H) -> Help(ALT+H) / About(ALT+B)\r\n" + 
				"MenuBar i Toolbar akceleratori: CTRL+N = dodavanje novog entiteta || CTRL+D = brisanje oznacenog entiteta || CTRL+E = izmena oznacenog entiteta || CTRL+H = help dijalog || CTRL+B = about dijalog\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"1. STUDENT ENTITET:\r\n" + 
				"1.1) Prikaz studenata\r\n" + 
				"Tabela sa informacijama o studentima se nalazi u tabu 'Studenti'. Klikom na naziv svake od kolona moguce je vrsiti opadajuce ili rastuce sortiranje prema vrednosti izabrane kolone.\r\n"
				+ " Takodje, moguce je vrsiti promenu redosleda kolona klikom na naziv kolone i prevlacenjem iste na mesto neke druge kolone.\r\n" + 
				"1.2) Dodavanje studenata(CTRL+N na tabu 'Studenti')\r\n" + 
				"Dijalog za dodavanje studenta je moguce otvoriti preko prvog dugmeta na toolbar-u ili u meniju File->New\r\n" + 
				"Potrebno je odgovarajuce popuniti sva polja. Postoje zastite za svako polje da li je pravilno popunjeno, takodje nije moguce dodati studenta sa indeksom koji vec postoji u tabeli. \r\n" + 
				"Primer pravilno unesenih polja za dodavanje studenta:\r\n" + 
				"Ime: Nikola\r\n" + 
				"Prezime: Tesla\r\n" + 
				"Datum rodj: 10.7.1856.\r\n" + 
				"Adresa: Futoska 10\r\n" + 
				"Telefon: 021123456\r\n" + 
				"Email: nikolatesla@gmail.com\r\n" + 
				"Indeks: RA/132\r\n" + 
				"Godina Upisa: 2020\r\n" + 
				"i odabrati neka polja iz comboBoxa(Status i GodinaStudija). Nakon toga je potrebno pritisnuti dugme 'Potvrdi' kako bi se student dodao u tabelu.\r\n" + 
				"1.3)Izmena studenta(CTRL+E na tabu 'Studenti')\r\n" + 
				"Potrebno je kliknuti na nekog studenta i pritisnuti drugo dugme na toolbaru ili Edit->Edit. Izmena ima zastite slicne kao i za dodavanje studenta. Ovaj dijalog se sastoji iz 3 taba: prvi('Informacije'), drugi('Polozeni'), treci('Nepolozeni').\r\n"
				+ " Na trecem tabu mozemo dodavati(dugme 'Dodaj') odnosno brisati('Obrisi') predmete koji nisu polzeni, takodje mozemo da im damo ocenu(dugme 'Pologanje') i upisemo uh u tabelu polozenih. Studentu se ne moze dodati predmet koji je na visoj godini od godine studija studenta.\r\n"
				+ " U okviru taba 'Polozeni' postoji tabela sa polozenim predmetima za koje se racuna prosecna ocena i ukupan ESPB. Moguce je ponistiti ocenu(dugme 'Ponisti ocenu' na tabu 'Polozeni') od nekog predmeta i tada ce se taj predmet prebaciti iz tabele polozenih u tabelu nepolozenih.\r\n"
				+ " Nakon sto se promeni stanje ove dve tabele prosecna ocena studenta ce se promeniti tek nakon sto je pritisnuto dugme 'Potvrdi' na tabu 'Informacije'.\r\n" + 
				"Za dugme 'Polaganje' i 'Ponisti ocenu' je potrebnu izabrati predmet nad kojim zelite da se izvrsi akcija.\r\n" + 
				"Onemogucena je izmena indeksa i proseka u tabu 'Informacije'.\r\n" + 
				"1.4)Brisanje sudenta(CTRL+D na tabu 'Studenti')\r\n" + 
				"Potrebno je kliknuti na nekog studenta i pritisnuti trece dugme na toolbaru ili Edit->Delete\r\n" + 
				"\r\n" + 
				"2. PROFESOR ENTITET\r\n" + 
				"2.1)Prikaz profesora\r\n" + 
				"Tabela sa informacijama o profesorima se nalazi u tabu 'Profesori'. Klikom na naziv svake od kolona moguce je vrsiti opadajuce ili rastuce sortiranje prema vrednosti izabrane kolone. Takodje, moguce je vrsiti promenu redosleda kolona klikom na naziv kolone i prevlacenjem iste na mesto neke druge kolone.\r\n" + 
				"2.2)Dodavanje profesora(CTRL+N na tabu 'Profesori')\r\n" + 
				"Dijalog za dodavanje profesora je moguce otvoriti preko prvog dugmeta na toolbar-u ili u meniju File->New\r\n" + 
				"Potrebno je odgovarajuce popuniti sva polja. Postoje zastite za svako polje da li je pravilno popunjeno, takodje nije moguce dodati profesora sa brojem licne karte koji vec postoji u tabeli.\r\n" + 
				"Primer pravilno unesenih polja za dodavanje profesora:\r\n" + 
				"Ime: Nikola\r\n" + 
				"Prezime: Tesla\r\n" + 
				"Datum rodj: 10.7.1856.\r\n" + 
				"Adresa: Futoska 10\r\n" + 
				"Telefon: 021123456\r\n" + 
				"Email: nikolatesla@gmail.com\r\n" + 
				"Adresa kancelarije: Futoska 9\r\n" + 
				"Broj licen karte: 523951\r\n" + 
				"i odabrati neka polja iz comboBoxa(Titula i Zvanje). Nakon toga je potrebno pritisnuti dugme 'Potvrdi' kako bi se student dodao u tabelu.\r\n" + 
				"2.3)Izmena profesora(CTRL+E na tabu 'Profesori')\r\n" + 
				"Potrebno je kliknuti na nekog profesora i pritisnuti drugo dugme na toolbaru ili Edit->Edit. Izmena ima zastite slicne kao i za dodavanje profesora.\r\n" + 
				"****NEZAVRSENO****\r\n" + 
				"2.4)Brisanje profesora(CTRL+D na tabu 'Profesori')\r\n" + 
				"Potrebno je kliknuti na nekog profesora i pritisnuti trece dugme na toolbaru ili Edit->Delete\r\n" + 
				"\r\n" + 
				"3.PREDMET ENTITET\r\n" + 
				"3.1)Prikaz predmeta\r\n" + 
				"Tabela sa informacijama o predmetima se nalazi u tabu 'Predmetima'. Klikom na naziv svake od kolona moguce je vrsiti opadajuce ili rastuce sortiranje prema vrednosti izabrane kolone. Takodje, moguce je vrsiti promenu redosleda kolona klikom na naziv kolone i prevlacenjem iste na mesto neke druge kolone.\r\n" + 
				"Primer pravilno unesenih polja za dodavanje predmeta:\r\n" + 
				"Sifra: alg2\r\n" + 
				"Naziv: Algebra 2\r\n" + 
				"comboBox(Semestar i Godina studija)\r\n" + 
				"ESPB: 6\r\n" + 
				"Predmetni Profesor: Kosta Kovacevic\r\n" + 
				"3.2)Dodavanje predmeta(CTRL+N na tabu 'Predmeti')\r\n" + 
				"Dijalog za dodavanje predmeta je moguce otvoriti preko prvog dugmeta na toolbar-u ili u meniju File->New\r\n" + 
				"Potrebno je odgovarajuce popuniti sva polja. Postoje zastite za svako polje da li je pravilno popunjeno, takodje nije moguce dodati predmet sa sifrom predmeta koja vec postoji u tabeli.\r\n" + 
				"3.3)Izmena predmeta(CTRL+E na tabu 'Predmeti')\r\n" + 
				"Potrebno je kliknuti na neki predmet i pritisnuti drugo dugme na toolbaru ili Edit->Edit. Izmena ima zastite slicne kao i za dodavanje predmeta.\r\n" + 
				"3.4)Brisanje predmeta(CTRL+N na tabu 'Predmeti')\r\n" + 
				"Potrebno je kliknuti na neki predmet i pritisnuti trece dugme na toolbaru ili Edit->Delete\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"NAPOMENA: nije uradjena pretraga, serijalizacija, i potrebno je ispraviti pojedine sitne bagove\r\n" + 
				"\r\n" + 
				"Na projektu rade: Mitar Brankovic i Srdjan Beric"
				
				
				
				
				);
		tekst.setEditable(false);
		
		JPanel dugmeDole = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				
			}
		});
		
		dugmeDole.add(cancel);
		
		Box paneli = Box.createVerticalBox();
		paneli.add(dugmeDole);
		paneli.add(ukrasniPanel);
		paneli.setPreferredSize(new Dimension(40,40));
		this.add(tekst,BorderLayout.CENTER);
		this.add(paneli,BorderLayout.SOUTH);
		setSize(900, 500);
		setLocationRelativeTo(null);
		//setVisible(true);
		
	}
	
	
}
