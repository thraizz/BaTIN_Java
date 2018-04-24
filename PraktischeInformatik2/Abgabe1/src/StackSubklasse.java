
public class StackSubklasse extends StackHauptklasse{

	public StackSubklasse(int groesse, int wert) {
		super(groesse);
		for(int i=0; i<this.stackArray.length; i++) {
			this.push(wert+i);
		}
	}
	public boolean isStackEmpty() {
		return this.top==-1;
	}
	
	public int push(int[] array) {
		if(array.length<this.stackArray.length-this.top) {
			for(int i=0; i<array.length; i++) {
				this.top=this.top+1;
				this.stackArray[this.top]=array[i];
			}
			return 0;
		}
		else {
			return -1;
		}
		
	}
}
