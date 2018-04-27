
public class GenerischeKlassen <T> {
	private T firstAttribute = null;
	private T secondAttribute = null;
	
	protected int storeObject(T param) {
		if(firstAttribute == null) {
			firstAttribute = param;
		}
		else if(secondAttribute == null) {
			secondAttribute = param;
		}
		else {
			return -1;
		}
		return 0;
	}
	
	protected T getObject(int n) {
		T zwischenspeicher = null;
		if(n==1) {
			zwischenspeicher = firstAttribute;
			firstAttribute = null;
		}
		if(n==2) {
			zwischenspeicher = secondAttribute;
			secondAttribute = null;
		}
		return zwischenspeicher;
	}
}
