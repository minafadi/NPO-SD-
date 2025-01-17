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

    public static void deleteDoctor(int id) {
        String query = "DELETE FROM doctor WHERE id = " + id;
        try {
            ResultSet rowsAffected = db.executeQuery(query);
        } catch (Exception e) {
            System.err.println("Error while deleting Doctor: " + e.getMessage());
        }
    }
    public static void deleteDrug(String name) {
        String query = "DELETE FROM drug WHERE name = '" + name + "'";
        try {
            ResultSet rowsAffected = db.executeQuery(query);
        } catch (Exception e) {
            System.err.println("Error while deleting Drug: " + e.getMessage());
        }
    }
    public static void deleteApp(int id) {
        String query = "DELETE FROM appointment WHERE id = " + id;
        try {
            ResultSet rowsAffected = db.executeQuery(query);
        } catch (Exception e) {
            System.err.println("Error while deleting App: " + e.getMessage());
        }
    }
}
