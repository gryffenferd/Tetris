ackage gui;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import tetris.Tetris;

public class TetrisMulti{
	
	public TetrisMulti(){
		Frame frame = new Frame("TetrisMulti");
		frame.setLayout(new GridLayout(0, 2));
		Tetris t1 = new Tetris();
		Tetris t2 = new Tetris();
		t1.init();
		t1.start();
		t2.init();
		t2.start();
		t1.resize(750,400);
		t2.resize(750,400);
		frame.add(t1,0);
		frame.add(t2,1);
		
		
		
		frame.setSize(1500,880);
		
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		frame.setVisible(true);
	}

}
