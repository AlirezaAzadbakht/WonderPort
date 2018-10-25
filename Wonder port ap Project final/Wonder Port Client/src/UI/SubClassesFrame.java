package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SubClassesFrame extends MyFrame {

	public void SubClassesFrameMaker(String url){
		
		JPanel northPanel = new JPanel();
		add(northPanel,BorderLayout.NORTH);
		ImageIcon moreReportIcon = new ImageIcon(url);
		JLabel MoreReportTitle = new JLabel(moreReportIcon);
		northPanel.add(MoreReportTitle);
		northPanel.setBackground(Color.white);
			
			JPanel south = new JPanel();
			south.setBackground(Color.white);
			add(south,BorderLayout.SOUTH);
			south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));

			
			JButton exit = new JButton();
			ImageIcon exitIcon = new ImageIcon("exit.png");
			exit.setIcon(exitIcon);
			south.add(exit);
			south.setAlignmentY(LEFT_ALIGNMENT);
			exit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
			});
			
			JLabel space = new JLabel();
			space.setMaximumSize(new Dimension(90, 90));
			south.add(space);
		
			
			JButton back = new JButton(" B A C K ");
			back.setMaximumSize(new Dimension(180, 80));
			back.setBackground(Color.BLACK);
			back.setForeground(Color.white);
			back.setOpaque(true);
			back.setBorderPainted(false);
			south.add(back);
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
	public void SubClassesLabelMaker(String url){
        //JLabel report = new JLabel("", SwingConstants.CENTER);
        JLabel report = new JLabel(url, SwingConstants.CENTER);
		report.setMaximumSize(new Dimension(400, 550));
		add(report);
	}
}
