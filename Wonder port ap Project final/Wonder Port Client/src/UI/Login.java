package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends MyFrame{
	public Login(){

		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.white);
		add(northPanel,BorderLayout.NORTH);
		
		ImageIcon loginIconImage = new ImageIcon("loginPicture.png");
		JLabel loginPicture = new JLabel(loginIconImage);
		
		northPanel.add(loginPicture);

		
       
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.BLACK);
		add(centerPanel);
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		JLabel firstSpase = new JLabel();
		firstSpase.setMaximumSize(new Dimension(20,20));
		centerPanel.add(firstSpase);
		
		
		JLabel usernameLabel = new JLabel("Username : ");
		centerPanel.add(usernameLabel);
		usernameLabel.setForeground(Color.white);
		usernameLabel.setAlignmentX(CENTER_ALIGNMENT);
		final JTextField username = new JTextField("Username");
		username.setMaximumSize(new Dimension(200, 40));
		username.setAlignmentX(CENTER_ALIGNMENT);
		centerPanel.add(username);
		
		JLabel secondSpace = new JLabel();
		secondSpace.setMaximumSize(new Dimension(20,20));
		centerPanel.add(secondSpace);
		
		JLabel passwordLabel = new JLabel("Password : ");
		centerPanel.add(passwordLabel);
		passwordLabel.setForeground(Color.white);
		passwordLabel.setAlignmentX(CENTER_ALIGNMENT);
		final JTextField password = new JTextField("Password");
		password.setMaximumSize(new Dimension(200, 40));
		password.setAlignmentX(CENTER_ALIGNMENT);
		centerPanel.add(password);
		
		JLabel thirdSpace = new JLabel();
		thirdSpace.setMaximumSize(new Dimension(60,60));
		centerPanel.add(thirdSpace);
		thirdSpace.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel whatToDo = new JLabel(" Fill in The Blanks to \"ENTER\" " );
		centerPanel.add(whatToDo);
		whatToDo.setForeground(Color.LIGHT_GRAY);
		whatToDo.setAlignmentX(CENTER_ALIGNMENT);

		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.BLACK);
		add(southPanel,BorderLayout.SOUTH);

		JButton loginButton = new JButton("L O G I N");
		southPanel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jsonData j;
                j = new jsonData(1, username.getText(), password.getText(), null, null, null, 0, 0, null, null, null, 0, 0, 0, false);
                try {
					jsonData.writeSocketMyJson(j);
					String Msg=jsonData.readSocket();
					if (Msg.equals("<html>true1</html>"))
					{

                        MainClassAfterUi.logedinId=Integer.valueOf(jsonData.NewreadSocket());
                        System.out.println(MainClassAfterUi.logedinId);
						navigate(MainClassAfterUi.admin);
					}
					else if (Msg.equals("<html>true2</html>"))
					{
                        MainClassAfterUi.logedinId=Integer.valueOf(jsonData.NewreadSocket());
                        j = new jsonData(20, null ,null, null, null, null, 0, 0, null, null, null, 0, 0, MainClassAfterUi.logedinId, false);
                        jsonData.writeSocketMyJson(j);
                        MainClassAfterUi.user=new User();
                        MainClassAfterUi.user.upcoming.setText(jsonData.readSocket());
						navigate(MainClassAfterUi.user);
					}
                    else {jsonData.readSocket();}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
        setVisible(true);
		
	}

}
