import java.sql.*;

public class ConnectionManager {
    Connection con;

    public ConnectionManager(String url) throws SQLException{
        // Treiber laden
        try{
            Class.forName("postgresql-42.2.8.jar").newInstance();
        } catch (Exception e){
            System.out.println("Fehler beim laden des Treibers: "+ e.getMessage());
        }
        // Erstellung Datenbank-Verbindungsinstanz
        this.con = DriverManager.getConnection(url);
    }

    public Connection getConnection() {
        return this.con;
    }
}
