package view;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar{

	private static final long serialVersionUID = -5468997179840595624L;

	public Toolbar() {
		
		
		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("images" + File.separator + "add.jpg"));
		
		btnOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(TabPane.getStanje() == 0) {
					AddStudentFrame asf = new AddStudentFrame();
					asf.setVisible(true);
				}else if(TabPane.getStanje() == 1) {
					AddProfesorFrame apf = new AddProfesorFrame();
					apf.setVisible(true);
				}else if(TabPane.getStanje() == 2){
					AddPredmetFrame aprf = new AddPredmetFrame();
					aprf.setVisible(true);
				}				
			}					
		});		
		
		add(btnOpen);
		
		addSeparator();
		
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		add(btnEdit);
		btnEdit.setIcon(new ImageIcon("images" + File.separator + "edit.jpg"));
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("images" + File.separator + "delete1.jpg"));
		add(btnDelete);
		
		addSeparator();
		
		add(Box.createHorizontalGlue());
		
		JTextField searchArea = new JTextField();
		searchArea.setPreferredSize(new Dimension(200,25));
		searchArea.setMaximumSize(searchArea.getPreferredSize());
		add(searchArea);
		
		addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("images" + File.separator + "search.jpg"));
		add(btnSearch);
		
		
		setFloatable(false);
	}
}
