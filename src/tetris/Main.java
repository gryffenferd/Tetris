package tetris;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) {

		Frame frame = new Frame("Tetris");
		Frame frame2 = new Frame("Tetris2");
		Tetris tetris2 = new Tetris();
		Tetris tetris = new Tetris();
		frame.add(tetris);
		frame2.add(tetris2);
		tetris.init();
		tetris.start();
		tetris2.init();
		tetris2.start();

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		frame.setSize(750, 441);
		frame.setResizable(false);
		frame.setVisible(true);
		
		frame2.setSize(750, 441);
		frame2.setResizable(false);
		frame2.setVisible(true);
	}
	
}
