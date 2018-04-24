import java.util.Random;

public class Pseudozufallszahlen {
	
	public static void main(String[] args) {
		Random random = new Random();
		int z = random.nextInt(10);
		int a = 5;
		int b = 2;
		int m = 3;
		ZahlErgebnis(z,a,b,m);
	
	}
	
	public static void Zahlergebnis(int z, int a, int b, int m){
		int ZahlErgebnis = (a * z + b);
		ZahlErgebnis = ZahlErgebnis % m;
		System.out.println("Rechnung: ("+a+"*"+z+"+"+b+") mod "+m);
		System.out.println("Nächste Zufallszahl: "+ZahlErgebnis);
	}

}