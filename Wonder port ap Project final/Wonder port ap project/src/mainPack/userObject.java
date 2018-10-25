package mainPack;
import java.io.IOException;
import java.util.*;

public  class userObject {
	static Scanner input=new Scanner(System.in);
	public static int i=1;
	protected String username;
	private String password;
	private boolean admin;
	int id;
	String job;
	
	public userObject (String username,String password,boolean admin,boolean addType)
	{
		if (addType==true)
		{
			System.out.println("enter username : ");
			username=input.next();
			System.out.println("enter password : ");
			password=input.next();
			//System.out.println("is it an admin ? true/false");
			//admin=input.nextBoolean();
		}
		this.id=i++;
		this.username=username;
		this.password=password;
		this.admin=admin;
	}
	
	public void changePassword ( String password)
	{
		this.password=password;
	}
	public void changeUsername (String username)
	{
		this.username=username;
	}
	public void changeAdminPermission (boolean permission)
	{
		this.admin=permission;
		//System.out.println("is it an admin ? true/false");
		//if (this.id!=MainClassBeforeUI.logedinID){admin=input.nextBoolean();}
		//else {System.out.println("You cant change this one :)");}
	}
	
	public void removeMe(ArrayList<userObject> users) throws IOException
	{
		users.remove(this);
		SecondMainControler.saveObjUsers(users);
		//if(this.id!=MainClassBeforeUI.logedinID){users.remove(this);}
		//else {System.out.println("You cant remove yourself :)");}
	}
	
	
	public void editMe (String username ,String password, boolean permission)
	{
		changeUsername(username);
		changePassword(password);
		changeAdminPermission(permission);	
	}
// in badan bezan baui
	public static boolean StartUsernames ( ArrayList <airportObject> ports,ArrayList <airplaneObject> planes ,ArrayList<flightData> flights,ArrayList <userObject> users,String username,String password)
	{		
		if(userObject.checkAvailableUserRID(users, username, password)==0)
		{
			return false;	
		}
		else 
		{
			return true;
			/*
			MainClassBeforeUI.admin=findmatchIDuser(users, userObject.checkAvailableUserRID(users, username, password)).admin;
			MainClassBeforeUI.logedinID=findmatchIDuser(users, userObject.checkAvailableUserRID(users, username, password)).id;
			if (MainClassBeforeUI.admin==false){System.out.println("your upcoming events: ");}
			userObject.findmatchIDuser(users, MainClassBeforeUI.logedinID).showMyEvent(ports, planes, flights);
			*/
		}
		
		
	}
	
	public  String showMyEvent (ArrayList <airportObject> ports,ArrayList <airplaneObject> planes ,ArrayList<flightData> flights) 
	{
		String msg="your Upcoming event:\n";
		if (this.job.equals("Pilot"))
		{
			for (flightData data : flights) 
			{
				if(airplaneObject.findmatchIDplane(planes, data.planeID).pilot.equals(this.username))
					msg=msg+flightData.printElement(ports, planes, flights, data, 1)+"\n";
			}
		}
		else if ( this.job.equals("coPilot"))
		{
			for (flightData data : flights) 
			{
				if(airplaneObject.findmatchIDplane(planes, data.planeID).copilot.equals(this.username))
					msg=msg+flightData.printElement(ports, planes, flights, data, 1)+"\n";
				
			}
		}
		else if (this.job.equals("passenger"))
		{
			for (flightData data : flights) 
			{
				if(data.passengersData.contains(this.username))
					msg=msg+flightData.printElement(ports, planes, flights, data, 1)+"\n";
				
			}
		}
		else
		{
			msg=msg+"Nothing";
		}
		
		return msg;
	}
	
	public static int checkAvailableUserRID (ArrayList <userObject> users,String username,String password)
	{
		for (userObject data : users) 
		{
			if (data.username.equals(username)&&data.password.equals(password)){return data.id;};
		}
		return 0;
	}
	
	public static String NewcheckAvailableUserRID (ArrayList <userObject> users,String username,String password)
	{
		for (userObject data : users) 
		{
			if (data.username.equals(username)&&data.password.equals(password))
			{
				if (data.admin==true){return "true1";}
				else {return"true2";}
			}
		}
		return "false";
	}
	public static int returnID(ArrayList <userObject> users,String username,String password)
	{
		for (userObject data : users) 
		{
			if (data.username.equals(username)&&data.password.equals(password))
			{
				return data.id;
			}
		}
		return 0;
	}
	
	
	public static  userObject findmatchIDuser(ArrayList <userObject> users,int id)//id 0 yani beporse
	{
		if (id==0)
		{
			showAvailableUsers(users);
			System.out.println("target ID ? :");
			id =input.nextInt();
		}
		for (userObject data : users) 
		{
			if(id==data.id)
				return(data);
		}
		return null;
	}
	
	public static String showAvailableUsers(ArrayList<userObject> users)
	{
		int i=1;
		String sendMsg= null;
		for (userObject data : users)
		{
			sendMsg=sendMsg+(i++) +".\t ID :"+data.id+" username :"+data.username+" password :"+data.password+" admin :"+data.admin+" job: "+data.job;
			sendMsg=sendMsg+"\n";
		}
		return sendMsg;
	}



	

	
	
	
	
	
	

}
