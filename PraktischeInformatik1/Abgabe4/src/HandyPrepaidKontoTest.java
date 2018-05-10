import java.io.*;



public class HandyPrepaidKontoTest {
	public double guthaben;

 public static void main(String args[]) throws IOException {

	 HandyPrepaidKonto TestKonto = new HandyPrepaidKonto();
    
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  int choice = 0;
  
  do {
  
    System.out.println();
    System.out.println("Bitte waehlen:");
    System.out.println("(1) Konto aufladen");
    System.out.println("(2) SMS abbuchen");
    System.out.println("(3) Gespraech abbuchen");
    System.out.println("(4) Guthaben abfragen");
    System.out.println("(5) Verbleibende SMS abfragen");
    System.out.println("(6) Verbleibende Gespr.sekunden abfragen");
    System.out.println("(0) Ende");
    choice = Integer.parseInt(in.readLine());
    System.out.println();

    switch (choice) {
    
      case 1:
        System.out.print("Aufladestufe? (1 = 2 Euro / 2 = 5 Euro / 3 = 10 Euro) ");
       int stufe = Integer.parseInt(in.readLine());
       TestKonto.aufladen(stufe);
       break;

      case 2:
       if(TestKonto.SmsAbbuchen()) {System.out.println("Erfolg!"); break;}
       else {System.out.println("Abbuchung nicht möglich."); break;}

      case 3:
       System.out.print("Gespr.dauer in Sekunden? ");
       int sekunden = Integer.parseInt(in.readLine());
       if(TestKonto.GespraechAbbuchen(sekunden)) {System.out.println("Erfolg!"); break;}
       else {System.out.println("Abbuchung nicht möglich."); break;}

      case 4:
       System.out.println(TestKonto.GuthabenAbfragen());;
       break;

      case 5:
       System.out.println(TestKonto.VerbleibendeSms());
       break;

      case 6:
       System.out.println(TestKonto.VerbleibendeGespraechssekunden());
       break;

    }

  } while (choice!=0);

 }
 
}