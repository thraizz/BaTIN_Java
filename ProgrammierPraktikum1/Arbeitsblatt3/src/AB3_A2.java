import java.io.*;

public class AB3_A2 {
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Bitte geben Sie zwei Ganzzahlen für a, b und m ein.");
		int a = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		int z = 0;
		int ergebnis;
		int m = Integer.parseInt(in.readLine());
		for(int i=0; i<20; i++) {
				System.out.println("Rechnung: ("+a+"*"+z+"+"+b+") mod "+m+".");
				ergebnis = zahlErgebnis(z,a,b,m);
				System.out.println("Die nächste Zufallszahl: "+ergebnis);
				z = ergebnis;
		}
	
	}
	
	public static int zahlErgebnis(int z, int a, int b, int m){
		int ZahlErgebnis = (a * z + b);
		ZahlErgebnis = ZahlErgebnis % m;
		return ZahlErgebnis;
	}

}