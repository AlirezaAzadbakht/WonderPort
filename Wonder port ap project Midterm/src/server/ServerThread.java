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
	ArrayList <airplaneObject> planes = new ArrayList <airplaneObject>();
	ArrayList <airportObject> ports = new ArrayList <airportObject>();
	ArrayList <flightData> flights = new ArrayList <flightData>();
	ArrayList <userObject> users = new ArrayList <userObject>();
	
	static Scanner input=new Scanner(System.in);
	static boolean admin=false;
	static int logedinID=0;
	
	
	public ServerThread(Socket s) throws IOException {
		// TODO Auto-generated constructor stub
		this.socket = s;
		
		reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		writer = new PrintWriter(this.socket.getOutputStream());
		
		//String userName = reader.readLine();
		System.out.println("Client Registered");
		
		
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
					writeSocket(airplaneObject.showAvailablePlanes(planes));
					break;
				case 2:
					writeSocket(airportObject.showAvailablePort(ports));
					break;
				case 3:
					writeSocket(flightData.showAvailableflights(ports, planes, flights));
					break;
				case 4:
					writeSocket(airplaneObject.findmatchIDplane(planes, 0).flightsData(ports, planes, flights));
					break;
				case 5:
					writeSocket(airportObject.findmatchIDport(ports, 0).flightsData(ports, planes, flights));
					break;
				case -1:
					//log out
					break;
				case 0:
					userObject.findmatchIDuser(users, logedinID).changePassword(password);
				case 6:
					planes.add(new airplaneObject(name,pilot,copilot,false));
					break;
				case 7:
					ports.add(new airportObject(name, false));
					break;
				case 8:
					flights.add(new flightData(ports, planes, flights, originID, destinationID, date, startTime, landingTime, passengers, planeID, false));
					break;
				case 9:
					airplaneObject.findmatchIDplane(planes,id).removeME(planes);
					break;
				case 10:
					airportObject.findmatchIDport(ports,id).removeME(ports);
					break;
				case 11:
					flightData.findmatchIDFlight(ports, planes, flights,id).removeME(flights);
					break;
				case 12:
					airplaneObject.findmatchIDplane(planes, 0).editME(name ,pilot ,copilot);	
					break;
				case 13:
					airportObject.findmatchIDport(ports, 0).editME(name);
					break;
				case 14:
					flightData.findmatchIDFlight(ports, planes, flights, 0).editME(ports, planes, flights, originID, destinationID, date, startTime, landingTime, passengers, planeID);		
					break;
				case 18:
					writeSocket(userObject.showAvailableUsers(users));
					break;
				case 19:
					users.add(new userObject(username, password, false, false));
					break;
				case 20:
					users.add(new pilotUsersObject(username, password, false, false));
					break;
				case 21:
					users.add(new coPilotUserObject(username, password, false, false));
					break;
				case 23:
					users.add(new AdminUserObject(username, password, true, false));
					break;
				case 24:
					userObject.findmatchIDuser(users, id).removeMe(users);
					break;
				case 25:
					userObject.findmatchIDuser(users, id).editMe(username,password, admin);
					break;
				case 26:
					flightData.findmatchIDFlight(ports, planes, flights, 0).addPassengers(name);
					break;
				case 27:
					flightData.findmatchIDFlight(ports, planes, flights, 0).removePassengers(name);
					break;
				case 28:
					writeSocket(flightData.findmatchIDFlight(ports, planes, flights, 0).showPassengers());
					break;
				}
			
				////////////////////////////////////
			}	
				
				
				
				
				///proccesc request
				
				/*
				
					if(Server.users.get(i).equals(receiver))
					{
						Socket sendTo = (Socket)Server.socketList.get(i);
						writer = new PrintWriter(sendTo.getOutputStream(), true);
						/// send to client
						writer.println(msg);
						System.out.println("awnser sent");
					}
					*/
				
				
			
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
		writer.println(sendMsg);
	}
}
