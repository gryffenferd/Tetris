package servernio;

public class RspHandler {
	private byte[] rsp = null;
	private int rand;
	private int id;
	private boolean ready;
	private int touche;
	private int[] tabPiece = new int[100];
	private boolean gameOver;
	
	public synchronized boolean handleResponse(byte[] rsp) {
		this.rsp = rsp;
		this.notify();
		return true;
	}
	
	public synchronized void waitForResponse() {
		while(this.rsp == null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		
		if(new String(this.rsp).contains("rand")){
			setPiece(Splitter.splitPiece(new String(this.rsp)));
		}
		if(new String(this.rsp).contains("ID")){
			String rspMessage = new String(this.rsp);
			setID(Splitter.splitInt(rspMessage));
		}
		if(new String(this.rsp).contains("ok")){
			setReady(Splitter.splitBoolean(new String(this.rsp)));
		}
		if(new String(this.rsp).contains("commande")){
			setTouche(Splitter.splitInt(new String(this.rsp)));
		}
		if(new String(this.rsp).contains("gameover:")){
			if(Splitter.splitBoolean(new String(this.rsp)).equals("true"))
				isGameOver();
		}
	}
	
	private void isGameOver() {
		this.gameOver = true;		
	}
	
	public boolean getGameOver(){
		return gameOver;
	}

	public int[] getPiece(){
		return tabPiece;
	}
	
	public void setPiece(int[] tabPiece){
		this.tabPiece = tabPiece;
	}
	
	public int getTouche(){
		return touche;
	}
	
	public void setTouche(int touche){
		this.touche=touche;
	}
	
	public boolean getReady(){
		return ready;
	}
	
	public void setReady(String s){
		if(s.equals("false"))
			this.ready = false;
		else {
			this.ready = true;
		}
	}

	public int getRand() {
		return rand;
	}
	
	public void setRand(int rand){
		this.rand = rand;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setID(int id){
		this.id = id;
	}
}
