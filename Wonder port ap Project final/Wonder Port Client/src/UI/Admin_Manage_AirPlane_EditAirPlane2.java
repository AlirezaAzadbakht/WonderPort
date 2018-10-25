package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.IOException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Admin_Manage_AirPlane_EditAirPlane2 extends SubClassesSmallFrame {
	int selectedID;

	public Admin_Manage_AirPlane_EditAirPlane2() {
		
		
		ImageIcon footer0 = new ImageIcon("SmallEditAAHeader.png");
		JLabel footerImage0 = new JLabel(footer0);
		footerImage0.setBounds(0, 0, 400, 30);
		add(footerImage0);
		
	
		final JTextField AirPlane = new JTextField("        AirPlane Name   ");
		AirPlane.setBounds(100, 100, 170, 45);
		add(AirPlane);
		
		final JTextField pilot = new JTextField("          Pilot Name   ");
		pilot.setBounds(100, 172, 170, 45);
		add(pilot);
		
		final JTextField CPilot = new JTextField("         Co-Pilot Name   ");
		CPilot.setBounds(100, 250, 170, 45);
		add(CPilot);
		
		
		JButton confirm = new JButton(" C O N F I R M ");
		confirm.setBounds(200, 350, 130, 40);
		add(confirm);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigate(MainClassAfterUi.airPlanesM);
				jsonData j;
                j = new jsonData(7, null, null, AirPlane.getText(), pilot.getText(), CPilot.getText(), 0, 0, null, null, null, 0, 0, selectedID, false);
                try {
					jsonData.writeSocketMyJson(j);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		JButton close = new JButton(" C L O S E ");
		close.setBounds(50, 350, 130, 40);
		add(close);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigate(MainClassAfterUi.airPlanesM);
				
			}
		});
		
		JLabel info = new JLabel("Fill in The Blanks  and \"CONFIRM\"  ");
		info.setBounds(80, 400, 400, 30);
		add(info);
	}
}
