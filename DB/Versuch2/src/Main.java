import db.Kunde;

import java.io.*;
import java.sql.*;

public class Main {
    public static void main(String args[])throws IOException,SQLException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Benutzername:");
        //String user = in.readLine();
        //System.out.println("Passwort:");
        //String password = in.readLine();
        //String url = "jdbc:postgresql://feuerbach.nt.fh-koeln.de/postgres?user="+user+"&password="+password;
        String url = "jdbc:postgresql://feuerbach.nt.fh-koeln.de/postgres?user=dbprak05&password=Student33?";
        //String url = "jdbc:postgresql://10.20.240.6:5432/dbprak?user=dbprak05&password=dbpassword";
        ConnectionManager con = new ConnectionManager(url);
        DBManager dbManager = new DBManager(con.getConnection());
        BufferedReader f = new BufferedReader(new FileReader("KUNDE.CSV"));
        CSVManager c = new CSVManager(f);

        String kundentable = "kunde";
        String artikeltable = "artikel";
        String lagertable = "lager";
        String lagerbestandtable = "lagerbestand";
        int artnr;


        int choice = 0;
        do {
            System.out.println();
            System.out.println("Bitte waehlen:");
            System.out.println("(1) Alle Artikel anzeigen");
            System.out.println("(2) Alle Lager anzeigen");
            System.out.println("(3) Alle Lagerbestände anhand von Artikelnummer ermitteln");
            System.out.println("(4) Alle Kunden anzeigen");
            System.out.println("(5) WERT Spalte der Lagerbestände aktualisieren");
            System.out.println("(6) Stammdaten anzeigen");
            System.out.println("(7) Beenden");
            System.out.println("(11) Aufgabe 4: Kunden aus .CSV einfügen.");
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
                    System.out.println(dbManager.get("SELECT * FROM kunden"));
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
                    // Beenden
                    System.exit(0);
                case 11:
                    // AUFGABE 4
                    for (Kunde kunde: c.getKunden()) {
                        dbManager.insert(kundentable, kunde.getColNames(), kunde.getValues());
                    }
            }
        } while (choice != 0);
    }
}

