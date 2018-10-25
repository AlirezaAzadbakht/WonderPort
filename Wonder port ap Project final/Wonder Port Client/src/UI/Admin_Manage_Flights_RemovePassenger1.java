package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Admin_Manage_Flights_RemovePassenger1 extends SubClassesSmallFrame {
	public JLabel flightsList;
	public Admin_Manage_Flights_RemovePassenger1() {
		ImageIcon footer0 = new ImageIcon("SmallRemovePHeader.png");
		JLabel footerImage0 = new JLabel(footer0);
		footerImage0.setBounds(0, 0, 400, 30);
		add(footerImage0);
		
		
		flightsList = new JLabel();
		flightsList.setBounds(5, 30, 300, 200);
		add(flightsList);
	
		final JTextField num = new JTextField("  FlightNumber   ");
		num.setBounds(145, 300, 110, 30);
		add(num);
		
		
		JButton open = new JButton(" O P E N ");
		open.setBounds(200, 350, 130, 40);
		add(open);
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.removePassenger2=new Admin_Manage_Flights_RemovePassenger2();
                MainClassAfterUi.removePassenger2.selectedID=Integer.valueOf(num.getText());
				navigateAndSaveLastFrame(MainClassAfterUi.removePassenger2);
				
			}
		});
		
		JButton close = new JButton(" C L O S E ");
		close.setBounds(50, 350, 130, 40);
		add(close);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigateAndSaveLastFrame(MainClassAfterUi.flightsM);
				
			}
		});
		
		JLabel info = new JLabel("Enter  \" Flight NAME\" And \"OPEN\" Its Passengers !  ");
		info.setBounds(70, 400, 400, 30);
		add(info);
	}

}
