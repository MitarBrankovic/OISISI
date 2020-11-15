package projekat;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MenuKonfiguracija extends JMenuBar {

	public MenuKonfiguracija() {
		JMenu file = new JMenu("File");
		JMenuItem fNew = new JMenuItem("New       Ctrl + N");
		JMenuItem fClose = new JMenuItem("Close       Ctrl + C");
		
		file.add(fNew);
		file.addSeparator();
		file.add(fClose);
		
		JMenu edit = new JMenu("Edit");
		JMenuItem eEdit = new JMenuItem("Edit");
		JMenuItem eDelete = new JMenuItem("Delete");
		
		edit.add(eEdit);
		edit.addSeparator();
		edit.add(eDelete);
		
		JMenu help = new JMenu("Help");
		JMenuItem hHelp = new JMenuItem("Help");
		JMenuItem hAbout = new JMenuItem("About");
		
		help.add(hHelp);
		help.addSeparator();
		help.add(hAbout);

		add(file);
		add(edit);
		add(help);
	}
	
	
}
