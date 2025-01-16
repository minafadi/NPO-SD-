package Models;

import java.sql.ResultSet;

public interface DBInterface {
    public ResultSet executeQuery(String query);
}
