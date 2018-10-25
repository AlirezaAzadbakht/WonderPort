package mainPack;
import java.util.ArrayList;

public class PassengersUserObject extends userObject{

	public PassengersUserObject(String username, String password, boolean admin, boolean addType) {
		super(username, password, admin, addType);
		// TODO Auto-generated constructor stub
		this.job="passenger";
	}
}
