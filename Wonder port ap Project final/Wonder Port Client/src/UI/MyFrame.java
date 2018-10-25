package UI;

import java.awt.Color;
import java.net.Socket;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame(){
		setTitle("WonderPort");
		setSize(500, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
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
