package server;

public class MainServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Nio_Server()).start();
	}

}
