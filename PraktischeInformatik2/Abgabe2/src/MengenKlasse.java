import java.io.*;
public class MengenKlasse {
	protected byte[] GrundArray;
	
	public MengenKlasse(int groesse){
		this.GrundArray = new byte[groesse+1];
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
		
		System.out.println("Array mit L�nge 10 wird erzeugt, die ersten drei Felder werden ersetzt.");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		MengenUnterklasse testObjekt = new MengenUnterklasse(10, 2);
		int n = 1;
		do{
			System.out.println();
			System.out.println("W�hlen Sie eine der M�glichkeiten:");
			System.out.println("(1) Element hinzuf�gen");
			System.out.println("(2) Mengengr��e ausgeben");
			System.out.println("(3) Elemente ausgeben");
			System.out.println("(4) Pr�fen ob Inhalt leer ist");
			System.out.println("(5) Array mit Elementen f�llen");
			System.out.println("(0) Programm beenden");
			System.out.println();
			n = Integer.parseInt(in.readLine());
			switch (n) {
				case 1:
					System.out.println("Bitte geben Sie das hinzuzuf�gende Element ein:");
					if(testObjekt.add(Integer.parseInt(in.readLine()))==-1) {
						System.out.println("Das Element konnte nicht hinzugef�gt werden (returned -1).");
					}
					else {
						System.out.println("Das Element wurde hinzugef�gt (returned 0).");
					}
					break;
				case 2:
					System.out.println("Das Mengenarray beinhaltet "+testObjekt.size()+" Elemente.");
					break;
				case 3:
					testObjekt.print();
					break;
				case 4:
					if(testObjekt.isEmpty()) {
						System.out.println("Das Objekt ist leer.");
					}
					else {
						System.out.println("Das Objekt ist nicht leer.");
					}
					break;
				case 5:
					System.out.println("Bitte geben sie den Wert 'unten' an:");
					int unten = Integer.parseInt(in.readLine());
					System.out.println("Bitte geben sie den Wert 'oben' an:");
					int oben = Integer.parseInt(in.readLine());
					if(testObjekt.add(unten, oben)==-1){
						System.out.println("Die Werte konnten nicht hinzugef�gt werden.");
					}
					else {
						System.out.println("Die Werte wurden hinzugef�gt.");
					}
			}
		}while(n!=0);
		System.out.println("Programm wird beendet.");
	}
}
