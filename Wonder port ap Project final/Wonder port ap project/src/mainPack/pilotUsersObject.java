package mainPack;
import java.util.ArrayList;

public class pilotUsersObject extends userObject {

	public pilotUsersObject(String username, String password, boolean admin, boolean addType) {
		super(username, password, admin, addType);
		// TODO Auto-generated constructor stub
		this.job="Pilot";
	}
}
