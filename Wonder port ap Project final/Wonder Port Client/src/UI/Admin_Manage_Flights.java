package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Admin_Manage_Flights extends SubClassesFrame {
	public Admin_Manage_Flights() {
		SubClassesFrameMaker("FlightsM.png");
		
		
		ImageIcon add = new ImageIcon("add.png");
		ImageIcon remove = new ImageIcon("remove.png");
		ImageIcon edit = new ImageIcon("edit.png");
		
		JButton AddButton = new JButton("                                 ADD Flights                                 ");
		AddButton.setBounds(50, 120, 330, 50);
		AddButton.setIcon(add);
		this.add(AddButton);
		AddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.addFlights=new Admin_Manage_Flights_AddFlights();

				String msg=jsonData.NewgetPorts();
				jsonData.splitMeNaddComboBox(msg, MainClassAfterUi.addFlights.originList);
				
				String msg1=jsonData.NewgetPorts();
				jsonData.splitMeNaddComboBox(msg1, MainClassAfterUi.addFlights.destinationList);
				
				String msg2=jsonData.NewgetPlanes();
				jsonData.splitMeNaddComboBox(msg2, MainClassAfterUi.addFlights.planeList);
                navigateAndSaveLastFrame(MainClassAfterUi.addFlights);
			}
		});
		
		
		JButton removeButton = new JButton("                             REMOVE Flights                              ");
		removeButton.setBounds(50, 170, 330, 50);
		removeButton.setIcon(remove);
		this.add(removeButton);
		removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.removeFlights=new Admin_Manage_Flights_RemoveFlights();
				MainClassAfterUi.removeFlights.flightsList.setText(jsonData.getFlights());
				navigateAndSaveLastFrame(MainClassAfterUi.removeFlights);
				
			}
		});
		
		
		JButton editButton = new JButton("                                 EDIT Flights                                 ");
		editButton.setBounds(50, 225, 330, 50);   
		editButton.setIcon(edit);
		this.add(editButton);
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.editFlight1=new Admin_Manage_Flights_EditFlight1();
                MainClassAfterUi.editFlight1.flightsList.setText(jsonData.getFlights());
				navigateAndSaveLastFrame(MainClassAfterUi.editFlight1);
				
			}
		});
		
		
		
		JButton addPButton = new JButton("                      ADD Passenger To Flight                      ");
		addPButton.setBounds(50, 280, 330, 50);
		addPButton.setIcon(add);
		this.add(addPButton);
		addPButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.addPassenger1=new Admin_Manage_Flights_AddPassenger1();
                MainClassAfterUi.addPassenger1.flightsList.setText(jsonData.getFlights());
				navigateAndSaveLastFrame(MainClassAfterUi.addPassenger1);
				
			}
		});
		
		
		
		JButton removePButton = new JButton("                REMOVE Passenger from Flight                ");
		removePButton.setBounds(50, 335, 330, 50);
		removePButton.setIcon(remove);
		this.add(removePButton);	
		removePButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.removePassenger1=new Admin_Manage_Flights_RemovePassenger1();
                MainClassAfterUi.removePassenger1.flightsList.setText(jsonData.getFlights());
				navigateAndSaveLastFrame(MainClassAfterUi.removePassenger1);
				
			}
		});
		 
		
		JLabel space = new JLabel();
		add(space);
		
	}
}
