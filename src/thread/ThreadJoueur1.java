package thread;

import java.awt.Frame;
import java.awt.GridLayout;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import tetris.Tetris;


public class ThreadJoueur1 extends Thread{
	
	private Frame f;
	public Tetris tetris;
	private CyclicBarrier barrier;
	
	public ThreadJoueur1(CyclicBarrier barrier2) {
		// TODO Auto-generated constructor stub
		this.barrier=barrier2;
	}

	public void run(){
		f.setLayout(new GridLayout(0, 2));
		tetris = new Tetris();
		f.add(tetris,0);
		tetris.init();
		tetris.start();
		f.setVisible(true);
		try {
			this.barrier.await();
		}
		catch (InterruptedException e) {e.printStackTrace();}
		catch (BrokenBarrierException e) {e.printStackTrace();
		}
		
		tetris.newGame();
	}
	
	public Frame getFrame(){
		return f;
	}
	
	public void setFrame(Frame f1){
		f=f1;
	}
}
