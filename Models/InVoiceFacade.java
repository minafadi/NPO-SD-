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
            return resultSet.getInt(1); // Return the generated invoice ID
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
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
        return true;  // Return true if all drugs were successfully added
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
