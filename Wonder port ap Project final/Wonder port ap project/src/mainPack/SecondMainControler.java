package mainPack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import com.google.gson.*;


public class SecondMainControler {
	public static ArrayList <airplaneObject> planes = new ArrayList <airplaneObject>();
	public static ArrayList <airportObject> ports = new ArrayList <airportObject>();
	public static ArrayList <flightData> flights = new ArrayList <flightData>();
	public static ArrayList <userObject> users = new ArrayList <userObject>();
	public SecondMainControler() throws IOException
	{	
		
		System.out.println("data imported!");
		importData(ports, planes, flights, users);
		showEveryThing(ports, planes, flights, users);
		
	}
	
	public void showEveryThing(ArrayList <airportObject> ports,ArrayList <airplaneObject> planes,ArrayList <flightData> flights,ArrayList <userObject> users)
	{
		System.out.println("ports IDs");
		for (airportObject data : ports) {
			System.out.println(data.id+"\t"+data);	
		}
		System.out.println("planes IDs");
		for (airplaneObject	 data : planes) {
			System.out.println(data.id+"\t"+data);	
		}
		System.out.println("flights IDs");
		for (flightData data : flights) {
			System.out.println(data.id+"\t"+data);	
		}
		System.out.println("users IDs");
		for (userObject data : users) {
			System.out.println(data.id+"\t"+data);
		}
		
	}
	
	public void importData (ArrayList <airportObject> ports,ArrayList <airplaneObject> planes,ArrayList <flightData> flights,ArrayList <userObject> users) throws IOException
	{
		importObjFlight(flights);
		importObjPlane(planes);
		importObjPorts(ports);
		importObjUsers(users);
		getIDs();
	}
	
	public static void addObjPorts (ArrayList <airportObject> ports,airportObject subject) throws IOException
	{
		File file =new File("data-ports.txt");
		Gson gson =new Gson();
		BufferedWriter buffer = new BufferedWriter(new FileWriter(file,true));
		String temp=gson.toJson(subject);
		buffer.write(temp);
        buffer.newLine();
		buffer.close();

	}
	public static void addObjFlight (ArrayList <flightData> flights, flightData subject) throws IOException
	{
		File file =new File("data-flights.txt");
		Gson gson =new Gson();
		BufferedWriter buffer = new BufferedWriter(new FileWriter(file,true));
		String temp=gson.toJson(subject);
		buffer.write(temp);
        buffer.newLine();
		buffer.close();

	}
	public static void addObjUsers (ArrayList <userObject> users, userObject subject ) throws IOException
	{
		File file =new File("data-users.txt");
		Gson gson =new Gson();
		BufferedWriter buffer = new BufferedWriter(new FileWriter(file,true));
		String temp=gson.toJson(subject);
		buffer.write(temp);
        buffer.newLine();
		buffer.close();

	}
	public static void addObjPlane (ArrayList <airplaneObject> planes,airplaneObject subject) throws IOException
	{
		File file =new File("data-planes.txt");
		Gson gson =new Gson();
		BufferedWriter buffer = new BufferedWriter(new FileWriter(file,true));
		String temp=gson.toJson(subject);
		buffer.write(temp);
        buffer.newLine();
		buffer.close();
	}
	////////////////////////////////////////
	public void importObjPorts (ArrayList <airportObject> ports) throws IOException
	{
		
		File file =new File("data-ports.txt");
		Gson gson =new Gson();
		BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null)
        {
        	ports.add(gson.fromJson(line, airportObject.class));
        }
        buffer.close();

		
	}
	public void importObjFlight (ArrayList <flightData> flights) throws IOException
	{
		
		File file =new File("data-flights.txt");
		Gson gson =new Gson();
		BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null)
        {
        	flights.add(gson.fromJson(line, flightData.class));
        }
        buffer.close();
	}
	public void importObjUsers (ArrayList <userObject> users) throws IOException
	{
		
		File file =new File("data-users.txt");
		Gson gson =new Gson();
		BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null)
        {
        	users.add(gson.fromJson(line, userObject.class));
        }
        buffer.close();
	}
	public void importObjPlane (ArrayList <airplaneObject> planes) throws IOException
	{
		
		File file =new File("data-planes.txt");
		Gson gson =new Gson();
		BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null)
        {
        	planes.add(gson.fromJson(line, airplaneObject.class));
        }
        buffer.close();
	}
	/////////////////////////////////////////////
	public static void saveObjPorts (ArrayList <airportObject> ports) throws IOException
	{
		File file =new File("data-ports.txt");
		file.delete();
		for (airportObject subject : ports) {
			addObjPorts(ports, subject);
		}
		
	}
	public static void saveObjFlight (ArrayList <flightData> flights) throws IOException
	{
		File file =new File("data-flights.txt");
		file.delete();
		for (flightData subject : flights) {
			addObjFlight(flights, subject);
		}
	}
	public static void saveObjUsers (ArrayList <userObject> users) throws IOException
	{
		File file =new File("data-users.txt");
		file.delete();
		for (userObject subject : users) {
			addObjUsers(users, subject);
		}
	}
	public static void saveObjPlane (ArrayList <airplaneObject> planes) throws IOException
	{
		File file =new File("data-planes.txt");
		file.delete();
		for (airplaneObject subject : planes) {
			addObjPlane(planes, subject);
		}
		
	}
	public static void backup ( ArrayList <airplaneObject> planes,ArrayList <userObject> users,ArrayList <flightData> flights,ArrayList <airportObject> ports) throws IOException
	{
		saveObjFlight(flights);
		saveObjPlane(planes);
		saveObjPorts(ports);
		saveObjUsers(users);
		saveIDs();
	}
	
	public static void saveIDs () throws IOException
	{
		File file =new File("data-IDs.txt");
		file.delete();
		BufferedWriter buffer = new BufferedWriter(new FileWriter(file,true));
		buffer.write(String.valueOf(airportObject.i));
		buffer.newLine();
		buffer.write(String.valueOf(airplaneObject.i));
		buffer.newLine();
		buffer.write(String.valueOf(flightData.i));
		buffer.newLine();
		buffer.write(String.valueOf(userObject.i));
		buffer.close();
	}
	public static void getIDs () throws IOException
	{
		File file =new File("data-IDs.txt");
		BufferedReader buffer = new BufferedReader(new FileReader(file));
        airportObject.i=Integer.valueOf(buffer.readLine());
        airplaneObject.i=Integer.valueOf(buffer.readLine());
        flightData.i=Integer.valueOf(buffer.readLine());
        userObject.i=Integer.valueOf(buffer.readLine());
        buffer.close();

	}
	
	
}
