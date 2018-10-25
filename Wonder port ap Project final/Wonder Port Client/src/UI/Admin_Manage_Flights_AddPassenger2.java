package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Admin_Manage_Flights_AddPassenger2 extends SubClassesSmallFrame {
	static int selectedID;
	public Admin_Manage_Flights_AddPassenger2() {
		ImageIcon footer0 = new ImageIcon("SmallAddPHeader.png");
		JLabel footerImage0 = new JLabel(footer0);
		footerImage0.setBounds(0, 0, 400, 30);
		add(footerImage0);
		/*
		JLabel passengerList = new JLabel("    List Of Passengers Will Be Shown Here ! ");
		passengerList.setBounds(5, 30, 300, 200);
		add(passengerList);
		*/
		final JTextField username = new JTextField("name   ");
		username.setBounds(120, 205,150, 40);
		add(username);
		
		/*
		JTextField pass = new JTextField("Password  ");
		pass.setBounds(120, 250, 150, 40);
		add(pass);
		*/
		
		JButton add = new JButton(" ADD Passenger ");
		add.setBounds(200, 350, 130, 40);
		add(add);
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jsonData j;
                j = new jsonData(13, null, null, username.getText(), null, null, 0, 0, null, null, null, 0, 0, selectedID, false);
                try {
					jsonData.writeSocketMyJson(j);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				navigate(MainClassAfterUi.flightsM);
				
			}
		});
		
		
		JButton close = new JButton(" C L O S E ");
		close.setBounds(50, 350, 130, 40);
		add(close);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				navigate(MainClassAfterUi.flightsM);
				
			}
		});
		
		JLabel info = new JLabel("Enter  \"name\"  then \"ADD\" It !  ");
		info.setBounds(60, 400, 400, 30);
		add(info);
	}
}
