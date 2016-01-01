package gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import tetris.Tetris;

public class SoloFrame extends Frame {
	
	public SoloFrame() {
		Tetris tetris = new Tetris();
		this.setTitle("Tetris - Solo Mode ");
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
