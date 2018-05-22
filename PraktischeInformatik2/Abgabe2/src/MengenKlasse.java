import java.io.*;
public abstract class MengenKlasse {
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
	
	public abstract void complement();
	
	public static void main(String[] args) throws IOException {
		
		MengenUnterklasse testObjekt = new MengenUnterklasse(10, 2);
		testObjekt.print();
		testObjekt.complement();
		testObjekt.print();
		MengenUnterklasse nullObjekt = null;
		testObjekt = nullObjekt;
		try {
		testObjekt.print();
		} catch (java.lang.NullPointerException e) {
			System.out.println("Fehler: Nullzeiger-Zugriff");
		}
		System.out.println("Programm laeuft weiter.");
	}
}
