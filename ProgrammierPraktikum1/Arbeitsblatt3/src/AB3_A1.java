import java.io.*;
import java.util.Random;

public class AB3_A1 {
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Bitte geben Sie zwei Ganzzahlen für a, b und m ein. z wird generiert.");
		int a = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		Random random = new Random();
		int z = random.nextInt(10);
		int m = Integer.parseInt(in.readLine());
		System.out.println("Rechnung: ("+a+"*"+z+"+"+b+") mod "+m+", wobei z eine generierte Zahl ist.");
		System.out.println("Die nächste Zufallszahl: "+zahlErgebnis(z,a,b,m));
	
	}
	
	public static int zahlErgebnis(int z, int a, int b, int m){
		int ZahlErgebnis = (a * z + b);
		ZahlErgebnis = ZahlErgebnis % m;
		return ZahlErgebnis;
	}

}