package mainPack;
import java.util.ArrayList;

public class PassengersUserObject extends userObject{

	public PassengersUserObject(String username, String password, boolean admin, boolean addType) {
		super(username, password, admin, addType);
		// TODO Auto-generated constructor stub
		this.job="passenger";
	}
	public void showMyEvent(ArrayList <airportObject> ports,ArrayList <airplaneObject> planes ,ArrayList<flightData> flights)
	{
		for (flightData data : flights) 
		{
			if(data.passengersData.contains(this.username))
				flightData.printElement(ports, planes, flights, data, 1);
			
		}
	}

}
