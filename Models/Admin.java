package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin extends User{

    public Admin(){

    }

    public static boolean AuthenticateAdmin(String name,String password){
        String query = "SELECT COUNT(*) FROM admin WHERE name = ? AND password = ?";

        try (PreparedStatement statement = DB.getInstance().getConnection().prepareStatement(query)) {
            // Set query parameters
            statement.setString(1, name);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
