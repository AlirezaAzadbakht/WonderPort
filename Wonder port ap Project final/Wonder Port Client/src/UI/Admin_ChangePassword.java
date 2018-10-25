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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Admin_ChangePassword extends MyFrame{
	public Admin_ChangePassword() {
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.white);
		add(northPanel,BorderLayout.NORTH );
		
		ImageIcon passImageIcon = new ImageIcon("ChangePass.png") ;
		JLabel passIcon = new JLabel(passImageIcon);
		northPanel.add(passIcon);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		add(centerPanel, BorderLayout.CENTER);
		
		
		JLabel space = new JLabel();
		space.setMaximumSize(new Dimension(70, 80));
		centerPanel.add(space);
		
		
		JLabel newPass = new JLabel("ENTER Your NEW  Password Here ");
		//newPass.setMaximumSize(new Dimension(150, 150));
		centerPanel.add(newPass);

		JLabel space1 = new JLabel();
		space1.setMaximumSize(new Dimension(70, 20));
		centerPanel.add(space1);
		
		final JTextField newPassField = new JTextField("New Password");
		newPassField.setMaximumSize(new Dimension(200, 40));
		newPass.setAlignmentX(CENTER_ALIGNMENT);
		centerPanel.add(newPassField);
		

		JLabel space2 = new JLabel();
		space2.setMaximumSize(new Dimension(70, 240));
		centerPanel.add(space2);		
		
		JButton confirm = new JButton(" C O N F I R M ");
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jsonData j =new jsonData(18, null, newPassField.getText(), null, null, null, 0, 0, null, null, null, 0, 0, MainClassAfterUi.logedinId, false);
				try {
					jsonData.writeSocketMyJson(j);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                if(Admin.checker == 0)
                    navigate(MainClassAfterUi.admin);
                else if(Admin.checker == 1)
                    navigate(MainClassAfterUi.user);
			}
		});
		confirm.setAlignmentX(CENTER_ALIGNMENT);
		confirm.setBackground(Color.BLACK);
		confirm.setForeground(Color.white);
		confirm.setOpaque(true);
		confirm.setBorderPainted(false);
		centerPanel.add(confirm);
		
		JLabel space3 = new JLabel(" ");
		space.setMinimumSize(new Dimension(100, 90));
		centerPanel.add(space3);
		
		
		JButton back = new JButton("Back");
		back.setAlignmentX(CENTER_ALIGNMENT);
		centerPanel.add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Admin.checker == 0)
					navigate(MainClassAfterUi.admin);
				else if(Admin.checker == 1)
					navigate(MainClassAfterUi.user);
			}
		});
		
	}
}
