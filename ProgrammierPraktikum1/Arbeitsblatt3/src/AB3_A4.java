import java.io.*;

public class AB3_A4 {
	public static void main(String[] args) throws IOException{
		System.out.println("Wie viele Wörter sollen verglichen werden ? Mindestens 6 eingeben!");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int links = 0, rechts, eingabe, mitte, ergebnis;
		
		do{
			eingabe = Integer.parseInt(in.readLine());
		}while(eingabe<6);
		
//		String[] str_array = {"Asterix", "Grautvornix", "Gutemine", "Idefix", "Majestix", "Miraculix", "Obelix"};
		String[] str_array = new String[eingabe];
		for(int i=0; i<eingabe; i++) {
			System.out.println("Bitte Wort Nr. "+(i+1)+" eingeben.");
			str_array[i] = in.readLine();
		}
		rechts = str_array.length-1;
		
		System.out.println("Bitte geb nun das zu suchende Wort an.");
		String str_gesucht = in.readLine();
		
		links = 0;
		rechts = str_array.length - 1;
		do {
			mitte = (links + rechts) / 2;
			if (str_array[mitte].compareTo(str_gesucht) == 0) {
				break;
				}
			else {
				if (str_array[mitte].compareTo(str_gesucht) < 0) {
					links = mitte+1;
					}
				else {
		          rechts = mitte-1;
		          }
				}
			}while ((str_array[mitte].compareTo(str_gesucht) < 0 || str_array[mitte].compareTo(str_gesucht) > 0 ) && links <= rechts);
		    
		if (str_array[mitte].compareTo(str_gesucht) == 0) {
			ergebnis = mitte;
			}
		else {
			ergebnis = -1;
			}
		
		if(ergebnis!=-1) {
			System.out.println("Das Wort wurde an Stelle "+(ergebnis)+" des Arrays gefunden. Es ist das "+(ergebnis+1)+". eingegebene Wort.");
		}
		else if (ergebnis == -1) {
			System.out.println("Das Wort wurde nicht gefunden.");			
		}
	  }
}
