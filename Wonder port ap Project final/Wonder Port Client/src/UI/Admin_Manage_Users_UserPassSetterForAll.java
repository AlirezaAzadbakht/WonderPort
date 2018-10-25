package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Admin_Manage_Users_UserPassSetterForAll extends MyFrame{
	static int usertype;
	public Admin_Manage_Users_UserPassSetterForAll() {
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.white);
		add(northPanel,BorderLayout.NORTH );
		
		ImageIcon passImageIcon = new ImageIcon("UsersM.png") ;
		JLabel passIcon = new JLabel(passImageIcon);
		northPanel.add(passIcon);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		add(centerPanel, BorderLayout.CENTER);
		
		
		JLabel space = new JLabel();
		space.setMaximumSize(new Dimension(70, 80));
		centerPanel.add(space);
		
		
		JLabel newPass = new JLabel("ENTER Your UseName And Password Here ");
		//newPass.setMaximumSize(new Dimension(150, 150));
		centerPanel.add(newPass);

		JLabel space1 = new JLabel();
		space1.setMaximumSize(new Dimension(70, 20));
		centerPanel.add(space1);
		
		final JTextField userField = new JTextField("UserName");
		userField.setMaximumSize(new Dimension(200, 35));
		newPass.setAlignmentX(CENTER_ALIGNMENT);
		centerPanel.add(userField);
		
		final JTextField PassField = new JTextField("Password");
		PassField.setMaximumSize(new Dimension(200, 35));
		newPass.setAlignmentX(CENTER_ALIGNMENT);
		centerPanel.add(PassField);
		

		JLabel space2 = new JLabel();
		space2.setMaximumSize(new Dimension(70, 240));
		centerPanel.add(space2);		
		
		JButton confirm = new JButton(" C O N F I R M ");
		confirm.setAlignmentX(CENTER_ALIGNMENT);
		confirm.setBackground(Color.BLACK);
		confirm.setForeground(Color.white);
		confirm.setOpaque(true);
		confirm.setBorderPainted(false);
		centerPanel.add(confirm);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jsonData j =new jsonData(17, userField.getText(), PassField.getText(), null, null, null, 0, 0, null, null, null, 0, 0, usertype, false);
				try {
					jsonData.writeSocketMyJson(j);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				navigate(MainClassAfterUi.usersM);
			}
		});
		
		JLabel space3 = new JLabel(" ");
		space.setMinimumSize(new Dimension(100, 90));
		centerPanel.add(space3);
		
		
		JButton back = new JButton("Back");
		back.setAlignmentX(CENTER_ALIGNMENT);
		centerPanel.add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigate(MainClassAfterUi.usersM);
			}
		});
		
	}
}
