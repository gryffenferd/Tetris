package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Nio_Client implements Runnable{

	@Override
	public void run() {
		try{
			Charset charSet = Charset.forName("UI-ASCII");
			SocketChannel socket = SocketChannel.open(new InetSocketAddress("localhost",5555));
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("client -> sring to send: ");
			String strSend = keyboard.readLine();
			
			socket.write(charSet.encode(CharBuffer.wrap(strSend)));
			socket.close();
			
		}catch(IOException e) {e.printStackTrace();}
		
	}

}
