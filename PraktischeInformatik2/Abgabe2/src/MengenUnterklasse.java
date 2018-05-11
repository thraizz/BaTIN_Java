
public class MengenUnterklasse extends MengenKlasse {
	int wert;
	public MengenUnterklasse(int groesse, int wert) {
		super(groesse);
		this.wert = wert;
		if(wert<this.GrundArray.length) {
		for(int i=0; i<=wert; i++) {
			this.GrundArray[i]=1;
		}
		}
	}
	
	public boolean isEmpty() {
		boolean returnValue=false;
		for(int i=0; i<this.GrundArray.length;i++) {
			if(this.GrundArray[i]==1){returnValue=true;}
		}
		return returnValue;
	}
	
	public int add(int[] array) {
		for(int i = 0; i<array.length; i++) {
			if(this.add(array[i])==-1){
				return -1;
			}
		}
		return 0;
		
	}
}
