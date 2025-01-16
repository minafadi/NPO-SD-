package Models;

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
            return db.executeQuery(query);
        }
        else if (query.contains("INSERT") && (query.contains("drug") || query.contains("doctor") || query.contains("admin"))){
            return null;
        }
        else {
            return db.executeQuery(query);
        }
    }
}
