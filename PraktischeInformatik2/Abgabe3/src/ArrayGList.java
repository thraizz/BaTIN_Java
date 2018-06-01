
public class ArrayGList <T> implements GList <T>{
	
	private T[] Array;
	private int listLength;
	
	public ArrayGList(int maxLength) {
		this.Array = (T[]) new Object [maxLength];
		this.listLength = 0;
	}

	
	
	public int getLength() {
		return this.listLength;
	}

	public int insertLast(T value) {
		if(this.Array.length==this.listLength) {
			return -1;
		}
		this.Array[this.listLength++]=value;
		return 0;
	}

	public Object getFirst() {
		if(this.listLength==0) {
			return -9999;
		}
		return (T) this.Array[0];
	}
	
	public int deleteFirst() {
		if(this.listLength-1>=0) {
		for(int i=1;i<this.listLength;i++) {
			this.Array[i-1]=this.Array[i];
		}
		this.listLength--;
		return 0;
		}
		return -1;
	}

	public boolean search(T value) {
		for(int i=0;i<this.listLength;i++) {
			if(this.Array[i]==value) {return false;}
		}
		return true;
	}

	public void print() {
		if(this.listLength==0) {
			System.out.println("Leer!");
		}
		for(int i=0;i<this.listLength;i++) {
			System.out.println(this.Array[i]);
			}
		}
	
	public int append(T[] GArray) {
		for(int i=0;i<GArray.length;i++) {
			if(this.insertLast(GArray[i])==-1) { 
				System.out.println("Maximale Groesse erreicht!");
				return -1; 
				}
		}
		return 0;
		
	}

}
