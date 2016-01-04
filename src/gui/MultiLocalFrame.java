package gui;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import tetris.Tetris;
import tetris.TetrisJ2;
import thread.ThreadJoueur1;
import thread.ThreadJoueur2;


public class MultiLocalFrame extends Frame{
	
	

	public MultiLocalFrame(){
		final CyclicBarrier barrier = new CyclicBarrier(3);
		ThreadJoueur1 t1 = new ThreadJoueur1(barrier);
		ThreadJoueur2 t2 = new ThreadJoueur2(barrier);
		t1.setFrame(this);
		t2.setFrame(this);
		t1.start();
		t2.start();
		this.setTitle("Tetris - Multiplayer Offline Mode ");
		this.setLocation(100, 100);
		

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(1500, 882);
		this.setResizable(false);
		this.setVisible(true);
		this.repaint();
		try {
			barrier.await();
		}
		catch (InterruptedException e) {e.printStackTrace();}
		catch (BrokenBarrierException e) {e.printStackTrace();
		}
		System.out.println("C'est lancé");
		
	}
}
