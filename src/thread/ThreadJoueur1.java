package thread;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
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
		/*try {
			this.click(tetris.start_newgame_butt,1);
			
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		
		
		
	}
	
	public Frame getFrame(){
		return f;
	}
	
	public void setFrame(Frame f1){
		f=f1;
	}
	
	public void click(Button start_newgame_butt2, int millis) throws AWTException
	{
	    Point p = start_newgame_butt2.getLocationOnScreen();
	    Robot r = new Robot();
	    r.mouseMove(p.x + start_newgame_butt2.getWidth() / 2, p.y + start_newgame_butt2.getHeight() / 2);
	    r.mousePress(InputEvent.BUTTON1_MASK);
	    try { Thread.sleep(millis); } catch (Exception e) {}
	    r.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
}
