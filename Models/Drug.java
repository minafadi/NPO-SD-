package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Drug {
    private int drugId;
    private String drugName;
    private String treatment;
    private int quantity;
    private double price;

    public Drug(String drugName,double price){
        this.drugName=drugName;
        this.price=price;
    }

    public Drug(String drugName, int quantity, double price, DBProxy dbProxy) {
        this.drugName = drugName;
        this.quantity = quantity;
        this.price = price;
//        try {
//            String sql = "INSERT INTO drug (name, quantity, price) VALUES (?, ?, ?)";
//            PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement(sql);
//            stmt.setString(1, this.drugName);
//            stmt.setInt(2, this.quantity);
//            stmt.setDouble(3, this.price);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String query = "INSERT INTO drug (name, quantity, price) VALUES ('" + this.drugName + "', " + this.quantity + ", " + this.price + ")";
        try {
            dbProxy.executeQuery(query);
        }
        catch (Exception e){

        }
    }

    public Drug(String drugName, int quantity, double price, String treatment, DBProxy dbProxy) {
        this.drugName = drugName;
        this.quantity = quantity;
        this.treatment = treatment;
        this.price = price;
//        try {
//            String sql = "INSERT INTO drug (name, quantity, price,treatment) VALUES (?, ?, ?,?)";
//            PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement(sql);
//            stmt.setString(1, this.drugName);
//            stmt.setInt(2, this.quantity);
//            stmt.setDouble(3, this.price);
//            stmt.setString(4, this.treatment);
//
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String query = "INSERT INTO drug (name, quantity, price, treatment) VALUES ('" + this.drugName + "', " + this.quantity + ", " + this.price + ", '" + this.treatment +"')";
        try{
            dbProxy.executeQuery(query);
        }
        catch (Exception e){

        }

    }

    public int getDrugId() {
        return drugId;
    }

    public static Drug readAllDrugs(String treatment, DBProxy dbProxy) {
//        try {
            // Query to select the drug where treatment matches

//            PreparedStatement selectStmt = DB.getInstance().getConnection().prepareStatement(selectSql);
//            selectStmt.setString(1, treatment); // Set the treatment parameter

//            // Execute the query and retrieve the results
//            ResultSet rs = selectStmt.executeQuery();
        String query = "SELECT id, name, quantity, price FROM drug WHERE Treatment = '" + treatment + "'";
        ResultSet resultSet = dbProxy.executeQuery(query);
        Drug drug;
        try {
            resultSet.next();
            drug = new Drug(resultSet.getString("name"), resultSet.getFloat("price"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to read drug!");
            return  null;
        }
        try {
            query = "UPDATE drug SET quantity = " + (resultSet.getInt("quantity") - 1) + " WHERE id = " + resultSet.getInt("id");
            dbProxy.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Failed to update stock!");
        }
        return drug;
        // If the drug exists, decrease its quantity by 1 and retrieve data
//            if (rs.next()) {
//                int drugId = rs.getInt("id");
//                String drugName = rs.getString("name");
//                int quantity = rs.getInt("quantity");
//                double price = rs.getDouble("price");
//
//                // Decrease the quantity by 1
//                if (quantity > 0) {
//                    quantity--;
//
//                    // Update the drug's quantity in the database
//                    String updateSql = "UPDATE drug SET quantity = ? WHERE id = ?";
//                    PreparedStatement updateStmt = DB.getInstance().getConnection().prepareStatement(updateSql);
//                    updateStmt.setInt(1, quantity);
//                    updateStmt.setInt(2, drugId);
//                    updateStmt.executeUpdate();
//                }
//
//                // Return the drug object (if needed)
//                return new Drug(drugName, price); // Assuming Drug has this constructor
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        // Return null if no matching drug is found
//        return null;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
