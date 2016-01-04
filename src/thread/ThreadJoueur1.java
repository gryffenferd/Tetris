package thread;

import java.awt.Frame;
import java.awt.GridLayout;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import servernio.NioClient;
import tetris.Tetris;
import tetris.TetrisJ1;


public class ThreadJoueur1 extends Thread{
	
	private Frame f;
	public TetrisJ1 tetris;
	private CyclicBarrier barrier;
	private NioClient client;
	private int id;
	
	public ThreadJoueur1(CyclicBarrier barrier2,NioClient client, int id) {
		// TODO Auto-generated constructor stub
		this.client = client;
		this.id = id;
		this.barrier=barrier2;
	}

	public void run(){
		f.setLayout(new GridLayout(0, 2));
		tetris = new TetrisJ1(client,id);
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
