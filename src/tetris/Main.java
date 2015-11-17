package tetris;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) {

		/*Frame frame = new Frame("Tetris");
		Tetris tetris = new Tetris();
		frame.add(tetris);
		tetris.init();
		tetris.start();

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		frame.setSize(750, 441);
		frame.setResizable(false);
		frame.setVisible(true);*/
		TetrisMulti t = new TetrisMulti();
	}
	
}
