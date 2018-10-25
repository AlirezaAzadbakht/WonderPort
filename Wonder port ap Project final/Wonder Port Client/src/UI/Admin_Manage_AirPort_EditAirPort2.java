package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Admin_Manage_AirPort_EditAirPort2 extends SubClassesSmallFrame{
	int selectedId;
	public Admin_Manage_AirPort_EditAirPort2() {

		
		ImageIcon footer0 = new ImageIcon("SmallEditAHeader.png");
		JLabel footerImage0 = new JLabel(footer0);
		footerImage0.setBounds(0, 0, 400, 30);
		add(footerImage0);
		
	
		final JTextField AirPort = new JTextField("        AirPort Name   ");
		AirPort.setBounds(100, 200, 170, 50);
		add(AirPort);
		
		
		JButton confirm = new JButton(" C O N F I R M ");
		confirm.setBounds(200, 350, 130, 40);
		add(confirm);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jsonData j;
                j = new jsonData(10, null, null, AirPort.getText(), null, null, 0, 0, null, null, null, 0, 0, selectedId, false);
                try {
					jsonData.writeSocketMyJson(j);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				navigate(MainClassAfterUi.airPortsM);
				
			}
		});
 
		
		JButton close = new JButton(" C L O S E ");
		close.setBounds(50, 350, 130, 40);
		add(close);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navigate(MainClassAfterUi.airPortsM);
				
			}
		});
		
		JLabel info = new JLabel("Enter  \" AirPort Name\" and \"CONFIRM\"  ");
		info.setBounds(80, 400, 400, 30);
		add(info);
	}
}
