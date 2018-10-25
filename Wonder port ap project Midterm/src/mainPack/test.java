package mainPack;

import java.io.File;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//SecondMainControler main =new SecondMainControler();

		File file =new File("data-users.txt");
		file.delete();
		System.out.println("done");
	}

}
