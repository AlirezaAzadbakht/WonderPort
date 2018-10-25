package UI;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClassAfterUi extends MyFrame {
    static int logedinId;
	
	static Login login = new Login();
	static Admin admin = new Admin();
	static Admin_Report_AirPlanes airPlanesR = new Admin_Report_AirPlanes();
	static Admin_Report_AirPorts airPortsR = new Admin_Report_AirPorts();
	static Admin_Report_Flights flightsR = new Admin_Report_Flights();
	static Admin_Report_Users usersR = new Admin_Report_Users();
	static Admin_Manage_Flights flightsM = new Admin_Manage_Flights();
	static Admin_Manage_AirPlanes airPlanesM = new Admin_Manage_AirPlanes();
	static Admin_Manage_AirPorts airPortsM = new Admin_Manage_AirPorts();
	static Admin_Manage_Users usersM = new Admin_Manage_Users();
	static Admin_ChangePassword changePassword = new Admin_ChangePassword();
	static User user = new User();
	static User_Rerport userReport = new User_Rerport();
	static Admin_Manage_Flights_AddFlights addFlights = new Admin_Manage_Flights_AddFlights();
	static Admin_Manage_Flights_RemoveFlights removeFlights = new Admin_Manage_Flights_RemoveFlights();
	static Admin_Manage_Flights_EditFlight1 editFlight1 = new Admin_Manage_Flights_EditFlight1();
	static Admin_Manage_Flights_EditFlight2 editFlight2 = new Admin_Manage_Flights_EditFlight2();		
	static Admin_Manage_Flights_AddPassenger1 addPassenger1 = new Admin_Manage_Flights_AddPassenger1();
	static Admin_Manage_Flights_AddPassenger2 addPassenger2 = new Admin_Manage_Flights_AddPassenger2();
	static Admin_Manage_Flights_RemovePassenger1 removePassenger1 = new Admin_Manage_Flights_RemovePassenger1();
	static Admin_Manage_Flights_RemovePassenger2 removePassenger2 = new Admin_Manage_Flights_RemovePassenger2();
	static Admin_Manage_AirPort_AddAirPort addAirPort = new Admin_Manage_AirPort_AddAirPort();
	static Admin_Manage_AirPort_RemoveAirPort removeAirPort = new Admin_Manage_AirPort_RemoveAirPort();
	static Admin_Manage_AirPort_EditAirPort1 editAirPort1 = new Admin_Manage_AirPort_EditAirPort1();
	static Admin_Manage_AirPort_EditAirPort2 editAirPort2 = new Admin_Manage_AirPort_EditAirPort2();
	static Admin_Manage_AirPlane_AddAirPlane addAirPlane = new Admin_Manage_AirPlane_AddAirPlane();
	static Admin_Manage_AirPlane_RemoveAirPlane removeAirPlane = new Admin_Manage_AirPlane_RemoveAirPlane();
	static Admin_Manage_AirPlane_EditAirPlane1 editAirPlane1 = new Admin_Manage_AirPlane_EditAirPlane1();
	static Admin_Manage_AirPlane_EditAirPlane2 editAirPlane2 = new Admin_Manage_AirPlane_EditAirPlane2();
	static Admin_Manage_Users_UserPassSetterForAll userPassSetterForAll = new Admin_Manage_Users_UserPassSetterForAll();
    static Admin_Manage_Users_RemoveUsers removeUsers = new Admin_Manage_Users_RemoveUsers();
    static Admin_Manage_Flights_ShowPassengers1 showPass1=new Admin_Manage_Flights_ShowPassengers1();
    static Admin_Manage_Flights_ShowPassengers2 showPass2=new Admin_Manage_Flights_ShowPassengers2();


	static Socket socket;
	 
	public static void main(String[] args) throws UnknownHostException, IOException {
		 socket = new Socket("localhost", 2997);
	}

}
