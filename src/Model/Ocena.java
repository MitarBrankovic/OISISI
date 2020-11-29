package Model;

public class Ocena {
	Student student;
	Predmet predmet;
	int[] vrednostOcene = {6, 7, 8, 9, 10};
	String datumPolaganja;
		
	public Ocena(Student student, Predmet predmet, int[] vrednostOcene, String datumPolaganja) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.vrednostOcene = vrednostOcene;
		this.datumPolaganja = datumPolaganja;
	}
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public int[] getVrednostOcene() {
		return vrednostOcene;
	}
	public void setVrednostOcene(int[] vrednostOcene) {
		this.vrednostOcene = vrednostOcene;
	}
	public String getDatumPolaganja() {
		return datumPolaganja;
	}
	public void setDatumPolaganja(String datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}
	
	
}
