package Models;

import java.sql.*;

public class DB implements DBInterface{
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

    @Override
    public ResultSet executeQuery(String query){
        try {
            PreparedStatement statement = dbconn.prepareStatement(query);
            return statement.executeQuery(query);
        }
        catch (SQLException e){
            return null;
        }
    }

}
