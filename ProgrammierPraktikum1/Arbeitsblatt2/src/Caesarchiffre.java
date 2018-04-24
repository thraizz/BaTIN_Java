import java.io.*;
public class Caesarchiffre {

	public static void main(String[] args)throws IOException{
		String[] ergebnis_array = new String[12];
		String eingabe, antwort;
		int schluessel;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int z=0; z<12; z++){
		do{
			System.out.println("Bitte geben Sie einen Schlüsselwert zwischen 1-25 ein.");	
			eingabe = in.readLine();
			schluessel = Integer.parseInt(eingabe);
			if(schluessel<1 || schluessel>25) {
				System.out.println("Keine gültige Eingabe. Versuchen Sie es erneut.");
			}
		}while(schluessel<1 || schluessel>25);
		
		System.out.println("Der Schluessel "+schluessel+" wurde gewählt.");
		System.out.println("Bitte geben Sie nun das zu behandelnde Wort ein.");
		eingabe = in.readLine();
		StringBuffer strbuf = new StringBuffer(eingabe);
		
		
		antwort = "1";

		if(antwort.matches("1")) {
			int verschluesselt = 0;
			String ergebnis = "";
			for(int i = 0; i < eingabe.length(); i++) {
				final int b;
				verschluesselt = (int) strbuf.charAt(i);
				
				if(Character.isLowerCase(eingabe.charAt(i))){
					b = 97;
					}
				else{
					b = 65;
					}
				verschluesselt = (int) (((verschluesselt-b)+schluessel)%26)+b;
				ergebnis += (char) verschluesselt;
				}
			System.out.println("Das Ergebnis ist "+ergebnis);

		}
			
		else{
			int verschluesselt = 0;
			String ergebnis = "";
			for(int i = 0; i < eingabe.length(); i++) {	
				final int b;				
				verschluesselt = (int) strbuf.charAt(i);
				if(Character.isLowerCase(eingabe.charAt(i))) {
					b = 97;
				}
				
				else{
					b = 65;
					}
				
				if(verschluesselt-schluessel<b) {
					verschluesselt=((19+schluessel)%26)+b;}
				else {verschluesselt = ((verschluesselt-b-schluessel)%26)+b;}
				
				
				ergebnis += (char) verschluesselt;	
				}
			System.out.println("Das Ergebnis ist "+ergebnis);
			ergebnis_array[z-1] = ergebnis;
			}
		}
		for(int j = 0;j<ergebnis_array.length;j++) {
			System.out.println(ergebnis_array[j]);	
		}
		} //Main ends here
} //End of class

