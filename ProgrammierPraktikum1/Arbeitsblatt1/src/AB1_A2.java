import java.io.*;

public class AB1_A2 {
	
	public static void main(String[] Args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Bitte geben Sie ihren String ein.");
		String eingabe = in.readLine();
		System.out.println("Der Hashwert von "+eingabe+" beträgt "+berechneHashwert("abcd"));
		
	}

	public static int berechneHashwert(String eingabe) {
		int berechnung=0;
		int m=4;
		char[] char_array = eingabe.toCharArray();
		/** Das .split() nutzt einen regex-Ausdruck den wir nicht behandelt haben.
		*   Ich kenne diesen aus meinem Praktikum. Er teilt ein string zwischen jedem Character
		*   auf und returnt ein Array.
		*/
		for(int i = 0; i<char_array.length; i++) {
//			System.out.println(char_array[i]);
			berechnung = berechnung + char_array[i];
		}
		berechnung = berechnung % m;
		return berechnung;
	}

}
