package server;

import java.io.IOException;
import java.net.Socket;

public class ClientTetris {
	

	public static void main(String[] zero) {
		
		Socket socket;
		
		try {
		socket = new Socket("localhost",5555);
		socket.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


}
