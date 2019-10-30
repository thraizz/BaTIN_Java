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
                        System.out.print(s);
                    }
                    break;

                case 3:
                    // Artikel anhand von Artikelnummer finden
                    System.out.println("Aktuelle Indexliste:");
                    for(String s : d.getAllIndex()){
                        System.out.print(s);
                    }
                    System.out.println();
                    int i;
                    do {
                        System.out.println("Wählen Sie eine Artikelnummer:");
                        i = Integer.parseInt(in.readLine());
                    } while (i<0);
                    String result = d.getArtikel(i);
                    System.out.println(result);
                    break;

                case 4:
                    // Speichern
                    d.save();
                    exit(0);
                    break;
            }
        } while (choice != 0);
    }

}
