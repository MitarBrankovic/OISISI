package projekat;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.sql.Date;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.text.*;

public class StatusBar extends JPanel {

	private static final long serialVersionUID = -8008135208076960055L;

	public StatusBar() {
		setLayout(new BorderLayout());
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JLabel txtLabela = new JLabel("Studentska sluzba ");
		DateFormat vremeFormat = new SimpleDateFormat(" HH:mm dd.MM.yyyy ");
		
		String trenutnoVreme = vremeFormat.format(Calendar.getInstance().getTime());
		JLabel vremeLabela = new JLabel(trenutnoVreme);
		
		ActionListener timerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date datum = new Date(System.currentTimeMillis());
				String vreme = vremeFormat.format(datum);
				vremeLabela.setText(vreme);
			}	
		};
		
		Timer timer = new Timer(0, timerListener);
		timer.setInitialDelay(0);
		timer.start();
		
		add(txtLabela, BorderLayout.WEST);
		add(vremeLabela, BorderLayout.EAST);
				
	}
		
}
