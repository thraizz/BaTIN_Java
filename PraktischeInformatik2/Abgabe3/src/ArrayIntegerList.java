
public class ArrayIntegerList implements IntegerList{
	private int[] intArray;
	private int listLength;
	
	public ArrayIntegerList(int maxLength) {
		this.intArray = new int[maxLength];
		this.listLength = 0;
	}

	public int getLength() {
		return this.listLength;
	}

	public int insertLast(int value) {
		if(this.intArray.length==this.listLength) {
			return -1;
		}
		this.intArray[this.listLength++]=value;
		return 0;
	}

	public int getFirst() {
		if(this.listLength==0) {
			return -9999;
		}
		return this.intArray[0];
	}

	public int deleteFirst() {
		if(this.listLength-1>0)
		for(int i=1;i<this.listLength;i++) {
			this.intArray[i-1]=this.intArray[i];
		}
		
		this.listLength--;
		return 0;
	}

	public boolean search(int value) {
		for(int i=0;i<this.listLength;i++) {
			if(this.intArray[i]==value) {
				return true;
			}
		}
		return false;
	}

	public void print() {
		for(int i=0;i<this.listLength;i++) {
			System.out.println(this.intArray[i]);
			}
		}
 
}
