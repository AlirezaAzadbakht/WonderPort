package mainPack;
import java.util.ArrayList;

public class pilotUsersObject extends userObject {

	public pilotUsersObject(String username, String password, boolean admin, boolean addType) {
		super(username, password, admin, addType);
		// TODO Auto-generated constructor stub
		this.job="Pilot";
	}
	
	public void showMyEvent(ArrayList <airportObject> ports,ArrayList <airplaneObject> planes ,ArrayList<flightData> flights)
	{
		for (flightData data : flights) 
		{
			if(airplaneObject.findmatchIDplane(planes, data.planeID).pilot.equals(this.username))
				flightData.printElement(ports, planes, flights, data, 1);
			
		}
	}
	

}
