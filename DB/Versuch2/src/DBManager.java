import java.sql.Connection;

public class DBManager {
    private Connection connection;

    public DBManager(Connection connection){
        this.connection = connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void executeQuery(String query){

    }
}
