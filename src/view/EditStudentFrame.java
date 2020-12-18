package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class EditStudentFrame extends JDialog {

	private static final long serialVersionUID = -1126183099640299201L;

	private static EditStudentFrame instance = null;
    public static EditStudentFrame getInstance() {
        if (instance == null) {
            instance = new EditStudentFrame();
        }
        return instance;
    }
	
	public EditStudentFrame() {
		
		setTitle("Izmena Studenta");
		setSize(400, 500);
		setModal(true);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		StudentInfo si = StudentInfo.getInstance();
		
		JTabbedPane studentin = new JTabbedPane();
		studentin.addTab("Informacije", si);
		
		add(studentin, BorderLayout.CENTER);
	}
	
	
}
