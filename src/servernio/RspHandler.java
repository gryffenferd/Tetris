package servernio;

public class RspHandler {
	private byte[] rsp = null;
	private int rand;
	private int id;
	
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
			String rspMessage = new String(this.rsp);
			setRand(Splitter.splitInt(rspMessage));
		}
		if(new String(this.rsp).contains("ID")){
			String rspMessage = new String(this.rsp);
			setID(Splitter.splitInt(rspMessage));
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
