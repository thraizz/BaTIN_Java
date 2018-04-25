import java.io.*;
public class MengenKlasse {
	protected byte[] GrundArray;
	
	public MengenKlasse(int groesse){
		this.GrundArray = new byte[groesse];
	}
	
	public int add(int toBeInserted) {
		if(this.GrundArray.length>=toBeInserted) {
			this.GrundArray[toBeInserted]=(byte)1;
			return 0;
		}
		else {
			return -1;			
		}
	}
	
	public int size() {
		int groesse=0;
		for(int i = 0;i<this.GrundArray.length;i++) {
			if(this.GrundArray[i]==1) {
				groesse++;
			}
		}
		return groesse;
	}
	
	public void print() {
		for(int i = 0;i<this.GrundArray.length;i++) {
			if(this.GrundArray[i]==1) {
				System.out.println(i+" vorhanden.");;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Bitte geben Sie die gewünschte Länge des Mengenarrays ein:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		MengenKlasse testObjekt = new MengenKlasse(Integer.parseInt(in.readLine())+1);
		int n = 1;
		do{
			System.out.println();
			System.out.println("Wählen Sie eine der Möglichkeiten:");
			System.out.println("(1) Element hinzufügen");
			System.out.println("(2) Mengengröße ausgeben");
			System.out.println("(3) Elemente ausgeben");
			System.out.println("(0) Programm beenden");
			System.out.println();
			n = Integer.parseInt(in.readLine());
			switch (n) {
				case 1:
					System.out.println("Bitte geben Sie das hinzuzufügende Element ein:");
					if(testObjekt.add(Integer.parseInt(in.readLine()))==-1) {
						System.out.println("Das Element konnte nicht hinzugefügt werden (returned -1).");
					}
					else {
						System.out.println("Das Element wurde hinzugefügt (returned 0).");
					}
					break;
				case 2:
					System.out.println("Das Mengenarray beinhaltet "+testObjekt.size()+" Elemente.");
					break;
				case 3:
					testObjekt.print();
					break;
			}
		}while(n!=0);
		System.out.println("Programm wird beendet.");
	}
}
