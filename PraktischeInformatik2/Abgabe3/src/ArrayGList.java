
public class ArrayGList <T> implements GList{
	
	private Object[] Array;
	private int listLength;
	
	public ArrayGList(int maxLength) {
		this.Array = new Object [maxLength];
		this.listLength = 0;
	}

	
	
	public int getLength() {
		return this.listLength;
	}

	public Object insertLast(int value) {
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
		return this.Array[0];
	}

	public Object deleteFirst() {
		if(this.listLength-1>0)
		for(int i=1;i<this.listLength;i++) {
			this.Array[i-1]=this.Array[i];
		}
		
		this.listLength--;
		return 0;
	}

	public boolean search(Object value) {
		for(int i=0;i<this.listLength;i++) {
			if(this.Array[i]==value) {
				return true;
			}
		}
		return false;
	}

	public void print() {
		for(int i=0;i<this.listLength;i++) {
			System.out.println(this.Array[i]);
			}
		}

}
