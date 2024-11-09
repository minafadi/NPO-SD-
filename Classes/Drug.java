package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Drug {
    private int drugId;
    private String drugName;
    private int quantity;
    private double price;
    static private Connection dbconn;

    public Drug(String drugName, int quantity, double price) {
        this.drugName = drugName;
        this.quantity = quantity;
        this.price = price;
        if(dbconn==null){
            DB db = new DB();
            this.dbconn = db.ConnectDB();
        }
        try {
            String sql = "INSERT INTO drug (name, quantity, price) VALUES (?, ?, ?)";
            PreparedStatement stmt = dbconn.prepareStatement(sql);
            stmt.setString(1, this.drugName);
            stmt.setInt(2, this.quantity);
            stmt.setDouble(3, this.price);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getDrugId() {
        return drugId;
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
