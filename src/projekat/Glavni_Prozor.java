package projekat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;


public class Glavni_Prozor extends JFrame{
	public Glavni_Prozor() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth * 3/4, screenHeight * 3/4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Studentska služba");
		
		MenuKonfiguracija menu = new MenuKonfiguracija();
		setJMenuBar(menu);
		
		Toolbar toolbar1 = new Toolbar();
		add(toolbar1, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
}
