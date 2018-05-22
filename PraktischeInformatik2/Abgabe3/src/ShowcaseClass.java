import java.io.*;
public class ShowcaseClass {
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String antwort;


		System.out.println("Welchen Typ soll das generische Array haben?");
		do{
			antwort = in.readLine();
		}while(!antwort.equals("int") && !antwort.equals("double")); 

		if(antwort.equals("int")) {
			System.out.println("Laenge der Liste?");
			ArrayGList<Integer> gObj = new ArrayGList<>(Integer.parseInt(in.readLine()));
			
			int choice = 0;
			do {
				System.out.println();
				System.out.println("Bitte waehlen:");
				System.out.println("(1) Laenge anzeigen ");
				System.out.println("(2) Wert am Ende einfügen");
				System.out.println("(3) Ersten Wert anzeigen");
				System.out.println("(4) Ersten Wert löschen");
				System.out.println("(5) Wert suchen");
				System.out.println("(6) Liste ausgeben");
				System.out.println("(0) Ende");
				choice = Integer.parseInt(in.readLine());
				System.out.println();

				switch (choice) {

				case 1:
					System.out.println("Die Länge beträgt "+gObj.getLength());
					break;
				case 2:
					System.out.println("Wert eingeben:");
					gObj.insertLast(Integer.parseInt(in.readLine()));
					break;

				case 3:
					System.out.println("Erster Wert: "+gObj.getFirst());
					break;

				case 4:
					System.out.println("Erster Wert "+gObj.getFirst()+" wird gelöscht.");
					gObj.deleteFirst();
					break;
					
				case 5:
					System.out.println("Welcher Wert soll gesucht werden?");
					gObj.search(Integer.parseInt(in.readLine()));
					break;
				
				case 6:
					gObj.print();
					break;
					
				case 7:
					
					System.out.println("Laenge?:");
					Integer[] testArray=new Integer[Integer.parseInt(in.readLine())];
					for(int i=0;i<testArray.length;i++) {
						System.out.println("Stelle "+i+" eingeben:");
						testArray[i]=Integer.parseInt(in.readLine());
					}
					System.out.println("Das "+antwort+" Array wird hinzugefügt.");
					gObj.append(testArray);
					
					
				}
			} while (choice != 0);
		}
		if(antwort.equals("double")) {
			System.out.println("Laenge der Liste?");
			ArrayGList<Double> gObj = new ArrayGList<>(Integer.parseInt(in.readLine()));

			int choice = 0;
			do {
				System.out.println();
				System.out.println("Bitte waehlen:");
				System.out.println("(1) Laenge anzeigen ");
				System.out.println("(2) Wert am Ende einfügen");
				System.out.println("(3) Ersten Wert anzeigen");
				System.out.println("(4) Ersten Wert löschen");
				System.out.println("(5) Wert suchen");
				System.out.println("(6) Liste ausgeben");
				System.out.println("(0) Ende");
				choice = Integer.parseInt(in.readLine());
				System.out.println();

				switch (choice) {

				case 1:
					System.out.println("Die Länge beträgt "+gObj.getLength());
					break;
				case 2:
					System.out.println("Wert eingeben:");
					gObj.insertLast(Double.parseDouble(in.readLine()));
					break;

				case 3:
					System.out.println("Erster Wert: "+gObj.getFirst());
					break;

				case 4:
					System.out.println("Erster Wert "+gObj.getFirst()+" wird gelöscht.");
					gObj.deleteFirst();
					break;
					
				case 5:
					System.out.println("Welcher Wert soll gesucht werden?");
					gObj.search(Double.parseDouble(in.readLine()));
					break;
				
				case 6:
					gObj.print();
					break;
					
					
				}
			} while (choice != 0);
			
		}
		
	}

}
