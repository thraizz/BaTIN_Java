import java.io.*;
public class Polynomberechnung {
	public static void main(String[] arg)throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Geben Sie a, b und c ein.");
		float a = Float.parseFloat(in.readLine());
		float b = Float.parseFloat(in.readLine());
		float c = Float.parseFloat(in.readLine());
		
		System.out.println("Geben Sie die Intervallgrenzen ein.");
		float x_links = Float.parseFloat(in.readLine());
		float x_rechts = Float.parseFloat(in.readLine());
		
		if(x_links>x_rechts) {
			float tauscher = x_links;
			x_links = x_rechts;
			x_rechts = tauscher;
		}
		
		System.out.println("Geben Sie die Stützstellen ein.");
		
		final float iende = x_rechts*x_links+x_links;
		
		for(int i=(int) x_links; i<(int)iende; i++) {
			float ausgabe = (a*(i*i))+(b*i)+(c);
			System.out.println("f("+i+") beträgt "+ausgabe);
		}
	}

}
