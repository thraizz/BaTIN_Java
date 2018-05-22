import java.io.*;

public class MenschClass {
	
	private String name;
	private double groesse;
	private int alter;
	
	public MenschClass(String name, double groesse, int alter) {
		this.name=name;
		this.groesse=groesse;
		this.alter=alter;
	}
	
	public void printAttributes() {
		System.out.println("Name: "+this.name);
		System.out.println("Groesse: "+this.groesse);
		System.out.println("Alter: "+this.alter);
	}
	
	
	public static void main(String[] args) throws IOException {
//		try {
		FileReader fr = new FileReader("daten.txt");
//		} catch(IOException e) {
//			System.out.println("Fehler: "+e.getMessage()+", moeglicherweise falscher Dateiname?");
//		}
		char[] c = new char[5];
		int i;
		while((i = fr.read(c)) >= 0) {
			System.out.println("Zeichen: "+i);
			System.out.print(c);
		}
	}
	
}
