
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

	public int add(int unten, int oben) {
		if(unten<0||unten>this.GrundArray.length||oben<0||oben>this.GrundArray.length) {
			return -1;
		}
		for(int i=unten;i<=oben;i++) {
			this.GrundArray[i]=1;
		}
		return 0;
		
	}

	public void complement() {
		for(int i=0;i<this.GrundArray.length;i++) {
			if(this.GrundArray[i]==1) {
				this.GrundArray[i]=0;
			}
			else {
				this.GrundArray[i]=1;
			}
		}
		
	}
}
