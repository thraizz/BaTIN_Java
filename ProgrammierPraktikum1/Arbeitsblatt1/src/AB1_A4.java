public class AB1_A4 {
	public static void main(String[] Args) {
		char c = 'A'; //Hier wird die char-Variable c definiert.
		nachfolgerBestimmen(c); //Die Methode nachfolgerBestimmen() wird mit der �bergabe 'c' aufgerufen. 
		}
	
	public static void nachfolgerBestimmen(char c) {
		System.out.println("Die Eingabe "+(char) c+" hat den ASCII Wert "+(int) c+"."); 
		System.out.println("Das eigentliche n�chste Zeichen w�re '" + (char)(c + 2)+"' und h�tte den ASCII Wert "+(int) (c+2)+".");
		System.out.println();
		System.out.println("Mit dem richitgen Algorithmus wird nun der n�chste Buchstabe bestimmt.");
		System.out.println("Der n�chste Buchstabe hat den ASCII Wert "+((c - 'A' + 2) % 26 + 'A')+", also "+(char) ((c - 'A' + 2) % 26 + 'A')+".");
	}

}
