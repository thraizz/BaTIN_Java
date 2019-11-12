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

    private String getHeader(ResultSet r, ResultSetMetaData rd) throws SQLException {
        StringBuilder row = new StringBuilder();
        int columnCount = rd.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
                row.append(String.format("| %-35s", rd.getColumnLabel(i)));
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
            row.append(getHeader(rs, rd));
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
}
