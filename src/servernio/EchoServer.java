package servernio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Iterator;

public class EchoServer {
	public static final int DEFAULT_PORT = 5555;
	private Selector selector;
	private ServerSocketChannel server;
	private final int port;
	private SetupServer setupServer = new SetupServer();
	
	private boolean gameOver = false;

	private boolean ready = false;
	
	private ArrayList<Integer> cmdJ1 = new ArrayList<>();
	private ArrayList<Integer> cmdJ2 = new ArrayList<>();
	
	private int counterJ1toServer = 0;
	private int counterJ2toServer = 0;
	private int counterServertoJ1 = 0;
	private int counterServertoJ2 = 0;	
	
	public EchoServer() {
		this(DEFAULT_PORT);
	}

	public EchoServer(int port) {
		this.port = port;
	}

	public void setup() throws IOException {
		this.selector = Selector.open();
		this.server = ServerSocketChannel.open();
		this.server.configureBlocking(false);
		InetAddress ia = InetAddress.getLocalHost();
		InetSocketAddress isa = new InetSocketAddress(ia, this.port);
		this.server.socket().bind(isa);
	}

	public void start() throws IOException {
		System.out.println("setting up server...");
		this.setup();
		System.out.println("server started...");
		SelectionKey acceptKey = this.server.register(this.selector,
				SelectionKey.OP_ACCEPT);
		while (acceptKey.selector().select() > 0) {
			for (Iterator<SelectionKey> it = this.selector.selectedKeys()
					.iterator(); it.hasNext();) {
				SelectionKey key = it.next();
				it.remove();
				if (!key.isValid())
					continue;
				if (key.isAcceptable()) {
					ServerSocketChannel ssc = (ServerSocketChannel) key
							.channel();
					SocketChannel socket = (SocketChannel) ssc.accept();
					socket.configureBlocking(false);
					socket.register(this.selector, SelectionKey.OP_READ
							| SelectionKey.OP_WRITE);
					continue;
				}
				if (key.isReadable()) {
					SocketChannel clientChannel = (SocketChannel) key.channel();
					this.doEcho("readable", clientChannel);
					continue;
				}
				if (key.isWritable()) {
					SocketChannel clientChannel = (SocketChannel) key.channel();
					this.doEcho("writable", clientChannel);
					continue;
				}
			}
		}
	}

	public void doEcho(String evt, SocketChannel socket) throws IOException {
		String msg = this.readMessage(socket);

		/* Pour quitter */
		if (msg.trim().equals("quit"))
			socket.close();

		/* Random Piece */
		if (msg.trim().indexOf("rand:") != -1) {
			String rand = "rand";
			for (int i = 0; i < 100 ; i++)
				rand = rand + ":" + setupServer.getPiece(i);
			this.writeMessage(socket, rand);
		}
		
		/* Game Over */
		if(msg.trim().equals("gameover")){
			this.gameOver = true;
		}

		/* Fin ? */
		if(msg.trim().equals("fin")){
			this.writeMessage(socket, "gameover:" + gameOver);
		}
		
		/* Score */
		else if (msg.trim().indexOf("score:") != -1) {
			ArrayList<Integer> array = Splitter.splitInts(msg.trim());
			if (array.get(1) == 0) {
				setupServer.setScoreJ1(array.get(0));
			}
			if (array.get(1) == 1) {
				setupServer.setScoreJ2(array.get(0));
			}

		/* ID */
		} else if (msg.trim().equals("ID")) {
			this.writeMessage(socket, "ID:" + setupServer.getID());
		}

		/* Ready */ 
		else if(msg.trim().equals("ready")){
			this.writeMessage(socket, "ok:" + ready);
		}
		
		/* Go */
		else if(msg.trim().equals("go")){
				this.ready = true;
		}
		
		/* Commande Joueur->Server */
		else if (msg.trim().contains("Commande")) {
			ArrayList<Integer> touches = Splitter.splitInts(msg.trim());
			if (touches.get(1) == 0) {
				//System.out.println(touches.get(1) + " : " + touches.get(0));
				cmdJ1.add(touches.get(0));
				counterJ1toServer++;
			}
			else {
				//System.out.println(touches.get(1) + " : " + touches.get(0));
				cmdJ2.add(touches.get(0));
				counterJ2toServer++;
			}
		}
		
		/* Server -> Joueur */
		else if (msg.trim().contains("newcommande")){
			int id = Splitter.splitInt(msg.trim());
			if(id == 0){
				if(counterJ2toServer > counterServertoJ1){
					this.writeMessage(socket, "commande:" + cmdJ2.get(counterServertoJ1++));
				}else{
					this.writeMessage(socket, "commande:0");
				}
			}else{
				if(counterJ1toServer > counterServertoJ2){
					this.writeMessage(socket, "commande:" + cmdJ1.get(counterServertoJ2++));
				}else{
					this.writeMessage(socket, "commande:0");
				}
			}
		}
	}

	public String readMessage(SocketChannel socket) throws IOException {
		ByteBuffer rcvbuf = ByteBuffer.allocate(1024);
		int nBytes = socket.read(rcvbuf);
		rcvbuf.flip();
		Charset charset = Charset.forName("us-ascii");
		CharsetDecoder decoder = charset.newDecoder();
		String res = decoder.decode(rcvbuf).toString();
		return res;
	}

	public void writeMessage(SocketChannel socket, String msg)
			throws IOException {
		ByteBuffer buffer = ByteBuffer.wrap((msg.getBytes()));
		int nBytes = socket.write(buffer);
	}

	public static void main() {
		EchoServer server = new EchoServer();
		try {
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}