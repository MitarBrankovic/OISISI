package projekat;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar{
	public Toolbar() {
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		
		JButton btnOpen = new JButton();
		//btnOpen.setPreferredSize(new Dimension(20,20));
		btnOpen.setToolTipText("Open");
		panel.add(btnOpen);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		//btnEdit.setPreferredSize(new Dimension(20,20));
		btnEdit.setToolTipText("Edit");
		panel.add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		//btnDelete.setPreferredSize(new Dimension(20,20));
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("images/delete1.jpg"));
		panel.add(btnDelete);
		
		addSeparator();
		
		panel.add(Box.createHorizontalGlue());
		
		JTextField searchArea = new JTextField();
		//searchArea.setBounds(5, 5, 100, 100);
		searchArea.setPreferredSize(new Dimension(300,25));
		searchArea.setMaximumSize(searchArea.getPreferredSize());
		panel.add(searchArea);
		
		addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		panel.add(btnSearch);
		
		add(panel);
		setFloatable(false);
	}
}
