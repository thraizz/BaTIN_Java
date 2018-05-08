
public class ArrayIntegerList implements IntegerList{
	private int[] intArray;
	private int listLength;
	
	public ArrayIntegerList(int maxLength) {
		this.intArray = new int[maxLength];
		this.listLength = 0;
	}
	@Override
	public int getLength() {
		return this.listLength;
	}
	@Override
	public int insertLast(int value) {
		if(this.intArray.length==this.listLength) {
			return -1;
		}
		this.intArray[this.listLength++]=value;
		return 0;
	}

	@Override
	public int getFirst() {
		if(this.listLength==0) {
			return -9999;
		}
		return this.intArray[0];
	}
	@Override
	public int deleteFirst() {
		if(this.listLength-1>0)
		for(int i=1;i<this.listLength;i++) {
			this.intArray[i-1]=this.intArray[i];
		}
		
		this.listLength--;
		return 0;
	}
	@Override
	public boolean search(int value) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
 
}
