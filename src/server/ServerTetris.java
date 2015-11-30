package server;


import java.io.IOException;
import java.net.ServerSocket;
public class ServerTetris {

	public static ServerSocket ss = null;
	public static Thread t;
	
	public static void main(String[] args) {
		
		try{
			ss = new ServerSocket(5555);
			System.out.println("Le serveur est à l'écoute du port "+ss.getLocalPort());
			
				
		}catch(IOException e){e.printStackTrace();}
	}

}
