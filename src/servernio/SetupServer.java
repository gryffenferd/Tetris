package servernio;

public class SetupServer {

	private int scoreJ1;
	private int scoreJ2;
	private int id;
	
	public SetupServer(){
		this.scoreJ1 = 0;
		this.scoreJ2 = 0;
		this.id = 0;
	}
	
	public int getScoreJ1(){
		return this.scoreJ1;
	}
	
	public void setScoreJ1(int scoreJ1){
		this.scoreJ1 = scoreJ1;
	}

	public int getScoreJ2(){
		return this.scoreJ2;
	}
	
	public void setScoreJ2(int scoreJ12){
		this.scoreJ2 = scoreJ2;
	}
	
	public int getID(){
		return id++;
	}
}
