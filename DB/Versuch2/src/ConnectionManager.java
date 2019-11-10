import java.sql.*;

public class ConnectionManager {
    Connection con;

    public ConnectionManager(String url) throws SQLException{
        this.con = DriverManager.getConnection(url);
    }

    public Connection getConnection() {
        return this.con;
    }
}
