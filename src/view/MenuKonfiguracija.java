package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

//import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MenuKonfiguracija extends JMenuBar {

	private static final long serialVersionUID = -18453638905844029L;

	public MenuKonfiguracija() {
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem fNew = new JMenuItem("New");
		fNew.setIcon(new ImageIcon("images/add.jpg"));
		fNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem fClose = new JMenuItem("Close");
		fClose.setIcon(new ImageIcon("images/close.jpg"));
		fClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		file.add(fNew);
		file.addSeparator();
		file.add(fClose);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
		JMenuItem eEdit = new JMenuItem("Edit");
		eEdit.setIcon(new ImageIcon("images/edit.jpg"));
		eEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JMenuItem eDelete = new JMenuItem("Delete");
		eDelete.setIcon(new ImageIcon("images/delete1.jpg"));
		eDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		edit.add(eEdit);
		edit.addSeparator();
		edit.add(eDelete);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem hHelp = new JMenuItem("Help");
		hHelp.setIcon(new ImageIcon("images/help1.png"));
		hHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		JMenuItem hAbout = new JMenuItem("About");
		hAbout.setIcon(new ImageIcon("images/about1.png"));
		hAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		
		help.add(hHelp);
		help.addSeparator();
		help.add(hAbout);
		
		hHelp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				HelpFrame helpf = new HelpFrame();
			}
		});
		
		hAbout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AboutFrame aboutf = new AboutFrame();
			}
		});
	

		add(file);
		add(edit);
		add(help);
	}
	
	
}
