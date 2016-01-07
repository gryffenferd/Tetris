package servernio;

import java.util.ArrayList;

public class Splitter {

	public static int splitInt(String s){
		String tab[] = s.split(":");
		return Integer.parseInt(tab[1]);
	}
	
	public static ArrayList<Integer> splitInts(String s){
		String tab[] = s.split(":");
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(Integer.parseInt(tab[1]));
		array.add(Integer.parseInt(tab[2]));
		return array;		
	}

	public static String splitBoolean(String s) {
		String tab[] = s.split(":");		
		return tab[1];
	}
	
	public static int[] splitPiece(String s){
		String tab[] = s.split(":");
		int[] rsp = new int[100];
		for(int i = 0, j = 1; i<100;i++,j++)
			rsp[i] = Integer.parseInt(tab[j]);
		return rsp;
	}
	
}
