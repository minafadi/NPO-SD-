package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBProxy implements DBInterface {
    public DB db;
    public boolean isAdmin;

    public DBProxy(int type) {
        if (type == 1) isAdmin = true;
        else isAdmin = false;
        try {
            this.db = DB.getInstance();
        } catch (SQLException e){}
    }

    @Override
    public ResultSet executeQuery(String query) {
        if (isAdmin){
            System.out.println("Admin");
            return db.executeQuery(query);
        }
        else if ((query.contains("INSERT") && (query.contains("drug ") || query.contains("doctor") || query.contains("admin"))) || query.contains("DELETE")){
            System.out.println("denied");
            return null;
        }
        else {
            return db.executeQuery(query);
        }
    }
}
