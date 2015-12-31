package servernio;

public class Splitter {

	public static int splitInt(String s){
		String tab[] = s.split(":");
		return Integer.parseInt(tab[1]);
	}
	
}
