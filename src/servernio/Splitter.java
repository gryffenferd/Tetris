package servernio;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
	
}
