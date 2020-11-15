package projekat;

import java.awt.*;
import javax.swing.JFrame;

public class Menu extends JFrame {

	public Menu() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screenHeight / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		MenuKonfiguracija menu = new MenuKonfiguracija();
		this.setJMenuBar(menu);
		
	}
	
}
