package server;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Nio_Server implements Runnable{

	@Override
	public void run() {

		Charset charSet = Charset.forName("US-ASCII");
		try{
			ServerSocketChannel server = ServerSocketChannel.open();
			server.socket().bind(new InetSocketAddress(5555));
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			
			while(true){
				System.out.println("\nserver is listening...");
				SocketChannel client = server.accept();
				StringBuffer sBuffer = new StringBuffer();
				
				while(client.read(buffer)!=-1){
					buffer.flip();
					sBuffer.append(charSet.decode(buffer));
					buffer.clear();
				}
				System.out.println("server receives ->" + sBuffer);
				client.close();
		}			
		}catch(Exception e) {e.printStackTrace();}
		
	}

}
