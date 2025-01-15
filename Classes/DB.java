package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    String url = "jdbc:mysql://localhost:3306/hospitaldb";
    String username = "root";
    String password = "";
    private static DB instance;
    private Connection dbconn;
    private DB() throws SQLException {
        dbconn = DriverManager.getConnection(url,username,password);
    }

    public static DB getInstance() throws SQLException {
        if(instance == null)instance = new DB();
        return instance;
    }
    public Connection getConnection(){return dbconn;}
}
