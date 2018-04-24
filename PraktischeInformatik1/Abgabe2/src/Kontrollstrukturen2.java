import java.io.*;

public class Kontrollstrukturen2 {
		public static void main(String[] args)throws IOException{
			int n = -1;
			int i=0;
			String eingabe;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while(n<0) {
				System.out.println("Bitte positive Zahl angeben");
				eingabe = in.readLine();
				n = Integer.parseInt(eingabe);
//				int anzahlDerStellen = String.valueOf(n).length();
//				System.out.println(eingabe+" hat "+anzahlDerStellen+" Stellen.");
				while(n!=0) {
					n = n/10;
					i = i+1;
				}
				System.out.println(eingabe+" hat "+i+" Stellen.");
			}
		
		}
}
