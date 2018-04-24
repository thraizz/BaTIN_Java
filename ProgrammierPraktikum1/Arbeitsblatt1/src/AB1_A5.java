
public class AB1_A5 {
	public static void main(String[] Args) {
		String s1 = new String("ersterString");
		String s2 = new String("zweiterString");
		verbindeStrings(s1, s2);
	}
	
	public static void verbindeStrings(String s1, String s2) {
		String s3 = new String(s1+" "+s2);
		System.out.println(s3);
	}

}
