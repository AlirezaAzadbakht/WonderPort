package mainPack;
import java.io.IOException;
import java.util.*;

public class flightData {
	static Scanner input=new Scanner(System.in);
	public static int i=1;
	int id;
	int originID;
	int destinationID;
	int planeID;
	String date;
	String startTime;
	String landingTime;
	int Passengers;
	boolean flightType;// mosaferbari true   nezami false
	ArrayList <String> passengersData=new ArrayList<String>();
	

	public flightData (ArrayList <airportObject> ports,ArrayList <airplaneObject> planes,ArrayList <flightData> flights,int originID ,int destinationID , String date,  String startTime ,String  landingTime ,int passengers , int planeID,boolean addType)
	{
		if (checkConflict(originID, destinationID, flights, date, startTime, landingTime))
		{
			this.id=i++;
			this.originID=originID;
			this.destinationID=destinationID;
			this.planeID=planeID;
			this.date=date;
			this.startTime=startTime;
			this.landingTime=landingTime;
			this.Passengers=passengers;
		}
	}
	
	public void editME (ArrayList <airportObject> ports,ArrayList <airplaneObject> planes,ArrayList <flightData> flights,int originID ,int destinationID , String date,  String startTime ,String  landingTime ,int passengers , int planeID)
	{
		if (checkConflict(originID, destinationID, flights, date, startTime, landingTime))
		{
			this.originID=originID;
			this.destinationID=destinationID;
			this.planeID=planeID;
			this.date=date;
			this.startTime=startTime;
			this.landingTime=landingTime;
			this.Passengers=passengers;
		}
	}
	
	public void removeME(ArrayList <flightData> flights) throws IOException
	{
		flights.remove(this);
		SecondMainControler.saveObjFlight(flights);
	}
	
	public void addPassengers (String name)
	{
		this.passengersData.add(name);
	}
	
	public void removePassengers (String name)
	{
		this.passengersData.remove(name);	
	}
	
	public String showPassengers ()
	{
		String sendMsg=null;
		int i=1;
		for (String data : this.passengersData)
		{
			sendMsg=sendMsg+String.valueOf(i++) +".\t"+data+"\n";
		}
		return sendMsg;
	}
	
	
	public static String showAvailableflights(ArrayList <airportObject> ports,ArrayList <airplaneObject> planes,ArrayList <flightData> flights) 
	{
		String sendMsg=null;
		int i=1;
		for (flightData data : flights) 
		{
			sendMsg=sendMsg+printElement(ports, planes, flights, data,i);
			sendMsg=sendMsg+"\n";
		}
		return sendMsg;
	}
	
	public static flightData findmatchIDFlight(ArrayList <airportObject> ports,ArrayList <airplaneObject> planes,ArrayList <flightData> flights,int id)//id 0 yani beporse
	{
		if (id==0)
		{
			showAvailableflights(ports, planes, flights);
			System.out.println("target ID ? :");
			id =input.nextInt();
		}
		for (flightData data : flights) 
		{
			if(id==data.id)
				return(data);
		}
		return null;
	}
	
	public static String printElement(ArrayList <airportObject> ports,ArrayList <airplaneObject> planes,ArrayList <flightData> flights,flightData data, int i)
	{
		String sendMsg=null;
		sendMsg=sendMsg+String.valueOf(i++);
		sendMsg=sendMsg+".\t id:"+String.valueOf(data.id);
		sendMsg=sendMsg+"\t plane:" +airplaneObject.findmatchIDplane(planes, data.planeID).name;
		sendMsg=sendMsg+"\t Origin:"+airportObject.findmatchIDport(ports, data.originID).name+" -->  Destination:"+airportObject.findmatchIDport(ports, data.destinationID).name;
		sendMsg=sendMsg+" flight type : ";
		if (data.flightType==true){sendMsg=sendMsg+"normal";}else{sendMsg=sendMsg+"military";}
		sendMsg=sendMsg+"\t Date:"+data.date+"  takeoff:"+data.startTime+"  landing:"+data.landingTime +"\t Passengers : "+String.valueOf(data.Passengers)+"\n";
		return sendMsg;
	}
	
	
	public static boolean checkConflict(int originID,int destinationID,ArrayList<flightData> flights ,String date , String startTime,String landingTime )
	{
		if (originID==destinationID){return false;}
		
		for (flightData data : flights)
		{
			if(data.originID==originID && data.startTime.equals(startTime) && data.date.equals(date))
			{
				return false;
			}
			if (data.destinationID==destinationID && data.landingTime.equals(landingTime) && data.date.equals(date))
			{
				return false;
			}
		}
		return true;
	}
	
}
