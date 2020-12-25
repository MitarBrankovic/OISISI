package view;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
//import javax.swing.JFrame;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.PredmetController;
import controller.ProfesoriController;
import controller.StudentiController;

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
		
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(TabPane.getStanje() == 0) {
					if(StudentiJTable.getInstance().getSelectedRow() == -1) {
					    JOptionPane.showMessageDialog(null, "Nije selektovan ni jedan student","",JOptionPane.ERROR_MESSAGE);
						}else {
							EditStudentFrame esf = new EditStudentFrame();
							esf.setVisible(true);
						}
					
				}else if(TabPane.getStanje() == 1) {
					
					if(ProfesoriJTable.getInstance().getSelectedRow() == -1) {
					    JOptionPane.showMessageDialog(null, "Nije selektovan ni jedan profesor","",JOptionPane.ERROR_MESSAGE);
						}else {
							EditProfesorFrame epf = new EditProfesorFrame();					
							epf.setVisible(true);
						}
					
				}else if(TabPane.getStanje() == 2){
					
					if(PredmetiJTable.getInstance().getSelectedRow() == -1) {
					    JOptionPane.showMessageDialog(null, "Nije selektovan ni jedan predmet","",JOptionPane.ERROR_MESSAGE);
						}else {
							EditPredmetFrame eprf = new EditPredmetFrame();
							eprf.setVisible(true);
						}			
				}
				
			}
		});
		
		
		add(btnEdit);
		btnEdit.setIcon(new ImageIcon("images" + File.separator + "edit.jpg"));
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("images" + File.separator + "delete1.jpg"));
		
		
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(TabPane.getStanje() == 0) {
					try {
						int option =JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete?","Brisanje studenta?",JOptionPane.YES_NO_OPTION);
						if(option == JOptionPane.YES_OPTION) {
						
							StudentiController.getInstance().removeStudent(StudentiJTable.getInstance().getSelectedRow());
						}
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Morate selektovati studenta!","",JOptionPane.ERROR_MESSAGE);
						System.out.println(e.getMessage());	
					}	


				}else if(TabPane.getStanje() == 1) {
					try {
						int option =JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete?","Brisanje profesora?",JOptionPane.YES_NO_OPTION);
						if(option == JOptionPane.YES_OPTION) {
						
							ProfesoriController.getInstance().removeProfesor(ProfesoriJTable.getInstance().getSelectedRow());
						}
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Morate selektovati profesora!","",JOptionPane.ERROR_MESSAGE);
						System.out.println(e.getMessage());	
					}
										
				}else if(TabPane.getStanje() == 2){
					try {
						int option =JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete?","Brisanje profesora?",JOptionPane.YES_NO_OPTION);
						if(option == JOptionPane.YES_OPTION) {
						
							PredmetController.getInstance().removePredmet(PredmetiJTable.getInstance().getSelectedRow());
						}
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Morate selektovati predmet!","",JOptionPane.ERROR_MESSAGE);
						System.out.println(e.getMessage());	
					}
				}
				
			}
			
		});
		
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
		
		
		String searchTxt = searchArea.getText();
		
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(TabPane.getStanje() == 0) {
					
				}else if(TabPane.getStanje() == 1) {
					//
				}else if(TabPane.getStanje() == 2){
					//
				}				
			}					
		});	
		
		
		add(btnSearch);
		
		
		setFloatable(false);
	}
}
