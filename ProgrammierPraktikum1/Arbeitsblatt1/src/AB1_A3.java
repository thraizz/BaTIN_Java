
public class AB1_A3 {
	public static void main(String[] Args) {
		short flags = 15; //Variable die die Lichterkette steuert
		short k = 3; //Bitnummer
		bestimmeBit(flags, k) //die k-te Bitstelle der short-Variable flags wird mit der Methode bestimmeFlags() errechnet.
;
	}
	
	public static void bestimmeBit(short flags, short k) {
		int b = (byte) flags >>k; //Flags wird explizit als Byte getypcasted und um k stellen nach rechts geshiftet. Im ersten Bit der Variable b steht daher die gesuchte 1 oder 0.
		System.out.println(b&1); //Die Bitmaske 1 wird auf b angewandt um nur die erste Stelle der Variable auszugeben.
	}

}


