import java.io.*;

public class Kontrollstrukturen {
	public static void main(String[] args)throws IOException{
		
		int zz, z, nn, n, g1, g2;
		String eingabe;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Bitte zwei ganze Zahlen eingeben.");
		eingabe = in.readLine();
		z  = Integer.parseInt(eingabe);
		while(z<=0) {
		eingabe = in.readLine();
		z  = Integer.parseInt(eingabe);
		}
		eingabe = in.readLine();
		n  = Integer.parseInt(eingabe);
		while(n<=0) {
		eingabe = in.readLine();
		n  = Integer.parseInt(eingabe);
		}
		
		g1 = z;
		g2 = n;
		
		while(g1!=g2) {
			if(g1<g2) {
				g2 = g2-g1;
				}
			else {
				g1 = g1-g2;
			}

		}
		zz=z/g1;
		nn=n/g1;
		
		System.out.println("Die Werte können durch "+zz+"/"+nn+"als Bruch beschrieben werden.");
		System.out.println();
		System.out.println();
			
	}

}
