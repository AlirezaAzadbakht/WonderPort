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
	public SecondMainControler() throws IOException
	{	
		ArrayList <airplaneObject> planes = new ArrayList <airplaneObject>();
		ArrayList <airportObject> ports = new ArrayList <airportObject>();
		ArrayList <flightData> flights = new ArrayList <flightData>();
		ArrayList <userObject> users = new ArrayList <userObject>();
		
		
		importData(ports, planes, flights, users);
		
		airplaneObject.showAvailablePlanes(planes);
		userObject.showAvailableUsers(users);
		airportObject.showAvailablePort(ports);
		flightData.showAvailableflights(ports, planes, flights);
		
	}
	
	public void importData (ArrayList <airportObject> ports,ArrayList <airplaneObject> planes,ArrayList <flightData> flights,ArrayList <userObject> users) throws IOException
	{
		importObjFlight(flights);
		importObjPlane(planes);
		importObjPorts(ports);
		importObjUsers(users);
	}
	
	public void addObjPorts (ArrayList <airportObject> ports,airportObject subject) throws IOException
	{
		File file =new File("data-ports.txt");
		Gson gson =new Gson();
		BufferedWriter buffer = new BufferedWriter(new FileWriter(file,true));
		String temp=gson.toJson(subject);
		buffer.write(temp);
        buffer.newLine();
		buffer.close();

	}
	public void addObjFlight (ArrayList <flightData> flights, flightData subject) throws IOException
	{
		File file =new File("data-flights.txt");
		Gson gson =new Gson();
		BufferedWriter buffer = new BufferedWriter(new FileWriter(file,true));
		String temp=gson.toJson(subject);
		buffer.write(temp);
        buffer.newLine();
		buffer.close();

	}
	public void addObjUsers (ArrayList <userObject> users, userObject subject ) throws IOException
	{
		File file =new File("data-users.txt");
		Gson gson =new Gson();
		BufferedWriter buffer = new BufferedWriter(new FileWriter(file,true));
		String temp=gson.toJson(subject);
		buffer.write(temp);
        buffer.newLine();
		buffer.close();

	}
	public void addObjPlane (ArrayList <airplaneObject> planes,airplaneObject subject) throws IOException
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
	
	
}
