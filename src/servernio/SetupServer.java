package servernio;

import java.util.Random;

public class SetupServer {

	private int scoreJ1;
	private int scoreJ2;
	private int id;
	private int[] tabPiece = new int[100];
	
	private Random random = new Random();
	
	public SetupServer(){
		this.scoreJ1 = 0;
		this.scoreJ2 = 0;
		this.id = 0;
		generatePiece();
	}
	
	private void generatePiece() {
		// TODO Auto-generated method stub
		for(int j = 0;j<100;j++)
			tabPiece[j] = Math.abs(random.nextInt());
			
	}

	public int getPiece(int i){
		return tabPiece[i]; 
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
