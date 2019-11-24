package manager;

import java.sql.*;

public class DBManager {
    private Connection connection;

    public DBManager(Connection connection) {
        this.connection = connection;
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
        String query = "select * from lagerbestand as l where l.artnr = '"+artnr+"';";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rd = rs.getMetaData();
        while (rs.next()) {
            int bestand = rs.getInt(1);
            if(menge < bestand){
                int diff = bestand-menge;
                String newRow = (""+rs.getInt(2)+","+rs.getInt(3)+","+diff+","+rs.getFloat(5));
                this.insert("lagerbestand", "artnr,lnr,stuecke,wert", newRow);
                System.out.println("Artikel erfolgreich bestellt.");
                // Lagerbestand mit der bestandnummer n aktualisieren so dass dort die bestellung reserviert liegt
                this.set("update lagerbestand set stuecke="+menge+", bestnr="+bestnr+", where bstnr="+rs.getInt(1));
                return;
            }
        }
        System.out.println("Artikel nicht ausreichend verfügbar.");
    }
}
