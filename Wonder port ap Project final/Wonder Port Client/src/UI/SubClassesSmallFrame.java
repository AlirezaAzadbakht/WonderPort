package UI;

import javax.swing.JFrame;

public class SubClassesSmallFrame extends JFrame {

	
 public SubClassesSmallFrame() {
		
	 	setLayout(null);
	 	setTitle(" EDIT TASK ");
		setSize(400, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//getContentPane().setBackground(Color.WHITE);
		setVisible(false);
}
	
	public void navigate(JFrame navigateTarget){
		this.setVisible(false);
		navigateTarget.setVisible(true);
	}
	
	public void navigateAndSaveLastFrame(JFrame addAirPlane){
		addAirPlane.setVisible(true);
	}
	
}
