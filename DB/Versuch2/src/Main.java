import db.Kunde;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String args[])throws IOException,SQLException{
        String url;
        url = "jdbc:postgresql://10.20.240.6:5432/?user=dbprak05&password=dbpassword";
        ConnectionManager con = new ConnectionManager(url);
        DBManager dbManager = new DBManager(con.getConnection());
        CSVManager c = new CSVManager("KUNDE.CSV");
        ArrayList<Kunde> k = c.getKunden();


        Statement Stmt;
        ResultSet RS;

        Stmt = con.getConnection().createStatement();

        for (Kunde kunde: c.getKunden()) {
            Stmt.executeQuery(kunde.getInsert());

        }
    }
}

