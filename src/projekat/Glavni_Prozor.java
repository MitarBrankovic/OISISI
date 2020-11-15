package projekat;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;


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
		setVisible(true);
		setTitle("Studentska služba");
	}
	
}
