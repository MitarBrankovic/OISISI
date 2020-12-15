package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

//import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
//import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class MenuKonfiguracija extends JMenuBar {

	private static final long serialVersionUID = -18453638905844029L;

	public MenuKonfiguracija() {
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem fNew = new JMenuItem("New");
		fNew.setIcon(new ImageIcon("images" + File.separator + "add.jpg"));
		fNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		fNew.setMnemonic(KeyEvent.VK_N);
		
		fNew.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddStudentFrame asf = new AddStudentFrame();				
			}
		});
		
		JMenuItem fClose = new JMenuItem("Close");
		fClose.setIcon(new ImageIcon("images" + File.separator + "close.jpg"));
		fClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		fClose.setMnemonic(KeyEvent.VK_C);
		
		fClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);		
			}	
		});
		
		file.add(fNew);
		file.addSeparator();
		file.add(fClose);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
		JMenuItem eEdit = new JMenuItem("Edit");
		eEdit.setIcon(new ImageIcon("images" + File.separator + "edit.jpg"));
		eEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		eEdit.setMnemonic(KeyEvent.VK_E);
		JMenuItem eDelete = new JMenuItem("Delete");
		eDelete.setIcon(new ImageIcon("images" + File.separator + "delete1.jpg"));
		eDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		eDelete.setMnemonic(KeyEvent.VK_D);
		
		
		edit.add(eEdit);
		edit.addSeparator();
		edit.add(eDelete);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem hHelp = new JMenuItem("Help");
		hHelp.setIcon(new ImageIcon("images" + File.separator + "help1.png"));
		hHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		hHelp.setMnemonic(KeyEvent.VK_H);
		JMenuItem hAbout = new JMenuItem("About");
		hAbout.setIcon(new ImageIcon("images" + File.separator + "about1.png"));
		hAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		hAbout.setMnemonic(KeyEvent.VK_A);
		
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
