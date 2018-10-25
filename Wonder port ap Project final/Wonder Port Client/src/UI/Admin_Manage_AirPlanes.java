package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Admin_Manage_AirPlanes extends SubClassesFrame {
	public Admin_Manage_AirPlanes() {
		SubClassesFrameMaker("AirPlanesM.png");
		

		ImageIcon add = new ImageIcon("add.png");
		ImageIcon remove = new ImageIcon("remove.png");
		ImageIcon edit = new ImageIcon("edit.png");
		
		JButton planesButton = new JButton("                                 ADD AirPlane                                 ");
		planesButton.setBounds(50, 120, 330, 50);
		planesButton.setIcon(add);
		this.add(planesButton);
		planesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigateAndSaveLastFrame(MainClassAfterUi.addAirPlane);
				
			}
		});
		
		JButton removeButton = new JButton("                              REMOVE AirPlane                              ");
		removeButton.setBounds(50, 170, 330, 50);
		removeButton.setIcon(remove);
		this.add(removeButton);
		removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.removeAirPlane=new Admin_Manage_AirPlane_RemoveAirPlane();
                MainClassAfterUi.removeAirPlane.flightsList.setText(jsonData.getPlanes());
                navigateAndSaveLastFrame(MainClassAfterUi.removeAirPlane);
				
			}
		});
		
		
		
		JButton editButton = new JButton("                                EDIT AirPlane                                 ");
		editButton.setBounds(50, 225, 330, 50);
		editButton.setIcon(edit);
		this.add(editButton);
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.editAirPlane1=new Admin_Manage_AirPlane_EditAirPlane1();
				Admin_Manage_AirPlane_EditAirPlane1.flightsList.setText(jsonData.getPlanes());
				navigateAndSaveLastFrame(MainClassAfterUi.editAirPlane1);
				
			}
		});

		
		JLabel space = new JLabel();
		add(space);

	}
}
