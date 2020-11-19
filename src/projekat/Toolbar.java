package projekat;


import java.awt.Dimension;
//import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar{

	private static final long serialVersionUID = -5468997179840595624L;

	public Toolbar() {
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		
		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("images/add.jpg"));
		panel.add(btnOpen);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		panel.add(btnEdit);
		btnEdit.setIcon(new ImageIcon("images/edit.jpg"));
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("images/delete1.jpg"));
		panel.add(btnDelete);
		
		addSeparator();
		
		panel.add(Box.createHorizontalGlue());
		
		JTextField searchArea = new JTextField();
		searchArea.setPreferredSize(new Dimension(200,25));
		searchArea.setMaximumSize(searchArea.getPreferredSize());
		panel.add(searchArea);
		
		addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("images/search.jpg"));
		panel.add(btnSearch);
		
		add(panel);
		setFloatable(false);
	}
}
