package mainPack;
import java.util.ArrayList;

public class coPilotUserObject extends userObject{

	public coPilotUserObject(String username, String password, boolean admin, boolean addType) {
		super(username, password, admin, addType);
		// TODO Auto-generated constructor stub
		this.job="coPilot";
		
	}

	public String showMyEvent(ArrayList <airportObject> ports,ArrayList <airplaneObject> planes ,ArrayList<flightData> flights)
	{
		for (flightData data : flights) 
		{
			if(airplaneObject.findmatchIDplane(planes, data.planeID).copilot.equals(this.username))
				flightData.printElement(ports, planes, flights, data, 1);
			
		}
	}
}
