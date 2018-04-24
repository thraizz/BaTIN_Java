import java.io.*;

public class ZufallsGenerator {
	// Attribute mit denen der Generator arbeitet
	private int aktZufallszahl, seed;
	// Attribute der Berechnungsfunktion
	private int a,b,m;
	
	// Konstruktor 1
	public ZufallsGenerator(int a, int b, int m) {
		this.aktZufallszahl = 0;
		this.seed = this.aktZufallszahl;
		this.a = a;
		this.b = b;
		this.m = m;
	}
	
	//  Konstruktor 2
	public ZufallsGenerator(int a, int b, int m, int anfangswert) {
		this.aktZufallszahl = anfangswert;
		this.seed = this.aktZufallszahl;
		this.a = a;
		this.b = b;
		this.m = m;
	}
	// Methode 1
	public void setSeed(int seed) {
		this.seed = seed;
		this.aktZufallszahl = seed;
	}
	
	// Methode 2
	public void reset() {
		this.aktZufallszahl = this.seed;
	}
	
	// Methode 3
	public int nextRand(){
		int uebergabe = aktZufallszahl;
		int speicher = (a * aktZufallszahl + b);
		this.aktZufallszahl = speicher % m;
		return uebergabe;
	}
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		/** Wichtig ist bei der Erzeugung des Objekts nicht die selben Zahlen
		 * für b und m zu übergeben, sonst verändert sich bei einer '0' als
		 * aktueller Zufallszahl die Zufallszahl nicht mehr,
		 * es wird ja immer bspw. 3 addiert und modulo 3 gerechnet.
		 * Dies ergibt immer wieder 0.
		 */
		
		ZufallsGenerator ohneAnfangswert = new ZufallsGenerator(5, 3, 8);
//		ZufallsGenerator mitAnfangswert = new ZufallsGenerator(5, 3, 8, 14);

		
		do {

		    System.out.println();
			System.out.println("Bitte waehlen:");
			System.out.println("(1) Generator auf Anfangswert setzen.");
			System.out.println("(2) Generator zurücksetzen.");
			System.out.println("(3) Aktuelle Zufallszahl ausgeben und nächste berechnen.");
			System.out.println("(0) Ende");
		    choice = Integer.parseInt(in.readLine());
		    System.out.println();

		    switch (choice) {
		    
		      case 1:
		        System.out.println("Bitte Anfangswert eingeben:  ");
		       int uebergebenerSeed = Integer.parseInt(in.readLine());
		       ohneAnfangswert.setSeed(uebergebenerSeed);
		       break;

		      case 2:
		       ohneAnfangswert.reset();
		       break;

		      case 3:
		       System.out.println("Die aktuelle Zufallszahl beträgt: "+ohneAnfangswert.nextRand());
		       System.out.println("Die nächste Zufallszahl wurde berechnet.");
		       break;

		    }

		  } while (choice!=0);
	}
}
