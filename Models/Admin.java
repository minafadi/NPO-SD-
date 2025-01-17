package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin extends User{
    private static DBProxy db = new DBProxy(1);
    public Admin(){
    }

    public static boolean AuthenticateAdmin(String name,String password){
        String query = "SELECT COUNT(*) FROM admin WHERE name = '" + name + "' AND password = '" + password + "'";
        System.out.println(query);
        try{
            ResultSet resultSet = db.executeQuery(query);
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
