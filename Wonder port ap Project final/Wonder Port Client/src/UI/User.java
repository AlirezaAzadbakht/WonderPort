package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class User extends MyFrame {
    static JLabel upcoming;
	public User() {
		//setVisible(true);// should  be Deleted
		
		
		this.getContentPane().setBackground( Color.DARK_GRAY );
		
		setLayout(null);	
		JLabel upcomingLabel = new JLabel(" Your   U P C O M I N G   Events : ");
		upcomingLabel.setBounds( 20, 5,300, 30);
		upcomingLabel.setForeground(Color.white);
		add(upcomingLabel);
		
		upcoming = new JLabel();
		upcoming.setBounds(20, 50, 460, 300);
		upcoming.setBackground(Color.white);
		upcoming.setOpaque(true);
		add(upcoming);
		
		JButton report = new JButton(" R E P O R T S " );
		report.setBounds(175, 385, 210, 40);
		add(report);
		report.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigate(MainClassAfterUi.userReport);
				Admin.checker = 1; //1 for user
			}
		});
		
		
		JButton changePass = new JButton("C H A N G E   P A S S" );
		changePass.setBounds(175, 430, 210, 40);
		add(changePass);
		changePass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigate(MainClassAfterUi.changePassword);
				Admin.checker = 1; //1 for user
			}
		});
		
		JButton logOut = new JButton( " L O G   O U T " );
		logOut.setBounds(177, 495, 210, 40);
		logOut.setOpaque(true);
		logOut.setBackground(Color.black);
		add(logOut);
		logOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                MainClassAfterUi.login = new Login();
                navigate(MainClassAfterUi.login);
				
			}
		});
		
		ImageIcon footerIcon = new ImageIcon("UserFooter.png");
		JLabel footer = new JLabel(footerIcon);
		footer.setBounds(0, 535, 500, 80);
		add(footer);
		
		
	}
}
