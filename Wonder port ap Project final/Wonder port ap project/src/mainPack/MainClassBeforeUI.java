package mainPack;
import java.util.*;

//import javax.swing.SwingConstants;


public class MainClassBeforeUI {
	
	
	
	public static void main(String[] args) {
		
		
		
		userObject.StartUsernames(ports, planes, flights, users);
		int menu =-2 ;
		
		while (true)
		{
////////////////////////////////////////////////	BODY	///////////////////////////////////////////////////////////////////////////////////////////////////
//			1.show planes
//			2.show ports
//			3.show flights
//			4.show a plane's flights			
//			5.show a port's flights
//			
//			6.add plane
//			7.add port
//			8.add flight
//			9.remove plane
//			10.remove port
//			11.remove flight
//			12.edit plane
//			13.edit port
//			14.edit flight
//			15.add attendant
//			16.remove attendant
//			17.show plane attendant
//			
//			18.show users
//			19.add users
//			20.remove users
//			21.edit users
//			
//			
//			0.change password
//			-1.log out
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			
			menu=showMenu(admin,menu);
			
			switch (menu)
			{
			case 1:
				airplaneObject.showAvailablePlanes(planes);
				break;
			case 2:
				airportObject.showAvailablePort(ports);
				break;
			case 3:
				flightData.showAvailableflights(ports, planes, flights);
				break;
			case 4:
				airplaneObject.findmatchIDplane(planes, 0).flightsData(ports, planes, flights);
				break;
			case 5:
				airportObject.findmatchIDport(ports, 0).flightsData(ports, planes, flights);
				break;
			case -1:
				userObject.StartUsernames(ports, planes, flights, users);
				break;
			case 0:
				userObject.findmatchIDuser(users, logedinID).changePassword();
				
			}
			if(admin==true)// admin section
			{
				switch (menu)
				{
				case 6:
					planes.add(new airplaneObject(null, null, null, true));
					break;
				case 7:
					ports.add(new airportObject(null, true));
					break;
				case 8:
					flights.add(new flightData(ports, planes, flights, 0, 0, null, null, null, 0, 0, true));
					break;
				case 9:
					airplaneObject.findmatchIDplane(planes,0).removeME(planes);
					break;
				case 10:
					airportObject.findmatchIDport(ports,0).removeME(ports);
					break;
				case 11:
					flightData.findmatchIDFlight(ports, planes, flights,0).removeME(flights);
					break;
				case 12:
					airplaneObject.findmatchIDplane(planes, 0).editME();	
					break;
				case 13:
					airportObject.findmatchIDport(ports, 0).editME();
					break;
				case 14:
					flightData.findmatchIDFlight(ports, planes, flights, 0).editME(ports, planes, flights);		
					break;
				case 15:
					airplaneObject.findmatchIDplane(planes, 0).addAttendant();
					break;
				case 16:
					airplaneObject.findmatchIDplane(planes, 0).removeAttendant();
					break;
				case 17:
					airplaneObject.findmatchIDplane(planes, 0).showAttendant();
					break;
				case 18:
					userObject.showAvailableUsers(users);
					break;
				case 19:
					users.add(new userObject(null, null, false, true));
					break;
				case 20:
					users.add(new pilotUsersObject(null, null, false, true));
					break;
				case 21:
					users.add(new coPilotUserObject(null, null, false, true));
					break;
				case 22:
					users.add(new AttendantUsersObject(null, null, false, true));
				case 23:
					users.add(new AdminUserObject(null, null, true, true));
					break;
				case 24:
					userObject.findmatchIDuser(users, 0).removeMe(users);
					break;
				case 25:
					userObject.findmatchIDuser(users, 0).editMe();
					break;
				case 26:
					flightData.findmatchIDFlight(ports, planes, flights, 0).addPassengers();
					break;
				case 27:
					flightData.findmatchIDFlight(ports, planes, flights, 0).removePassengers();
					break;
				case 28:
					flightData.findmatchIDFlight(ports, planes, flights, 0).showPassengers();
					break;
				}
			}
				
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		}


	}
	
	public static int showMenu(boolean admin, int menu) 
	{
		if (menu!=-2)
		{
			System.out.println("\n____________________________________");
			System.out.println("**1.open menu**");
			menu=input.nextInt();
			if (menu!=1){return -2;}
			
		}
		
		
		System.out.println("____________________\n");
		System.out.println("1.Reports");
		if (admin==true)
		{
			System.out.println("2.Flights Management");
			System.out.println("3.Ports Management");
			System.out.println("4.Airplanes Management");
			System.out.println("5.Users Management");	
		}
		System.out.println("0.change password");
		System.out.println("-1.log out");
		
		int temp =input.nextInt();
		boolean getnext =true;
		switch (temp) 
		{
		case 1:
			
			System.out.println("\t1.show planes");
			System.out.println("\t2.show ports");
			System.out.println("\t3.show flights");
			System.out.println("\t4.show a plane's flights");
			System.out.println("\t5.show a port's flights");
			if (admin==true)
			{
				System.out.println("\t6.show a flight's passengers");
				System.out.println("\t7.show a plane's attendants");
				System.out.println("\t8.show Users");
			}
				
			System.out.println("\t0.back");
		
			do
			{
				getnext=true;
				int temp1 =input.nextInt();
				switch (temp1) 
				{
				case 0:
					return -2; 
				case 1:
					return 1;
				case 2:
					return 2;
				case 3:
					return 3;
				case 4:
					return 4;
				case 5:
					return 5;
				case 6:
					if (admin==false){getnext=false;break;}
					return 28;
				case 7:
					if (admin==false){getnext=false;break;}
					return 17;
				case 8:
					if (admin==false){getnext=false;break;}
					return 18;
				default:
					getnext=false;
					break;
				}
				
			}while(getnext=false);
				
			break;
		case 2:
			if (admin==false){return -2;}
			System.out.println("\t1.add flight");
			System.out.println("\t2.remove flight");
			System.out.println("\t3.edit flights");
			System.out.println("\t4.add passengers");
			System.out.println("\t5.remove passengers");
			System.out.println("\t0.back");
		
			do
			{
				getnext=true;
				int temp1 =input.nextInt();
				switch (temp1) 
				{
				case 0:
					return -2; 
				case 1:
					return 8;
				case 2:
					return 11;
				case 3:
					return 14;
				case 4:
					return 26;////////////////////////
				case 5:
					return 27;////////////////////////////
				default:
					getnext=false;
					break;
				}
				
			}while(getnext=false);
			break;
		case 3:
			if (admin==false){return -2;}
			System.out.println("\t1.add airplane");
			System.out.println("\t2.remove airplane");
			System.out.println("\t3.edit airplane");
			System.out.println("\t4.add attandents");
			System.out.println("\t5.remove attandets");
			System.out.println("\t0.back");
		
			do
			{
				getnext=true;
				int temp1 =input.nextInt();
				switch (temp1) 
				{
				case 0:
					return -2; 
				case 1:
					return 6;
				case 2:
					return 9;
				case 3:
					return 12;
				case 4:
					return 15;
				case 5:
					return 16;
				default:
					getnext=false;
					break;
				}
				
			}while(getnext=false);
			break;
		case 4:
			if (admin==false){return -2;}
			System.out.println("\t1.add port");
			System.out.println("\t2.remove port");
			System.out.println("\t3.edit port");
			System.out.println("\t0.back");
		
			do
			{
				getnext=true;
				int temp1 =input.nextInt();
				switch (temp1) 
				{
				case 0:
					return -2; 
				case 1:
					return 7;
				case 2:
					return 10;
				case 3:
					return 13;
				default:
					getnext=false;
					break;
				}
				
			}while(getnext=false);
			break;
		case 5:
			if (admin==false){return -2;}
			System.out.println("\t1.add passenger user");
			System.out.println("\t2.add pilot user");
			System.out.println("\t3.add coPilot user");
			System.out.println("\t4.add attendant user");
			System.out.println("\t5.add admin user");
			System.out.println("\t6.remove user");
			System.out.println("\t7.edit user");
			System.out.println("\t0.back");
		
			do
			{
				getnext=true;
				int temp1 =input.nextInt();
				switch (temp1) 
				{
				case 0:
					return -2; 
				case 1:
					return 19;
				case 2:
					return 20;
				case 3:
					return 21;
				case 4:
					return 22;
				case 5:
					return 23;
				case 6:
					return 24;
				case 7:
					return 25;
				default:
					getnext=false;
					break;
				}
				
			}while(getnext=false);
			break;
			
		case 0:
			return 0;
		case -1:
			return -1;
		default:
			break;
		}
		return -2;
		
		
		
		
		
	}
	
	

	
	
	
		


	
	
}

