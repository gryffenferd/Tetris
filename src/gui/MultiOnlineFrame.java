package gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import tetris.TetrisServer;

public class MultiOnlineFrame extends Frame implements Runnable {

	public MultiOnlineFrame(){
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
}
