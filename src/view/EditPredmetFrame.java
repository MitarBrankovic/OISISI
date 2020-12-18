package view;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class EditPredmetFrame extends JDialog {


	private static final long serialVersionUID = 9105513801690139962L;
	
	private static EditPredmetFrame instance = null;
    public static EditPredmetFrame getInstance() {
        if (instance == null) {
            instance = new EditPredmetFrame();
        }
        return instance;
    }
	public EditPredmetFrame() {
		
		setTitle("Izmena Predmeta");
		setSize(400, 400);
		setModal(true);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		PredmetInfo pi = PredmetInfo.getInstance();
		
		JTabbedPane predmetIn = new JTabbedPane();
		predmetIn.addTab("Informacije", pi);
		
		add(predmetIn, BorderLayout.CENTER);
		
		
	}
}
