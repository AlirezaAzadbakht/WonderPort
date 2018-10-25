package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Admin_Manage_Users extends SubClassesFrame{
	public Admin_Manage_Users() {
		SubClassesFrameMaker("UsersM.png");
		
		ImageIcon add = new ImageIcon("add.png");
		ImageIcon remove = new ImageIcon("remove.png");
		ImageIcon edit = new ImageIcon("edit.png");
		
		
		JButton pilot = new JButton("                                      ADD Pilot                                     ");
		pilot.setBounds(50, 170, 330, 50);
		pilot.setIcon(add);
		this.add(pilot);
		pilot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.userPassSetterForAll=new Admin_Manage_Users_UserPassSetterForAll();
				MainClassAfterUi.userPassSetterForAll.usertype=1;
				navigate(MainClassAfterUi.userPassSetterForAll);
				
			}
		});
		
		JButton coPilot = new JButton("                                   ADD Co-Pilot                                   ");
		coPilot.setBounds(50, 225, 330, 50);   
		coPilot.setIcon(add);
		this.add(coPilot);
		coPilot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.userPassSetterForAll=new Admin_Manage_Users_UserPassSetterForAll();
				MainClassAfterUi.userPassSetterForAll.usertype=2;
				navigate(MainClassAfterUi.userPassSetterForAll);
				
			}
		});
		 
		JButton admin = new JButton("                                 ADD Admin                                       ");
		admin.setBounds(50, 280, 330, 50);
		admin.setIcon(add);
		this.add(admin);
		admin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.userPassSetterForAll=new Admin_Manage_Users_UserPassSetterForAll();
                MainClassAfterUi.userPassSetterForAll.usertype=3;
				navigate(MainClassAfterUi.userPassSetterForAll);
				
			}
		});
		
		JButton user = new JButton("                                ADD User                                            ");
		user.setBounds(50, 335, 330, 50);
		user.setIcon(add);
		this.add(user);
		user.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.userPassSetterForAll=new Admin_Manage_Users_UserPassSetterForAll();
				MainClassAfterUi.userPassSetterForAll.usertype=4;
				navigate(MainClassAfterUi.userPassSetterForAll);
				
			}
		});
		
		JButton removeuser = new JButton("                                  REMOVE User                                  ");
		removeuser.setBounds(50, 390, 330, 50);   
		removeuser.setIcon(remove);
		this.add(removeuser);
        removeuser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.removeUsers=new Admin_Manage_Users_RemoveUsers();
                Admin_Manage_Users_RemoveUsers.usersList.setText(jsonData.getUsers());
                navigateAndSaveLastFrame(MainClassAfterUi.removeUsers);

            }
        });

		
		/*
		JButton editUser = new JButton("                                     EDIT User                                     ");
		editUser.setBounds(50, 445, 330, 50);   
		editUser.setIcon(edit);
		this.add(editUser);
		*/
		
		JLabel space = new JLabel();
		add(space);
		
	}
}
