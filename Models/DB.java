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
    public ResultSet executeQuery(String query) {
        try {
            PreparedStatement statement;
            if (query.startsWith("INSERT")) {
                // Prepare statement with RETURN_GENERATED_KEYS for INSERT
                statement = getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                statement.executeUpdate();
                // Return the generated keys
                return statement.getGeneratedKeys();
            } else if (query.startsWith("SELECT")) {
                // Prepare and execute SELECT statement
                statement = getInstance().getConnection().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE);
                return statement.executeQuery();
            } else {
                // Prepare and execute other types of queries
                statement = getInstance().getConnection().prepareStatement(query);
                statement.executeUpdate();
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



}
