package server;

import java.io.*;
import java.net.*;
import java.util.*;

import com.google.gson.Gson;

import mainPack.*;

public class ServerThread extends Thread{

	Socket socket;
	BufferedReader reader;
	PrintWriter writer;
	
	
	static Scanner input=new Scanner(System.in);
	static boolean admin=false;
	static int logedinID=0;
	
	
	public ServerThread(Socket s) throws IOException {
		// TODO Auto-generated constructor stub
		this.socket = s;
		reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		writer = new PrintWriter(this.socket.getOutputStream());	
		Server.socketList.add(this.socket);
		
		
	}
	public void run()
	{
		
	
		System.out.println("Thread Started!");
		try {
			
			while(true)
			{
				String requestJson = reader.readLine();
				Gson gson=new Gson();
				jsonData requestJsonData= gson.fromJson(requestJson ,jsonData.class);
				
				
				int request=requestJsonData.request;
				String username=requestJsonData.username;
				String password=requestJsonData.password;
				String name = requestJsonData.name;
				String pilot=requestJsonData.pilot;
				String copilot=requestJsonData.copilot;
				int originID=requestJsonData.originID;
				int destinationID = requestJsonData.destinationID;
				String date=requestJsonData.date;
				String startTime=requestJsonData.startTime;
				String landingTime=requestJsonData.landingTime;
				int passengers=requestJsonData.passengers;
				int planeID=requestJsonData.planeID;
				int id=requestJsonData.id;
				boolean admin=requestJsonData.admin;
				
				
				
				
				//////////////////////////////////////////////
				switch (request)
				{
				case 1:
					writeSocket(userObject.NewcheckAvailableUserRID(SecondMainControler.users, username, password));
					writeSocket(String.valueOf(userObject.returnID(SecondMainControler.users, username, password)));
					break;
				case 2:
					System.out.println("planes requested!");
					writeSocket(airplaneObject.showAvailablePlanes(SecondMainControler.planes));
					break;
				case 3:
					System.out.println("ports requested!");
					System.out.println(airportObject.showAvailablePort(SecondMainControler.ports));
					writeSocket(airportObject.showAvailablePort(SecondMainControler.ports));
					break;
				case 4:
					System.out.println("flights requested!");
					System.out.println(flightData.showAvailableflights(SecondMainControler.ports, SecondMainControler.planes, SecondMainControler.flights));
					writeSocket(flightData.showAvailableflights(SecondMainControler.ports, SecondMainControler.planes, SecondMainControler.flights));
					break;
				case 5:
					System.out.println("users requested!");
					writeSocket(userObject.showAvailableUsers(SecondMainControler.users));
					break;
				case 6:
					System.out.println("plane added!");
					SecondMainControler.planes.add(new airplaneObject(name,pilot,copilot,false));
					break;
				case 7:
					System.out.println("plane edited!");
					airplaneObject.findmatchIDplane(SecondMainControler.planes, id).editME(name ,pilot ,copilot);	
					break;
				case 8:
					System.out.println("plane removed!");
					airplaneObject.findmatchIDplane(SecondMainControler.planes,id).removeME(SecondMainControler.planes);
					break;
				case 9:
					System.out.println("port added!");
					SecondMainControler.ports.add(new airportObject(name, false));
					break;
				case 10:
					System.out.println("port edited!");
					airportObject.findmatchIDport(SecondMainControler.ports, id).editME(name);
					break;
				case 11:
					System.out.println("port removed!");
					airportObject.findmatchIDport(SecondMainControler.ports,id).removeME(SecondMainControler.ports);
					break;
				case 12:
					System.out.println("flight added!");
					SecondMainControler.flights.add(new flightData(SecondMainControler.ports, SecondMainControler.planes,SecondMainControler.flights, originID, destinationID, date, startTime, landingTime, passengers, planeID,admin, false));
					break;
				case 13:
					System.out.println("flight passenger added!");
					flightData.findmatchIDFlight(SecondMainControler.ports, SecondMainControler.planes, SecondMainControler.flights, id).addPassengers(name);
					break;
				case 14:
					System.out.println("flight passenger removed!");
					flightData.findmatchIDFlight(SecondMainControler.ports, SecondMainControler.planes, SecondMainControler.flights, id).removePassengers(name);
					break;
				case 15:
					System.out.println("flight removed!");
					flightData.findmatchIDFlight(SecondMainControler.ports, SecondMainControler.planes, SecondMainControler.flights,id).removeME(SecondMainControler.flights);
					break;
				case 16:
					System.out.println("flight edited!");
					flightData.findmatchIDFlight(SecondMainControler.ports, SecondMainControler.planes, SecondMainControler.flights, id).editME(SecondMainControler.ports, SecondMainControler.planes, SecondMainControler.flights, originID, destinationID, date, startTime, landingTime, passengers, planeID,admin);		
					break;
				case 18:
					System.out.println("password changed!");
					userObject.findmatchIDuser(SecondMainControler.users, id).changePassword(password);
					break;
				case 19:
					System.out.println("user removed!");
					userObject.findmatchIDuser(SecondMainControler.users, id).removeMe(SecondMainControler.users);
					break;
				case 20:
					System.out.println("upcoming event requested");
					writeSocket(userObject.findmatchIDuser(SecondMainControler.users, id).showMyEvent(SecondMainControler.ports, SecondMainControler.planes, SecondMainControler.flights));
					break;
				case 21:
					System.out.println("Flight's Passengers requested");
					writeSocket(flightData.findmatchIDFlight(SecondMainControler.ports, SecondMainControler.planes, SecondMainControler.flights, id).showPassengers());
					break;
				}
				if (request==17)
				{
					switch (id) {
					case 4:
						System.out.println("normal user added!");
						SecondMainControler.users.add(new PassengersUserObject(username, password, false, false));
						break;
					case 1:
						System.out.println("pilot added!");
						SecondMainControler.users.add(new pilotUsersObject(username, password, false, false));
						break;
					case 2:
						System.out.println("co pilot added!");
						SecondMainControler.users.add(new coPilotUserObject(username, password, false, false));
						break;
					case 3:
						System.out.println("admin added!");
						SecondMainControler.users.add(new AdminUserObject(username, password, true, false));
						break;
					
					}
				}
				System.out.println("data backuped!");
				SecondMainControler.backup(SecondMainControler.planes, SecondMainControler.users, SecondMainControler.flights, SecondMainControler.ports);
				
				////////////////////////////////////
			}	
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void writeSocket(String sendMsg) throws IOException 
	{
		Socket sendTo = this.socket;
		writer = new PrintWriter(sendTo.getOutputStream(), true);
		/// send to client
		sendMsg=sendMsg.replaceAll("\n", "&");
		sendMsg=sendMsg.replaceAll("\t", "%");
		System.out.println("**********sent to client!*********");
		System.out.println(sendMsg);
		System.out.println("**********************************");
		writer.println(sendMsg);
	}
	
	
}
