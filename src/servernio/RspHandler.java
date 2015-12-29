package servernio;

public class RspHandler {
	private byte[] rsp = null;
	private int rand;
	
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
		
		if(rsp.getClass().equals(String.class))
			System.out.println(new String(this.rsp));
		else{
			setRand(Integer.parseInt(new String(this.rsp)));
		}
	}

	public int getRand() {
		return rand;
	}
	
	public void setRand(int rand){
		this.rand = rand;
	}
}
