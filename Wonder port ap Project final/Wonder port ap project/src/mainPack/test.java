package mainPack;

import java.io.File;
import java.io.IOException;

public class test {
	static String a;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//SecondMainControler main =new SecondMainControler();
		SecondMainControler main =new SecondMainControler();
		
		//String a = ;
		a=userObject.findmatchIDuser(SecondMainControler.users, 5).showMyEvent(SecondMainControler.ports, SecondMainControler.planes, SecondMainControler.flights);
		
		System.out.println(a);
		//System.out.println(userObject.findmatchIDuser(SecondMainControler.users, 5).showw());
	}

}
