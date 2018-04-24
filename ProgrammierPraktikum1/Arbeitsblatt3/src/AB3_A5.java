import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AB3_A5 {
	public static void main(String[] args) throws IOException{
		System.out.println("Wie viele Wörter sollen verglichen werden ? Mindestens 6 eingeben!");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int li = 0;
		int rechts;
		do{
			rechts = Integer.parseInt(in.readLine());
		}while(rechts<6);
//		String[] str_array = {"Asterix", "Grautvornix", "Gutemine", "Idefix", "Majestix", "Miraculix", "Obelix"};		
		String[] str_array = new String[rechts];
		for(int i=0; i<rechts; i++) {
			System.out.println("Bitte Wort Nr. "+(i+1)+" eingeben.");
			str_array[i] = in.readLine();
		}
		
		
		System.out.println("Bitte geb nun das zu suchende Wort an.");
		String str_gesucht = in.readLine();
		
		int ergebnis = binaerSuche(str_array, li, rechts, str_gesucht);
		if(ergebnis!=-1) {
			System.out.println("Das Wort wurde an Stelle "+(ergebnis)+" des Arrays gefunden. Es ist das "+(ergebnis+1)+". Wort des Arrays.");
		}
		else if (ergebnis == -1) {
			System.out.println("Das Wort wurde nicht gefunden.");			
		}
		
	}
	
	public static int binaerSuche(String str_array[], int li, int rechts, String str_gesucht){
		int mi = li + (rechts-li)/2;

	    if(str_array[mi].compareTo(str_gesucht)==0){
	        return mi;
	    }
	    if(str_array[mi].compareTo(str_gesucht)>0){
	        return binaerSuche(str_array, li, mi-1, str_gesucht);
	    }else if(str_array[mi].compareTo(str_gesucht)<0){
	        return binaerSuche(str_array, mi+1, rechts, str_gesucht);
	    }
	    return -1;
	  }
}
