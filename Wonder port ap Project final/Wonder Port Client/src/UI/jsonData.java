package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JComboBox;

import com.google.gson.Gson;

public class jsonData {
	int request;
	String username=null;
	String password=null;
	String name = null;
	String pilot=null;
	String copilot=null;
	int originID=0;
	int destinationID = 0;
	String date=null;
	String startTime=null;
	String landingTime=null;
	int passengers=0;
	int planeID=0;
	int id=0;
	boolean admin=false;
	static Socket socket=MainClassAfterUi.socket;
	
	public jsonData(int request,String username,String password,String name ,String pilot,String copilot ,int originID,int destinationID ,String date ,String startTime,String landingTime,int passengers,int planeID,int id,boolean admin)
	{
		this.request=request;
		this.username=username;
		this.password=password;
		this.name=name;
		this.pilot=pilot;
		this.copilot=copilot;
		this.originID=originID;
		this.destinationID=destinationID;
		this.date=date;
		this.startTime=startTime;
		this.landingTime=landingTime;
		this.passengers=passengers;
		this.planeID=planeID;
		this.id=id;
		this.admin=admin;
	}
	public static String JsonMe (jsonData data)
	{
		//object --> Json 
		Gson gson = new Gson();
		return gson.toJson(data);
	}
	public static void writeSocketMyJson(jsonData data) throws IOException
	{
		//object --> socket
		PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		System.out.println(JsonMe (data));
        writer.println(JsonMe (data));
	}
	
	public static String readSocket() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		try {
            String msg;
           // while (true) {
                msg = reader.readLine();
                if (msg.equals(null) == false) {
                    System.out.println(msg);
                   // break;
                }

           // }
            System.out.println(msg);
            msg=msg.replaceAll("null","");
            msg=msg.replaceAll("&", "<br>");
            msg=msg.replaceAll("%", "|");
            msg="<html>"+msg+"</html>";
            System.out.println(msg);
            return msg;
        } catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
    public static String NewreadSocket() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        try {
            String msg;
            //while (true) {
                msg = reader.readLine();
                if (msg.equals(null) == false) {
                    System.out.println(msg);
                    //break;
                }

            //}
            msg=msg.replaceAll("%", "|");
            System.out.println("***"+msg);
            return msg;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
    public static String NewgetPlanes()
    {
        jsonData j =new jsonData(2, null, null, null, null, null, 0, 0, null, null, null, 0, 0, 0, false);
        try {
            jsonData.writeSocketMyJson(j);
            String msg = jsonData.NewreadSocket();
            return msg;
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return "\n";
    }
    public static String NewgetPorts()
    {
        jsonData j =new jsonData(3, null, null, null, null, null, 0, 0, null, null, null, 0, 0, 0, false);
        try {
            jsonData.writeSocketMyJson(j);
            String msg = jsonData.NewreadSocket();
            return msg;
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return "\n";
    }

	
	public static String getPlanes()
	{
		jsonData j =new jsonData(2, null, null, null, null, null, 0, 0, null, null, null, 0, 0, 0, false);
		try {
			jsonData.writeSocketMyJson(j);
			String msg = jsonData.readSocket();
			return msg;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "\n";
	}

	public static String getPorts()
	{
		jsonData j =new jsonData(3, null, null, null, null, null, 0, 0, null, null, null, 0, 0, 0, false);
		try {
			jsonData.writeSocketMyJson(j);
			String msg = jsonData.readSocket();
			return msg;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "\n";
	}
	public static String getFlights()
	{
		jsonData j =new jsonData(4, null, null, null, null, null, 0, 0, null, null, null, 0, 0, 0, false);
		try {
			jsonData.writeSocketMyJson(j);
			String msg = jsonData.readSocket();
			return msg;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "\n";
	}

    public static String getUsers()
    {
        jsonData j =new jsonData(5, null, null, null, null, null, 0, 0, null, null, null, 0, 0, 0, false);
        try {
            jsonData.writeSocketMyJson(j);
            String msg = jsonData.readSocket();
            return msg;
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return "\n";
    }
	public static void splitMeNaddComboBox(String msg,JComboBox<String> list)
	{
		String receiver ;
        StringTokenizer st = new StringTokenizer(msg,"&");

		while(st.hasMoreTokens())
		{
			receiver = st.nextToken();
			list.addItem(receiver);
		}
			
	}
	
	

}
