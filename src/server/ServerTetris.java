package server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerTetris {

	public static ServerSocket ss = null;
	public static Thread t;
	
	public static void main(String[] args) {
		
		try{
			socketserver = new ServerSocket(5555);
			Thread t = new Thread(new Accepter_clients(socketserver));
			t.start();
			System.out.println("Mes employeurs sont prêts !");
			
		}catch(IOException e){e.printStackTrace();}
	}

}
