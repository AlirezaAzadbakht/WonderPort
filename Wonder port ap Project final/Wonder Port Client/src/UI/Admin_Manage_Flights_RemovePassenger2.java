package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Admin_Manage_Flights_RemovePassenger2 extends SubClassesSmallFrame {
	static int selectedID;
	public Admin_Manage_Flights_RemovePassenger2() {
	 
		
		ImageIcon footer0 = new ImageIcon("SmallRemovePHeader.png");
		JLabel footerImage0 = new JLabel(footer0);
		footerImage0.setBounds(0, 0, 400, 30);
		add(footerImage0);
		
		/*
		JLabel flightsList = new JLabel("    List Of Flights Will Be Shown Here ! ");
		flightsList.setBounds(5, 30, 300, 200);
		add(flightsList);
		*/
		final JTextField num = new JTextField("   NAME");
		num.setBounds(170, 300, 70, 30);
		add(num);
		
		
		JButton remove = new JButton(" R E M O V E  ");
		remove.setBounds(200, 350, 130, 40);
		add(remove);
		remove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jsonData j;
                j = new jsonData(14, null, null, num.getText(), null, null, 0, 0, null, null, null, 0, 0, selectedID, false);
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
		
		JLabel info = new JLabel("Enter  \"Passenger NAME\" And \"REMOVE\" That !  ");
		info.setBounds(75, 400, 400, 30);
		add(info);
}
}
