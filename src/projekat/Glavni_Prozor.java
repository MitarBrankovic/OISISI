package projekat;

import javax.swing.*;
import java.awt.*;


public class Glavni_Prozor extends JFrame{
	
	private static final long serialVersionUID = 1681906113857801298L;

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
			
		

		StatusBar status = new StatusBar();		
		add(status, BorderLayout.SOUTH);
		

		Toolbar toolbar1 = new Toolbar();
		add(toolbar1, BorderLayout.NORTH);
		
		TabPane tabpane = new TabPane();
		add(tabpane, BorderLayout.CENTER);
		
		setVisible(true);
		
		
	}
	
}
