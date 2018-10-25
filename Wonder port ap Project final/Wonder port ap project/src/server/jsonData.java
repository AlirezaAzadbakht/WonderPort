package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

public class jsonData {
	int request;
	String username=null;
	String password=null;
	String name = null;
	String pilot=null;
	String copilot=null;
	int originID=0;
	int destinationID = 0;
	String date=null;
	String startTime=null;
	String landingTime=null;
	int passengers=0;
	int planeID=0;
	int id=0;
	boolean admin=false;
	
	public jsonData(int request,String username,String password,String name ,String pilot,String copilot ,int originID,int destinationID ,String date ,String startTime,String landingTime,int passengers,int planeID,int id,boolean admin)
	{
		this.request=request;
		this.username=username;
		this.password=password;
		this.name=name;
		this.pilot=pilot;
		this.copilot=copilot;
		this.originID=originID;
		this.destinationID=destinationID;
		this.date=date;
		this.startTime=startTime;
		this.landingTime=landingTime;
		this.passengers=passengers;
		this.planeID=planeID;
		this.id=id;
		this.admin=admin;
	}
	public static String JsonMe (jsonData data)
	{
		//object --> Json 
		Gson gson = new Gson();
		return gson.toJson(data);
	}
	public static void writeSocketMyJson(jsonData data,Socket socket) throws IOException
	{
		//object --> socket
		PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		writer.println(JsonMe (data));
	}
	
	
	

}
