import java.io.*;

public class AB3_A3 {
	
	public static void main(String[] Args) throws IOException{
		int m = 4;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Bitte geben Sie den umzuwandelnden String ein.");
		String eingabe = in.readLine();
		System.out.println((berechneHashwert(eingabe)%m));
	}
	public static int berechneHashwert(String eingabe) {
		/**Der Einfachheit wegen wird das 'Ergebnis'
		 * als integer ausgegeben um dann während der
		 * Ausgabe mit int m modulo gerechnet zu
		 * werden. So kann beim debugging gesehen werden 
		 * ob der richtige Wert per return geliefert wird 
		 * oder schon in der Methode Fehler auftreten.
		 */
		int hashwert = 0;
		for(int i = 0; i<eingabe.length(); i++) {
			hashwert += (char) eingabe.charAt(i);
		}
		return hashwert;
	}

}
