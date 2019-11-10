import java.sql.*;

public class DBManager {
    private Connection connection;

    public DBManager(Connection connection){
        this.connection = connection;
    }

    public void insert(String tablename, String colNames, String values) {
        Statement stmt;
        String SQL;
        try {
            stmt = this.connection.createStatement();
            SQL = "INSERT INTO "+tablename+" ("+colNames+") VALUES ("+values+");";
            stmt.executeUpdate(SQL);
            stmt.close();
        }
        catch (SQLException e){
            System.out.println("[!] Fehler bei INSERT-Statement "+e.getMessage());
        }
    }

    public String selectAll(String tablename){
        String row = "";
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tablename);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            final int columnCount = resultSetMetaData.getColumnCount();
            while(rs.next()){
                for (int i = 1; i <= columnCount; i++) {
                    row += rs.getString(i)+"\t";
                }
                row += "\n";
            }
        }
        catch (SQLException e){
            System.out.println("[!] Fehler bei SELECT-Statement: "+e.getMessage());
        }
        return row;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
