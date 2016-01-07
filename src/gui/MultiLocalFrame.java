package gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import servernio.NioClient;
import servernio.RspHandler;
import thread.ThreadJoueur1;
import thread.ThreadJoueur2;


public class MultiLocalFrame extends Frame implements Runnable{
	
	private int rand;
	private static Random random = new Random();
	private NioClient client;
	private int id;
	
	public MultiLocalFrame(NioClient client,int id){
		this.client = client;
		this.id = id;
	}

	public void run(){
		final CyclicBarrier barrier = new CyclicBarrier(3);
		ThreadJoueur1 t1 = new ThreadJoueur1(barrier,this.client,this.id);
		ThreadJoueur2 t2 = new ThreadJoueur2(barrier,this.client,this.id);
		t1.setFrame(this);
		t2.setFrame(this);
		t1.start();
		t2.start();
		this.setTitle("Tetris - Multiplayer Online Mode ");
		this.setLocation(0, 0);
		

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				RspHandler handler = new RspHandler();
				try {
					client.send("quit".getBytes(), handler);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});

		this.setSize(1300, 882);
		this.setResizable(false);
		this.setVisible(true);
		try {
			barrier.await();
		}
		catch (InterruptedException e) {e.printStackTrace();}
		catch (BrokenBarrierException e) {e.printStackTrace();
		}
	}
	
	public int getRand(){
		return this.rand;
	}
	
	public void setRand(){
		this.rand = Math.abs(random.nextInt());
	}
}
