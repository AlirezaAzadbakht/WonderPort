package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Admin extends MyFrame {
	public static int checker = 0; //0 for admin
	
	public Admin(){
		
		//setVisible(true); //should change
		
		
		setLayout(null);
		
		this.getContentPane().setBackground( Color.DARK_GRAY );
		
		ImageIcon reportIcon = new ImageIcon("report.png");
		JLabel reportsTitle = new JLabel(reportIcon);
		reportsTitle.setBounds(173, 5 , 150, 150);
		this.add(reportsTitle);

		ImageIcon reportImageIcon = new ImageIcon("reportIconImage.png");
		JLabel reportsIcon = new JLabel(reportImageIcon);
		reportsIcon.setBounds(173, 100 , 150, 150);
		this.add(reportsIcon);
		
		
		
		JButton planesButton = new JButton("AirPlanes");
		planesButton.setBounds(100, 115, 100, 50);
		this.add(planesButton);
		planesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				checker = 0;
                MainClassAfterUi.airPlanesR=new Admin_Report_AirPlanes();
				MainClassAfterUi.airPlanesR.SubClassesLabelMaker(jsonData.getPlanes());

                navigate(MainClassAfterUi.airPlanesR);
			}
		});
		
		JButton portsButton = new JButton("AirPorts");
		portsButton.setBounds(300, 115, 100, 50);
		this.add(portsButton);
		portsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				checker = 0;
                MainClassAfterUi.airPortsR = new Admin_Report_AirPorts();
                MainClassAfterUi.airPortsR.SubClassesLabelMaker(jsonData.getPorts());
                navigate(MainClassAfterUi.airPortsR);
			}
		});
		
		JButton flightsButton = new JButton("Flights");
		flightsButton.setBounds(100, 200, 100, 50);
		this.add(flightsButton);
		flightsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				checker = 0;
                MainClassAfterUi.flightsR = new Admin_Report_Flights();
                MainClassAfterUi.flightsR.SubClassesLabelMaker(jsonData.getFlights());
                navigate(MainClassAfterUi.flightsR);
			}
		});
		
		JButton usersButton = new JButton("Users");
		usersButton.setBounds(300, 200, 100, 50);
		this.add(usersButton);
		usersButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				checker = 0;
                MainClassAfterUi.usersR = new Admin_Report_Users();
                MainClassAfterUi.usersR.SubClassesLabelMaker(jsonData.getUsers());
                navigate(MainClassAfterUi.usersR);
				
			}
		});

        JButton flightPassengers = new JButton("flight's passengers");
        flightPassengers.setBounds(100, 275, 150, 50);
        this.add(flightPassengers);
        flightPassengers.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.showPass1=new Admin_Manage_Flights_ShowPassengers1();
                MainClassAfterUi.showPass1.flightsList.setText(jsonData.getFlights());
                navigateAndSaveLastFrame(MainClassAfterUi.showPass1);

            }
        });

		
		ImageIcon manageIcon = new ImageIcon("manage.png");
		JLabel manageTitle = new JLabel(manageIcon);
		manageTitle.setBounds(160, 250, 200, 200);
		this.add(manageTitle);
		
		ImageIcon manageImageIcon = new ImageIcon("manageImageIcon.png");
		JLabel managesIcon = new JLabel(manageImageIcon);
		managesIcon.setBounds(170, 370 , 150, 150);
		this.add(managesIcon);
		
		JButton planesButtonM = new JButton("AirPlanes");
		planesButtonM.setBounds(100, 385, 100, 50);
		this.add(planesButtonM);
		planesButtonM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigate(MainClassAfterUi.airPlanesM);
				
			}
		});
		
		JButton portsButtonM = new JButton("AirPorts");
		portsButtonM.setBounds(300, 385, 100, 50);
		this.add(portsButtonM);
		portsButtonM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigate(MainClassAfterUi.airPortsM);
				
			}
		});
		
		JButton flightsButtonM = new JButton("Flights");
		flightsButtonM.setBounds(100, 460, 100, 50);
		this.add(flightsButtonM);
		flightsButtonM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigate(MainClassAfterUi.flightsM);
				
			}
		});
		
		JButton usersButtonM = new JButton("Users");
		usersButtonM.setBounds(300, 460, 100, 50);
		this.add(usersButtonM);
		usersButtonM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigate(MainClassAfterUi.usersM);
				
			}
		});
		
		
		JButton logOut = new JButton("L O G   O U T ");
		logOut.setBounds(40, 560, 200, 50);
		this.add(logOut);
		logOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainClassAfterUi.login = new Login();
				
				navigate(MainClassAfterUi.login);
				
			}
		});
		
		JButton changePass = new JButton("C H A N G E   P A S S");
		changePass.setBounds(245, 560, 200, 50);
		this.add(changePass);
		changePass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.changePassword=new Admin_ChangePassword();
                navigate(MainClassAfterUi.changePassword);
				checker = 0;
				
			}
		});
		
		

	}
}
