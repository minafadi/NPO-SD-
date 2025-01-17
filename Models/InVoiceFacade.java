package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InVoiceFacade {

    // Method to insert an invoice into the database
    public int addInvoice(String patientName, String doctorName, double total, DBProxy dbProxy) {
        String invoiceQuery = "INSERT INTO invoice (pname, dname, total) VALUES ('" + patientName + "', '" + doctorName + "', " + (int) total + ")";
        dbProxy.executeQuery(invoiceQuery);
        invoiceQuery = "SELECT * FROM invoice WHERE pname = '" + patientName + "' AND dname = '" + doctorName + "' AND total = " + (int) total;
        ResultSet resultSet = dbProxy.executeQuery(invoiceQuery);
        try{
            resultSet.next();
            return resultSet.getInt(1);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
//        try (PreparedStatement invoiceStmt = DB.getInstance().getConnection().prepareStatement(invoiceQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
//            // Set parameters for the invoice
//            invoiceStmt.setString(1, patientName);
//            invoiceStmt.setString(2, doctorName);
//            invoiceStmt.setDouble(3, total);
//
//            // Execute the query
//            int rowsInserted = invoiceStmt.executeUpdate();
//            if (rowsInserted > 0) {
//                // Retrieve the generated invoice ID
//                try (ResultSet generatedKeys = invoiceStmt.getGeneratedKeys()) {
//                    if (generatedKeys.next()) {
//                        return generatedKeys.getInt(1); // Return the generated invoice ID
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        return -1; // Return -1 if the operation failed
    }

    // Method to link drugs to an invoice in the database
    public boolean addDrugsToInvoice(int invoiceId, Drug[] drugs,DBProxy dbProxy) {
        String invDrugsQuery = "INSERT INTO invdrugs (IId, Drugname) VALUES (" + invoiceId + ", ";
        String query;
        for (Drug drug : drugs){
            query = invDrugsQuery + "'" + drug.getDrugName() +"')";
            try{
                dbProxy.executeQuery(query);
            } catch (Exception e){
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
//        try (PreparedStatement invDrugsStmt = DB.getInstance().getConnection().prepareStatement(invDrugsQuery)) {
//            for (Drug drug : drugs) {
//                invDrugsStmt.setInt(1, invoiceId); // Set the foreign key (invoice ID)
//                invDrugsStmt.setString(2, drug.getDrugName()); // Set the drug name
//                invDrugsStmt.executeUpdate();
//            }
//            return true; // Return true if all drugs were successfully added
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return false; // Return false if the operation failed
    }

    // Facade method to add an invoice and link its drugs
    public boolean createInvoice(String patientName, String doctorName, Drug[] drugs, double total, DBProxy dbProxy) {
        int invoiceId = addInvoice(patientName, doctorName, total, dbProxy); // Add the invoice
        if (invoiceId != -1) {
            return addDrugsToInvoice(invoiceId, drugs, dbProxy); // Link the drugs to the invoice
        }
        return false; // Return false if the invoice creation or drug linking failed
    }
}
