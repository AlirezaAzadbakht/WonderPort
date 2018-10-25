package mainPack;
import java.util.ArrayList;

public class AdminUserObject extends userObject {

	public AdminUserObject(String username, String password, boolean admin, boolean addType) {
		super(username, password, admin, addType);
		// TODO Auto-generated constructor stub
		this.job="fuckinAdmin";
	}
	public String showMyEvent(ArrayList <airportObject> ports,ArrayList <airplaneObject> planes ,ArrayList<flightData> flights)
	{
		return job;
		
	}

}
