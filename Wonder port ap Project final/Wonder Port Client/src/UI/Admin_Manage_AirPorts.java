package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Admin_Manage_AirPorts extends SubClassesFrame{
	public Admin_Manage_AirPorts() {
		SubClassesFrameMaker("AirPortsM.png");
		
		ImageIcon add = new ImageIcon("add.png");
		ImageIcon remove = new ImageIcon("remove.png");
		ImageIcon edit = new ImageIcon("edit.png");
		
		JButton addButton = new JButton("                                 ADD AirPort                                 ");
		addButton.setBounds(50, 120, 330, 50);
		addButton.setIcon(add);
		this.add(addButton);
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigateAndSaveLastFrame(MainClassAfterUi.addAirPort);
				
			}
		});
		
		
		JButton removeButton = new JButton("                              REMOVE AirPort                              ");
		removeButton.setBounds(50, 170, 330, 50);
		removeButton.setIcon(remove);
		this.add(removeButton);
		removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.removeAirPort=new Admin_Manage_AirPort_RemoveAirPort();
                Admin_Manage_AirPort_RemoveAirPort.flightsList.setText(jsonData.getPorts());
				navigateAndSaveLastFrame(MainClassAfterUi.removeAirPort);
				
			}
		});
		
		
		JButton editButton = new JButton("                                EDIT AirPort                                 ");
		editButton.setBounds(50, 225, 330, 50);
		editButton.setIcon(edit);
		this.add(editButton);
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.editAirPort1=new Admin_Manage_AirPort_EditAirPort1();
                Admin_Manage_AirPort_EditAirPort1.flightsList.setText(jsonData.getPorts());
				navigateAndSaveLastFrame(MainClassAfterUi.editAirPort1);
				
			}
		});
		
		
		
		JLabel space = new JLabel();
		add(space);
				
	}
}
