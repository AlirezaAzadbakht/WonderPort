package UI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;

public class User_Rerport extends SubClassesFrame {
	public User_Rerport() {
		SubClassesFrameMaker("User_Report.png");
		
		
		JButton planesButton = new JButton("AirPlanes");
		planesButton.setBounds(100, 135, 120, 60);
		this.add(planesButton);
		planesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				jsonData j =new jsonData(2, null, null, null, null, null, 0, 0, null, null, null, 0, 0, 0, false);
				try {
					jsonData.writeSocketMyJson(j);
					String msg = jsonData.readSocket();
                    MainClassAfterUi.airPlanesR=new Admin_Report_AirPlanes();
                    MainClassAfterUi.airPlanesR.SubClassesLabelMaker(msg);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                navigate(MainClassAfterUi.airPlanesR);
				
				
			}
		});
		
		JButton portsButton = new JButton("AirPorts");
		portsButton.setBounds(300, 135, 120, 60);
		this.add(portsButton);
		portsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				jsonData j =new jsonData(3, null, null, null, null, null, 0, 0, null, null, null, 0, 0, 0, false);
				try {
					jsonData.writeSocketMyJson(j);
					String msg = jsonData.readSocket();
                    System.out.println(msg);
                    MainClassAfterUi.airPortsR = new Admin_Report_AirPorts();
					MainClassAfterUi.airPortsR.SubClassesLabelMaker(msg);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                navigate(MainClassAfterUi.airPortsR);
			}
		});
		
		JButton flightsButton = new JButton("Flights");
		flightsButton.setBounds(100, 220, 120, 60);
		this.add(flightsButton);
		flightsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				jsonData j =new jsonData(4, null, null, null, null, null, 0, 0, null, null, null, 0, 0, 0, false);
				try {
					jsonData.writeSocketMyJson(j);
					String msg = jsonData.readSocket();
                    MainClassAfterUi.flightsR =new Admin_Report_Flights();
					MainClassAfterUi.flightsR.SubClassesLabelMaker(msg);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                navigate(MainClassAfterUi.flightsR);
				
			}
		});
		
		//JButton planeFlight = new JButton("Plane's Flights");
		//planeFlight.setBounds(300, 220, 120, 60);
		//this.add(planeFlight);
		
		
		//JButton portFlight = new JButton("Port's Flights");
		//portFlight.setBounds(200, 295, 120, 60);
		//this.add(portFlight);
		
		JLabel space = new JLabel(" ");
		add(space);
		
		
	}
}
