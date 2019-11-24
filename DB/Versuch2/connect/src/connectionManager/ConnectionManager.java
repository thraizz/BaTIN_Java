package connectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    Connection con;

    public ConnectionManager(String url) throws SQLException {
        try{
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (Exception e){
            System.out.println("Fehler beim laden des Treibers: "+ e.getMessage());
        }
        this.con = DriverManager.getConnection(url);
    }

    public Connection getConnection() {
        return this.con;
    }
}
