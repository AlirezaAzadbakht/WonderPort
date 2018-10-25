package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Admin_Manage_Flights_EditFlight2 extends SubClassesSmallFrame {
	JComboBox<String> planeList;
	JComboBox<String> originList;
	JComboBox<String> destinationList;
	static int selectedID;
	public Admin_Manage_Flights_EditFlight2() {
		ImageIcon footer0 = new ImageIcon("SmallEditHeader.png");
		JLabel footerImage0 = new JLabel(footer0);
		footerImage0.setBounds(0, 0, 400, 30);
		add(footerImage0);
		
		JLabel origin = new JLabel(" Origin : " );
		origin.setBounds(5, 30, 150, 40);
		add(origin);
		
		//String [] check = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" , "b" , "c" };
		originList = new JComboBox<String>();
		originList.setBounds(155, 25, 200, 50);
		add(originList);
		
		
		
		JLabel destination = new JLabel(" Destination : ");
		destination.setBounds(5, 70, 150, 40);
		add(destination);
		
		
		
		//String [] check1 = {"eeeeeeeeeeeeeeeeeeeeeeee" , "f" , "g" };
		destinationList = new JComboBox<String>();
		destinationList.setBounds(155, 65, 200, 50);
		add(destinationList);
		
		JLabel line = new JLabel("        ------------------------------------- ");
		line.setBounds(5, 115, 400, 5);
		add(line);
		
		
		JLabel planes = new JLabel(" AirPlane : ");
		planes.setBounds(5, 120, 150, 40);
		add(planes);
		
		
		
		//String [] check2 = {"hhhhhhhhhhhhhhhhhhhhhhhhh" , "i" , "j" };
		planeList = new JComboBox<String>();
		planeList.setBounds(155, 115, 200, 50);
		add(planeList);
		
		
		JLabel line1 = new JLabel("        ------------------------------------- ");
		line1.setBounds(5, 160, 400, 5);
		add(line1);
		

		JLabel Date = new JLabel(" Date :  ");
		Date.setBounds(5, 183, 100, 10);
		add(Date);
		
		String [] year = {"2020","2019","2018","2017","2016","2015","2014","2013","2012","2011"};
		final JComboBox<String> DateStrYear = new JComboBox<String>(year);
		DateStrYear.setBounds(110, 180, 90, 23);
		add(DateStrYear);
		
		String [] month = {"12","11","10","9","8","7","6","5","4","3","2","1"};
		final JComboBox<String> DateStrMonth = new JComboBox<String>(month);
		DateStrMonth.setBounds(210, 180, 70, 23);
		add(DateStrMonth);
		
		String [] day = {"31","30","20","28","27","26","25","24","23","22","21","20","19","18","17","16","15","14","13","12","11","10","9","8","7","6","5","4","3","2","1"};
		final JComboBox<String> DateStrDay = new JComboBox<String>(day);
		DateStrDay.setBounds(290, 180, 70, 23);
		add(DateStrDay);		
		

		JLabel time = new JLabel(" TakeOff Time :  ");
		time.setBounds(5, 225, 150, 10);
		add(time);
		
		
				
		String [] hour = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
		final JComboBox<String> timeStrHour = new JComboBox<String>(hour);
		timeStrHour.setBounds(170, 220, 70, 23);
		add(timeStrHour);
		
		String [] minute = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"};
		final JComboBox<String> timeStrMinute = new JComboBox<String>(minute);
		timeStrMinute.setBounds(260, 220, 70, 23);
		add(timeStrMinute);
		
		
		JLabel time2 = new JLabel(" Landing Time :  ");
		time2.setBounds(5, 255, 150, 10);
		add(time2);
		
		
				
		String [] hour2 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
		final JComboBox<String> timeStrHour2 = new JComboBox<String>(hour2);
		timeStrHour2.setBounds(170, 250, 70, 23);
		add(timeStrHour2);
		
		String [] minute2 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"};
		final JComboBox<String> timeStrMinute2 = new JComboBox<String>(minute2);
		timeStrMinute2.setBounds(260, 250, 70, 23);
		add(timeStrMinute2);
		
		JLabel line2 = new JLabel("        -------------------------------------      ");
		line2.setBounds(5, 280, 400, 10);
		add(line2);
		
		JLabel passengerNum = new JLabel(" Passengers Number : ");
		passengerNum.setBounds(5, 300, 150, 15);
		add(passengerNum);
		
		final JTextField numbers = new JTextField("Enter Num");
		numbers.setBounds(180, 297, 100, 25);
		add(numbers);
		
		JLabel line3 = new JLabel("        -------------------------------------      ");
		line3.setBounds(5, 330, 400, 10);
		add(line3);
		
		final JRadioButton transportationFlight = new JRadioButton("Transportation");
		transportationFlight.setSelected(true);
		transportationFlight.setBounds(5, 340, 200, 20);
		add(transportationFlight);
		
		
		JRadioButton militaryFlight= new JRadioButton("Military");
		militaryFlight.setBounds(220, 340, 200, 20);
		add(militaryFlight);
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(militaryFlight);
		bgroup.add(transportationFlight);
		
		
		JButton confirm = new JButton(" C O N F I R M ");
		confirm.setBounds(100, 375, 140, 40);
		confirm.setBackground(Color.BLACK);
		confirm.setForeground(Color.white);
		confirm.setOpaque(true);
		confirm.setBorderPainted(false);
		add(confirm);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					//////////////////////////////////////////////////////////////////////////////////////
					int originID = Admin_Manage_Flights_AddFlights.findId((String) originList.getSelectedItem());
					int destinationID = Admin_Manage_Flights_AddFlights.findId((String) destinationList.getSelectedItem());
					String date = (String)DateStrDay.getSelectedItem()+"/"+(String)DateStrMonth.getSelectedItem()+"/"+(String)DateStrYear.getSelectedItem();
					String startTime = (String)timeStrHour.getSelectedItem()+":"+(String)timeStrMinute.getSelectedItem();
					String landingTime = (String)timeStrHour2.getSelectedItem()+":"+(String)timeStrMinute2.getSelectedItem();
					int passengers = Integer.valueOf(numbers.getText());
					int planeID = Admin_Manage_Flights_AddFlights.findId((String) planeList.getSelectedItem());

					//flight type ba argoman admin ferestadam
					boolean admin;
					if (transportationFlight.isSelected())
						{
							admin =true;
						}
					else
					{
						admin =false;
					}


					//////////////////////////////////////////////////////////////////////////////////////
					jsonData j =new jsonData(16, null,  null, null, null, null, originID, destinationID, date, startTime, landingTime, passengers, planeID, selectedID, admin);
					try {
						jsonData.writeSocketMyJson(j);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
					navigate(MainClassAfterUi.flightsM);
				
			}
		});
		
	}
}
