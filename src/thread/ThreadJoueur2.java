package thread;

import java.awt.Frame;
import java.awt.GridLayout;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import tetris.TetrisJ2;


public class ThreadJoueur2 extends Thread{
	
	private Frame f;
	public TetrisJ2 tetris;
	private CyclicBarrier barrier;
	
	public ThreadJoueur2(CyclicBarrier barrier2) {
		// TODO Auto-generated constructor stub
		this.barrier=barrier2;
	}

	public void run(){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tetris = new TetrisJ2();
		f.add(tetris,1);
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
