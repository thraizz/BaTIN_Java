public class AB1_A1 {
	private int a,b,m,z;
	
	public AB1_A1(int zo, int ao, int bo, int mo) {
		z = zo;
		a = ao;
		b = bo;
		m = mo;		
	}
	
	public int nextRand(){
		int ergebnis = (a * z + b);
		ergebnis = ergebnis % m;
		return ergebnis;
	}
	
	public static void main(String[] args) {
		AB1_A1 generator1 = new AB1_A1(6, 5, 2, 45);
		System.out.println(generator1.nextRand());
	
	}
}