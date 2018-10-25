package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import mainPack.*;


public class Server {

	public static ArrayList<Socket> socketList = new ArrayList<Socket>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SecondMainControler main=new SecondMainControler();	

		ServerSocket listener = new ServerSocket(2997);
		System.out.println("-Server Started!");
		while(true)
		{
			Socket socket = listener.accept();
			System.out.println("New Client Connected!");
			ServerThread thread = new ServerThread(socket);
			thread.start();
		}
		
		
	}

}
