import java.io.*;
public class MengenKlasse {
	protected byte[] GrundArray;
	
	public MengenKlasse(int groesse){
		this.GrundArray = new byte[groesse];
	}
	
	public int add(int toBeInserted) {
		if(this.GrundArray.length+1>toBeInserted) {
			this.GrundArray[toBeInserted]=(byte)1;
			return 0;
		}
		else {
			return -1;			
		}
	}
	
	public int size() {
		int groesse=0;
		for(int i = 0;i<this.GrundArray.length+1;i++) {
			if(this.GrundArray[i]==1) {
				groesse++;
			}
		}
		return groesse;
	}
	
	public void print() {
		for(int i = 0;i<this.GrundArray.length+1;i++) {
			if(this.GrundArray[i]==1) {
				System.out.println("Element "+i+": "+this.GrundArray[i]);;
			}
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Bitte geben Sie die gewünschte Länge des Mengenarrays ein:");
		
		MengenKlasse testObjekt = new MengenKlasse(4);
		System.out.println(testObjekt.GrundArray[2]);
	}
}
