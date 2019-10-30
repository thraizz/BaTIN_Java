import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Datenverwaltung d = new Datenverwaltung();
        

        int choice = 0;

        do {
            System.out.println();
            System.out.println("Bitte waehlen:");
            System.out.println("(1) Artikel hinzufuegen");
            System.out.println("(2) Alle Artikel anzeigen");
            System.out.println("(3) Artikel anhand von Artikelnummer finden");
            System.out.println("(4) Speichern und beenden");
            choice = Integer.parseInt(in.readLine());
            System.out.println();

            switch (choice) {

                case 1:
                    // Artikel hinzufuegen
                    System.out.println("Artikelnummer:");
                    int artnr = Integer.parseInt(in.readLine());
                    System.out.println("Artikelbezeichnung:");
                    String artbez = in.readLine();
                    System.out.println("Mengenbezeichnung:");
                    String mge = in.readLine();
                    System.out.println("Preis (float):");
                    float preis = Float.parseFloat(in.readLine());
                    System.out.println("Steuer (float):");
                    float steu = Float.parseFloat(in.readLine());
                    Artikel art = new Artikel(artnr,artbez,mge,preis,steu);
                    d.addArtikel(art);
                    break;
                case 2:
                    // Alle Artikel anzeigen
                    for(String s : d.getAllArtikel()){
                        System.out.println(s);
                    }
                    break;

                case 3:
                    // Artikel anhand von Artikelnummer finden
                    for(String s : d.getAllIndex()){
                        System.out.println(s);
                    }
                    System.out.println(" Wählen Sie eine Artikelnummer:");
                    String result = d.getArtikel(Integer.parseInt(in.readLine()));
                    System.out.println(result);
                    break;

                case 4:
                    // Speichern
                    d.saveExit();
                    exit(0);
                    break;
            }
        } while (choice != 0);
    }

}
