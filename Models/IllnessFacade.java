package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IllnessFacade {
    //This attribute to store data after declaring symptoms
    public static int pageCount=0;
    // Method to add illness to the database
    public boolean addIllness(Illness illness, DBProxy dbProxy) {
        pageCount++;
        //This is for checking if it is after the symptoms declaration
        if(pageCount%2==0) {
            String sql = "INSERT INTO illness (description, severity, treatmentcost) VALUES ('" + illness.getDescription() + "', " + illness.getSeverity() + ", " + (int) illness.calculateCost() + ")";
            dbProxy.executeQuery(sql);
            sql = "SELECT * FROM illness WHERE description = '" + illness.getDescription() + "' AND severity = " + illness.getSeverity() + " AND treatmentcost = " + (int) illness.calculateCost();
            ResultSet resultSet = dbProxy.executeQuery(sql);

            try {
                resultSet.next();
                illness.setIllnessId(resultSet.getInt(1));
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }

        }
        return false;
    }

    // Method to associate an illness with a patient
    public boolean linkIllnessToPatient(Patient patient, Illness illness, DBProxy dbProxy) {
        if (illness.getIllnessId() == 0) {
            throw new IllegalStateException("Illness must be added to the database before linking to a patient.");
        }

        String sql = "INSERT INTO PatientIllness (PID, IID) VALUES (" + patient.getId() + ", " + illness.getIllnessId() + ")";
        ResultSet resultSet = dbProxy.executeQuery(sql);
        try{
            resultSet.next();
            return (resultSet!=null);

        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Facade method to add illness and link it to a patient
    public boolean addIllnessToPatient(Patient patient, Illness illness, DBProxy dbProxy) {
        if (addIllness(illness, dbProxy)) {
            return linkIllnessToPatient(patient, illness, dbProxy);
        }
        return false;
    }
}