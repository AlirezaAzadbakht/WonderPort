package mainPack;
import java.io.IOException;
import java.util.*;

public class airplaneObject  {
	static Scanner input=new Scanner(System.in);
	public static int i=1;
	String name;
	int id;
	String pilot;
	String copilot;	
	int passengers;
	
	public airplaneObject(String name ,String Pilot ,String copilot,boolean addType)//true 0 false else
	{
		if(addType==true)
		{
			System.out.println("enter air plane name :");
			this.name=input.next();
			this.id=i++;
			System.out.println("pilot name?");
			this.pilot=input.next();
			System.out.println("co pilot name ? ");
			this.copilot=input.next();
		}
		else
		{
			
			this.name=name;
			this.id=i++;
			this.pilot=Pilot;
			this.copilot=copilot;
		}
		
	}
	
	
	public String flightsData (ArrayList <airportObject> ports,ArrayList <airplaneObject> planes,ArrayList <flightData> flights)
	{
		String sendMsg=null;
		int i=1;
		for (flightData data : flights)
		{
			if (data.planeID==this.id){ sendMsg=sendMsg+flightData.printElement(ports, planes, flights, data,i);}
		}
		return sendMsg;
	}
	
	public void editME (String name ,String pilot ,String copilot)
	{
		this.name=name;
		this.pilot=pilot;
		this.copilot=copilot;
	}
	
	public void removeME(ArrayList <airplaneObject> planes) throws IOException
	{
		planes.remove(this);
		SecondMainControler.saveObjPlane(planes);
	}
	
	public static String showAvailablePlanes(ArrayList <airplaneObject> planes) 
	{
		int i=1;
		String sendMsg=null;
		for (airplaneObject data : planes) 
		{
			sendMsg=sendMsg+String.valueOf(i++);
			sendMsg=sendMsg+"\t id:"+String.valueOf(data.id);
			sendMsg=sendMsg +"\t name:"+data.name;
			sendMsg=sendMsg+"\t pilot:"+data.pilot;
			sendMsg=sendMsg+"\t co-pilot:"+data.copilot;
			sendMsg=sendMsg+"\n";
		}
		return sendMsg;
	}
	
	public static airplaneObject findmatchIDplane(ArrayList <airplaneObject> planes,int id)//id 0 yani beporse
	{
		if (id==0)
		{
			showAvailablePlanes(planes);
			System.out.println("target ID ? :");
			id =input.nextInt();
		}
		for (airplaneObject data : planes) 
		{
			if(id==data.id)
				return(data);
		}
		return null;
	}
}
