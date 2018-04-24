import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kontrollstrukturen3 {
		public static void main(String[] args)throws IOException{
			int n = 1;
			String eingabe;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			while(n>0 || n!=0) {
				System.out.println("Bitte positive Zahl angeben.");
				System.out.println("Die Eingabe einer Null beendet das Programm.");
				eingabe = in.readLine();
				n = Integer.parseInt(eingabe);
				if(n==0) {
					break;
				}	
				if(n>0) {
					zaehleStellen(n);
				}
				else {
					System.out.println("Nummer ist nicht größer als Null!");
					
				}
				}
			}
		
		public static void zaehleStellen(int n) {
			String eingabe = Integer.toString(n);
			int i = 0;
				while(n!=0) {
					n = n/10;
					i = i+1;
				}
				System.out.println(eingabe+" hat "+i+" Stellen.");
			}
		
}

