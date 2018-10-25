package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Admin_Manage_Flights_EditFlight1 extends SubClassesSmallFrame {
	public JLabel flightsList;
	public Admin_Manage_Flights_EditFlight1() {
		ImageIcon footer0 = new ImageIcon("SmallEditHeader.png");
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
                MainClassAfterUi.editFlight2=new Admin_Manage_Flights_EditFlight2();
                MainClassAfterUi.editFlight2.selectedID=Integer.valueOf(num.getText());
				String msg=jsonData.NewgetPorts();
				jsonData.splitMeNaddComboBox(msg, MainClassAfterUi.editFlight2.originList);
				
				String msg1=jsonData.NewgetPorts();
				jsonData.splitMeNaddComboBox(msg1, MainClassAfterUi.editFlight2.destinationList);
				
				String msg2=jsonData.NewgetPlanes();
				jsonData.splitMeNaddComboBox(msg2, MainClassAfterUi.editFlight2.planeList);
				navigateAndSaveLastFrame(MainClassAfterUi.editFlight2);
				
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
		
		JLabel info = new JLabel("Enter  \" Flight NAME\" And \"OPEN\" Its Passengers !  ");
		info.setBounds(70, 400, 400, 30);
		add(info);
	}
}
