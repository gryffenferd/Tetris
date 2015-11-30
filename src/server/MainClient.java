package server;

public class MainClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Nio_Client()).start();
	}

}
