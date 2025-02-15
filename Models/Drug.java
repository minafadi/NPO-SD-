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
        insertdrugtodb(drugName,quantity,price,dbProxy);
    }

    public Drug(String drugName, int quantity, double price, String treatment, DBProxy dbProxy) {
        this.drugName = drugName;
        this.quantity = quantity;
        this.treatment = treatment;
        this.price = price;
        insertdrugtodbwithtreatment(drugName,quantity,price,treatment,dbProxy);

    }

    public int getDrugId() {
        return drugId;
    }

    public void insertdrugtodb(String drugName, int quantity, double price, DBProxy dbProxy){
        String query = "INSERT INTO drug (name, quantity, price) VALUES ('" + this.drugName + "', " + this.quantity + ", " + this.price + ")";
        try {
            dbProxy.executeQuery(query);
        }
        catch (Exception e){

        }
    }

    public void insertdrugtodbwithtreatment(String drugName, int quantity, double price, String treatment, DBProxy dbProxy){
        String query = "INSERT INTO drug (name, quantity, price, treatment) VALUES ('" + this.drugName + "', " + this.quantity + ", " + this.price + ", '" + this.treatment +"')";
        try{
            dbProxy.executeQuery(query);
        }
        catch (Exception e){

        }
    }
    public static Drug readAllDrugs(String treatment, DBProxy dbProxy) {
        String query = "SELECT * FROM drug WHERE Treatment = '" + treatment + "'";
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
