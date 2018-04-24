public class AB1_A4 {
	public static void main(String[] Args) {
		char c = 'A'; //Hier wird die char-Variable c definiert.
		nachfolgerBestimmen(c); //Die Methode nachfolgerBestimmen() wird mit der Übergabe 'c' aufgerufen. 
		}
	
	public static void nachfolgerBestimmen(char c) {
		System.out.println("Die Eingabe "+(char) c+" hat den ASCII Wert "+(int) c+"."); 
		System.out.println("Das eigentliche nächste Zeichen wäre '" + (char)(c + 2)+"' und hätte den ASCII Wert "+(int) (c+2)+".");
		System.out.println();
		System.out.println("Mit dem richitgen Algorithmus wird nun der nächste Buchstabe bestimmt.");
		System.out.println("Der nächste Buchstabe hat den ASCII Wert "+((c - 'A' + 2) % 26 + 'A')+", also "+(char) ((c - 'A' + 2) % 26 + 'A')+".");
	}

}
