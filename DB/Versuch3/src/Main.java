import java.io.*;
import java.sql.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static void main(String args[])throws IOException,SQLException{
        try{
            Class.forName("org.postgresql.Driver").newInstance();
        }
        catch (Exception e){
            System.out.println("NICHT GEFUNDEN");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String url = "jdbc:postgresql://feuerbach.nt.fh-koeln.de/postgres?user=dbprak05&password=Student33?";
        ConnectionManager con = new ConnectionManager(url);
        DBManager dbManager = new DBManager(con.getConnection());
        LinkedList<Bpd> bpdispo = new LinkedList();


        String kundentable = "kunde";
        String artikeltable = "artikel";
        String lagertable = "lager";
        String lagerbestandtable = "lagerbestand";
        int artnr;


        int choice = 0;
        do {
            try{
                System.out.println();
                System.out.println("Bitte waehlen:");
                System.out.println("(1) Alle Artikel anzeigen");
                System.out.println("(2) Alle Lager anzeigen");
                System.out.println("(3) Alle Lagerbestände anhand von Artikelnummer ermitteln");
                System.out.println("(4) Alle Kunden anzeigen");
                System.out.println("(5) WERT Spalte der Lagerbestände aktualisieren");
                System.out.println("(6) Stammdaten anzeigen");
                System.out.println("(7) Bestellung hinzufügen");
                System.out.println("(8) Artikel einer Bestellung hinzufügen");
                System.out.println("(9) Bestellung auswählen.");
                System.out.println("(10) Aufgabe 4: Kunden aus .CSV einfügen.");
                System.out.println("(11) Aufgabe 4: Kunden aus .CSV einfügen.");
                System.out.println("(12) Aufgabe 4: Kunden aus .CSV einfügen.");
                System.out.println("(13) Aufgabe 4: Kunden aus .CSV einfügen.");
                System.out.println("(14) Aufgabe 4: Kunden aus .CSV einfügen.");

                System.out.println("(0) Beenden");
                choice = Integer.parseInt(in.readLine());
                System.out.println();

                switch (choice) {

                    case 1:
                        // Artikel anzeigen
                        System.out.println("Artikel in der Datenbank:");
                        System.out.println(dbManager.selectAll(artikeltable));
                        break;

                    case 2:
                        // Alle Lager anzeigen
                        System.out.println("Lager in der Datenbank:");
                        System.out.print(dbManager.selectAll(lagertable));
                        break;

                    case 3:
                        // Alle Lagerbestände für Lager finden
                        System.out.println("Bitte Lagernummer eingeben:");
                        int lagernr = Integer.parseInt(in.readLine());
                        System.out.println(dbManager.get("SELECT * FROM "+lagerbestandtable+" WHERE lnr = "+lagernr+";"));
                        System.out.println("Anzahl aller Artikel: "+dbManager.get("SELECT SUM(stuecke) FROM "+lagerbestandtable+" WHERE lnr = "+lagernr+";"));

                        break;

                    case 4:
                        // Anzeige aller Kunden
                        System.out.println("Artikel in der Datenbank:");
                        System.out.println(dbManager.get("SELECT * FROM kunde"));
                        System.out.println("ò_Ó");
                        break;

                    case 5:
                        // UPDATE für WERT Spalte der LAGERBESTAND Tabelle
                        dbManager.set("update lagerbestand set wert = artikel.preis * lagerbestand.stuecke from artikel where artikel.artnr = lagerbestand.artnr;");
                        break;
                    case 6:
                        // Stammdaten für Artikelnummer anzeigen
                        System.out.println("Bitte Artikelnummer eingeben:");
                        artnr = Integer.parseInt(in.readLine());
                        System.out.println(dbManager.get("select artikel.*, sum(stuecke) from artikel, lagerbestand as l where artikel.artnr = "+artnr+" and l.artnr = "+artnr+" group by artikel.artbez;"));
                        break;
                    case 7:
                        // Bestellung hinzufügen
                        System.out.println("Bitte Kundennummer eingeben:");
                        int knr = Integer.parseInt(in.readLine());
                        System.out.println("Bitte Bestelldatum eingeben:");
                        String bestdat = in.readLine();
                        dbManager.insert("bestellung","knr, bestdat", knr+",'"+bestdat+"'");
                        break;
                    case 8:
                        // Artikel einer Bestellung zuordnen
                        System.out.println("Bitte Bestellnummer eingeben:");
                        int bestnr = Integer.parseInt(in.readLine());
                        System.out.println("Bitte Artikelnummer eingeben:");
                        artnr = Integer.parseInt(in.readLine());
                        System.out.println("Bitte Menge eingeben:");
                        int menge = Integer.parseInt(in.readLine());
                        dbManager.reserveArticle(bestnr, artnr, menge);
                        break;
                    case 9:
                        // Stammdaten für Artikelnummer anzeigen
                        System.out.println(dbManager.get("select * from bestellung as b where b.status=1;"));
                        System.out.println("Bitte Bestellnummer eingeben:");
                        int bestellnr = Integer.parseInt(in.readLine());
                        bpdispo.add(dbManager.createBpd(bestellnr));
                        Collections.sort(bpdispo, new Comparator<Bpd>() {
                            @Override
                            public int compare(Bpd o1, Bpd o2) {
                                return o1.getAlgrad() - o2.getAlgrad();
                            }
                        });
                        break;
                    case 10:
                        System.out.println("Freie Boxen:");
                        System.out.println(dbManager.get("select * from box as b where b.vstat=0 \n" +
                                "order by (CASE vbtyp\n" +
                                "   WHEN 'FW' \t THEN 5\n" +
                                "   WHEN 'WP' \t THEN 4\n" +
                                "   WHEN 'FR' \t THEN 3\n" +
                                "   WHEN 'OR' THEN 2\n" +
                                "   ELSE 1 END) desc;"));
                        break;
                    case 11:
                        // AUFGABE 4
                        BufferedReader f = new BufferedReader(new FileReader("KUNDE.CSV"));
                        CSVManager c = new CSVManager(f);
                        for (Kunde kunde: c.getKunden()) {
                            try {
                                dbManager.insert(kundentable, kunde.getColNames(), kunde.getValues());
                            } catch(Exception e) {
                                System.out.println("Einfügen nicht erfolgreich: "+e);
                            }
                        }
                        System.out.println(c.getKunden().size()+" Kunden hinzugefügt");
                        break;
                    default:
                        System.exit(0);

                }
              }
              catch(Exception e){
                System.out.println("Keine gültige Eingabe");
              }
            } while (choice != 0);
    }
}
