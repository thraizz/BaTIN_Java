package com.datenbanken.versuch3;
import java.sql.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;

public class DBManager {
    private Connection connection;
    private ArrayList<Box> boxArrayList;
    private ArrayList<Dictionary> packliste;

    public DBManager(Connection connection) {
        this.connection = connection;
        this.boxArrayList = new ArrayList<Box>();
        this.packliste = new ArrayList<Dictionary>();
    }

    private String getData(ResultSet r, ResultSetMetaData rd) throws SQLException{
        StringBuilder row = new StringBuilder();
        int columnCount = rd.getColumnCount();
        if(columnCount==1){
            r.next();
            return r.getString(1);
        }
        while (r.next()) {
            for (int i = 1; i <= columnCount; i++) {
                row.append(String.format("| %-35s", r.getString(i)));
            }
            row.append("\n");
        }
        return row.toString();
    }

    private String getHeader(ResultSetMetaData resultSetMetaData) throws SQLException {
        StringBuilder row = new StringBuilder();
        int columnCount = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            row.append(String.format("| %-35s", resultSetMetaData.getColumnLabel(i)));
        }

        row.append("\n------------------------------------------------------------------------------------------" +
                "-----------------------------------------------------------------------\n");
        return row.toString();
    }

    public void insert(String tablename, String colNames, String values) throws SQLException {
        Statement stmt;
        stmt = this.connection.createStatement();
        stmt.executeUpdate("INSERT INTO " + tablename + " (" + colNames + ") VALUES (" + values + ");");
    }

    public String get(String query) throws SQLException {
        StringBuilder row = new StringBuilder();
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rd = rs.getMetaData();
        if(rd.getColumnCount()>1){
            row.append(getHeader(rd));
        }
        row.append(getData(rs, rd));
        return row.toString();
    }
    public void set(String query) throws SQLException {
        StringBuilder row = new StringBuilder();
        Statement stmt = this.connection.createStatement();
        int status = stmt.executeUpdate(query);
        if(status == -1){
            System.out.println("UPDATE fehlgeschlagen: "+status);
        }
        else{
            System.out.println("UPDATE erfolgreich; "+status+" Reihen aktualisiert.");
        }
    }


    public String selectAll(String tablename) throws SQLException {
        return get("SELECT * FROM " + tablename);
    }

    public void reserveArticle(int bestnr, int artnr, int menge) throws SQLException {
        String query = "select * from lagerbestand as l where l.artnr = "+artnr+";";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rd = rs.getMetaData();
        while (rs.next()) {
            int bestand = rs.getInt(3);
            if(menge <= bestand){
                int diff = bestand-menge;
                String newRow = (""+rs.getInt(2)+","+rs.getInt(3)+","+diff+","+rs.getFloat(5));
                this.insert("lagerbestand", "artnr,lnr,stuecke,wert", newRow);
                System.out.println("Artikel erfolgreich bestellt.");
                // Lagerbestand mit der bestandnummer n aktualisieren so dass dort die bestellung reserviert liegt
                this.set("update lagerbestand set stuecke="+menge+", bestnr="+bestnr+" where bstnr="+rs.getInt(6));
                return;
            }
        }
        System.out.println("Artikel nicht ausreichend verfügbar.");
    }

    public Bpd createBpd(int bestellnr) throws SQLException {
        int artnr = Integer.parseInt(get("select artnr from lagerbestand l where l.bestnr = "+bestellnr+";"));
        String artbez = get("SELECT artbez from artikel where artnr ="+artnr+";");
        int bstnr = Integer.parseInt(get("select bstnr from lagerbestand l where l.bestnr ="+bestellnr+";"));
        int anzbo = Integer.parseInt(get("select anzbo from artikel a where a.artnr ="+artnr));
        int menge = Integer.parseInt(get("select stuecke from lagerbestand where lagerbestand.bestnr = +"+bestellnr));
        String ttyp = get("select ttyp from artikel where artikel.artnr = "+artnr+";");
        return new Bpd(bstnr, ttyp, artnr, artbez, anzbo, menge, false);
    }

    public void getBoxen() throws SQLException {
        if(boxArrayList.isEmpty()) {
            String query = "select vbnr, vbtyp from box where vstat=0;";
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                boxArrayList.add(new Box(rs.getInt(1), rs.getString(2)));
            }
        }
    }

    public void maschinelleDisposition(LinkedList<Bpd> bpdispo) throws SQLException {
        this.getBoxen();
        for (Box box: boxArrayList) {
            System.out.println("Checke box "+box.vbnr);
            for (Bpd b : bpdispo) {
                System.out.println("Checke bpd "+b.getArtbez()+" mit algrad "+b.getAlgrad());
                if (b.getTtyp()<=box.vbtyp ) {
                    if(b.getAlgrad() < 100 && b.getAlgrad() < box.R){
                        System.out.println("Bpd "+b.getArtbez()+" wurde verpackt.");
                        box.R = box.R - b.getAlgrad();
                        b.setVerpackt(true);
                        Dictionary d = new Hashtable();
                        d.put("bstnr", b.getBstnr());
                        d.put("vbnr", box.vbnr);
                        d.put("vmenge", b.getMenge());
                        packliste.add(d);
                        bpdispo.remove(b);
                    }
                    else{
                        int anzBOX = b.getAlgrad()/100+1;
                        System.out.println("Bpd "+b.getArtbez()+" war zu groß und wird weiterverpackt.");
                        b.setAlgrad(b.getAlgrad()-100);

                    }
                }
            }
        }
        if(!bpdispo.isEmpty()){
            System.out.println("ERROR! Es gab nicht genug Boxen zum verpacken aller Bestellungsdispositionen.");
        }
    }

    public String printBoxen() throws SQLException {
        return this.get("select * from box as b where b.vstat=0 \n" +
                "order by (CASE vbtyp\n" +
                "   WHEN 'FW' \t THEN 5\n" +
                "   WHEN 'WP' \t THEN 4\n" +
                "   WHEN 'FR' \t THEN 3\n" +
                "   WHEN 'OR' THEN 2\n" +
                "   ELSE 1 END) desc;");
    }
}
