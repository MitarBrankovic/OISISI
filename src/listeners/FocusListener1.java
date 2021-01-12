package listeners;

/* REFERENCIRAN KOD: pojedini delovi koda preuzeti sa vezbi 4
*/

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;


public class FocusListener1 implements FocusListener {

	@Override
	public void focusGained(FocusEvent arg0) {
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.WHITE);	
	
		if(txt.getText().equals("Unesite ponovo!")){
			txt.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		
		JTextField txt = (JTextField) arg0.getComponent();

		
		
		if (txt.getName().equals("tekst") || txt.getName().equals("ime") || txt.getName().equals("prezime")) {

			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite ponovo!")) {
				txt.setText("Unesite ponovo!");
				/*zbog ove linije ne dozvoljava promenu teksta nakon sto ne popunimo neko polje*/
				//txt.requestFocus();			
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
	}
	
	
	//public boolean checker() {
		//ArrayList<JLabel> labele = AddStudentFrame.getLabele();	
	//}
}
