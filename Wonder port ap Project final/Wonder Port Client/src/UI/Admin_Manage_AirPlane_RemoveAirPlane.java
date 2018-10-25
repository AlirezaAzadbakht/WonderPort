package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Admin_Manage_AirPlane_RemoveAirPlane extends SubClassesSmallFrame {
	static JLabel flightsList;
	public Admin_Manage_AirPlane_RemoveAirPlane() {
		
		
		ImageIcon footer0 = new ImageIcon("SmallRemoveAAHeader.png");
		JLabel footerImage0 = new JLabel(footer0);
		footerImage0.setBounds(0, 0, 400, 30);
		add(footerImage0);
		
	
		final JTextField AirPlane = new JTextField("        AirPlane Id   ");
		AirPlane.setBounds(100, 200, 170, 40);
		add(AirPlane);
		
		
		flightsList = new JLabel();
		flightsList.setBounds(5, 30, 300, 200);
		add(flightsList);
		
		JButton remove = new JButton(" R E M O V E ");
		remove.setBounds(200, 350, 130,40);
		add(remove);
		remove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				jsonData j;
                j = new jsonData(8, null, null, null, null, null, 0, 0, null, null, null, 0, 0, Integer.valueOf(AirPlane.getText()), false);
                try {
					jsonData.writeSocketMyJson(j);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                navigate(MainClassAfterUi.airPlanesM);
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
		
		JLabel info = new JLabel("Enter  \" AirPlane Name\" and \"CONFIRM\"  ");
		info.setBounds(80, 400, 400, 30);
		add(info);
	}
}
