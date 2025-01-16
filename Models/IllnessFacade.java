package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IllnessFacade {
    //This attribute to store data after declaring symptoms
    public static int pageCount=0;
    // Method to add illness to the database
    public boolean addIllness(Illness illness) {
        pageCount++;
        //This is for checking if it is after the symptoms declaration
        if(pageCount%2==0) {
            String sql = "INSERT INTO illness (description, severity, treatmentcost) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, illness.getDescription());
                stmt.setInt(2, illness.getSeverity());
                stmt.setDouble(3, illness.calculateCost());

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    // Retrieve the generated IID
                    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int illnessId = generatedKeys.getInt(1);
                            illness.setIllnessId(illnessId); // Set the illness ID for further use
                            return true;
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
        return false;
    }

    // Method to associate an illness with a patient
    public boolean linkIllnessToPatient(Patient patient, Illness illness) {
        if (illness.getIllnessId() == 0) {
            throw new IllegalStateException("Illness must be added to the database before linking to a patient.");
        }

        String sql = "INSERT INTO PatientIllness (PID, IID) VALUES (?, ?)";
        try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement(sql)) {
            stmt.setInt(1, patient.getId());
            stmt.setInt(2, illness.getIllnessId());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Facade method to add illness and link it to a patient
    public boolean addIllnessToPatient(Patient patient, Illness illness) {
        if (addIllness(illness)) {
            return linkIllnessToPatient(patient, illness);
        }
        return false;
    }
}