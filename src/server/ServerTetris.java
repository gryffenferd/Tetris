package server;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class ServerTetris implements Runnable{

	public static final int DEFAULT_PORT = 5555;
	
	private Selector selector;
	private ServerSocketChannel server;
	private final int port;
	
	public ServerTetris(){
		this(DEFAULT_PORT);
	}
	
	public ServerTetris(int port){
		this.port = port;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

}
