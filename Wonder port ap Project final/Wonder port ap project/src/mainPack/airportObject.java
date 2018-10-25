package mainPack;
import java.io.IOException;
import java.util.*;

import server.ServerThread;

public class airportObject {
	static Scanner input=new Scanner(System.in);
	public static int i=1;
	String name;
	int id;
	
	public airportObject (String name ,boolean addType)
	{
		if (addType==true)
		{
			System.out.println("Enter port name :");
			this.name=input.next();
			this.id=i++;
		}
		else
		{
			this.name=name;
			this.id=i++;
		}
		
	}
	
	
	public String flightsData (ArrayList <airportObject> ports,ArrayList <airplaneObject> planes,ArrayList <flightData> flights)
	{
		String sendMsg=null;
		int i=1;
		for (flightData data : flights)
		{
			if (data.originID==this.id){sendMsg=sendMsg+flightData.printElement(ports, planes, flights, data,i);}
			if(data.destinationID==this.id){sendMsg=sendMsg+flightData.printElement(ports, planes, flights, data,i);}
		}
		return sendMsg;
	}
	
	public void editME (String name)
	{
		this.name=name;
	}
	
	public void removeME(ArrayList <airportObject> ports) throws IOException
	{
		ports.remove(this);
		SecondMainControler.saveObjPorts(ports);
	}
	
	public static String showAvailablePort(ArrayList <airportObject> ports) 
	{
		//System.out.println("\n -Ports :");
		int i=1;
		String sendMsg ="";
		for (airportObject data : ports) 
		{
			
			sendMsg=sendMsg+String.valueOf(i++)+".\t id:"+String.valueOf(data.id)+"\t name:"+data.name+"\n";
		
		}
		
		return sendMsg;
	}
	
	public static airportObject findmatchIDport(ArrayList <airportObject> ports ,int id)//id 0 yani beporse 
	{
		if (id==0)
		{
			showAvailablePort(ports);
			System.out.println("target ID ? :");
			id =input.nextInt();
		}
		
		for (airportObject data : ports) 
		{
			if(id==data.id)
				return(data);
		}
		return null;
	}
	
}
