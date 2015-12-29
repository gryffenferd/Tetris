package gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import servernio.NioClient;
import tetris.TetrisServer;

public class MultiOnlineFrame extends Frame implements Runnable {

	private int rand;
	private static Random random = new Random();
	private NioClient client;
	
	public MultiOnlineFrame(){
		this.client = null;
	}
	
	public MultiOnlineFrame(NioClient client){
		this.client = client;
		System.out.println("MultiOnline !!!");
	}

	@Override
	public void run() {
		TetrisServer tetris = new TetrisServer();
		this.setTitle("Tetris - Multi Mode ");
		this.setLocation(200, 200);
		this.add(tetris);
		tetris.init();
		tetris.start();

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(750, 441);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public int getRand(){
		return this.rand;
	}
	
	public void setRand(){
		this.rand = Math.abs(random.nextInt());
	}
}
