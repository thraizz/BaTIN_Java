import db.Kunde;

import java.io.*;
import java.sql.*;

public class Main {
    public static void main(String args[])throws IOException,SQLException{
        String url = "jdbc:postgresql://10.20.240.6:5432/dbprak?user=dbprak05&password=dbpassword";
        ConnectionManager con = new ConnectionManager(url);
        DBManager dbManager = new DBManager(con.getConnection());
        BufferedReader f = new BufferedReader(new FileReader("KUNDE.CSV"));
        CSVManager c = new CSVManager(f);

        String kundentable = "public.kunde";

        for (Kunde kunde: c.getKunden()) {
            //dbManager.insert(kundentable, kunde.getColNames(), kunde.getValues());
        }
        System.out.println(dbManager.selectAll(kundentable));
    }
}

