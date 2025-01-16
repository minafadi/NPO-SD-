package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class Illness {
    protected String description;
    protected int Severity;
    protected int treatmentCost;
    private Duration duration;
    private boolean contagious;
    public double drugsCost = 0;

    private final List<Drug> drugList = new ArrayList<>();

    // Template Design Pattern for defining the skeleton of the treatment process.
    public final void treatIllness(Patient patient) {
        diagnose(); // For Diagnose the illness
        prescribeDrugs(); // For Prescribe of drugs
        calculateTreatmentCost(); // Calculate treatment cost
        addIllnessToPatient(patient); // Add illness to the patient record in the database
    }

    // Abstract methods to be implemented by subclasses illnesses
    protected abstract void diagnose();
    protected abstract void prescribeDrugs();
    protected abstract double calculateTreatmentCost();

    // Concrete method to add illness to the patient's record
    public final boolean addIllnessToPatient(Patient patient) {

        System.out.print("Drugs associated with illness:");
        for (Drug drug : patient.getIllness().getDrugList()) {
            System.out.println(drug.getDrugName());
        }

        // Insert into Illness table
        String sql = "INSERT INTO illness (description, severity, treatmentcost) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, this.getDescription()); // `description` attribute
            stmt.setInt(2, this.getSeverity());       // `severity` attribute
            stmt.setDouble(3, this.calculateCost());  // `treatmentCost` attribute

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                // Retrieve generated IID
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int illnessId = generatedKeys.getInt(1);

                        // Insert into PatientIllness table
                        String patientIllnessSql = "INSERT INTO PatientIllness (PID, IID) VALUES (?, ?)";
                        try (PreparedStatement patientIllnessStmt = DB.getInstance().getConnection().prepareStatement(patientIllnessSql)) {
                            patientIllnessStmt.setInt(1, patient.getId()); // patient ID (PID)
                            patientIllnessStmt.setInt(2, illnessId);       // illness ID (IID)

                            int patientIllnessRowsInserted = patientIllnessStmt.executeUpdate();
                            return patientIllnessRowsInserted > 0; // Returns true if the row was inserted successfully
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    //For subclasses of symptoms
    public double calculateCost(){return treatmentCost;}

    //For subclasses of symptoms
    public  int severity(){return Severity;}

    //For subclasses of symptoms
    public void addDrug(Drug drug) {
        drugList.add(drug);
    }

    public Boolean removeDrug(Drug drug) {
        drugList.remove(drug);
        return true;
    }

    //For subclasses of symptoms
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(int treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    //For class Symptom
    public Duration getDuration() {
        return duration;
    }

    public Boolean setDuration(Duration duration) {
        this.duration = duration;
        return true;
    }

    public int getSeverity(){
        return severity();
    }

    //For class of Symptoms
    public boolean isContagious() {
        return contagious;
    }

    public void setContagious(boolean contagious) {
        this.contagious = contagious;
    }

    static public double getDrugsCost(Drug[] drugList) {
        double totalCost = 0;
        for (Drug drug : drugList) {
            totalCost += drug.getPrice();
        }
        return totalCost;
    }

    //For class of Symptoms
    public List<Drug> getDrugList() {
        return new ArrayList<>(drugList);
    }

}
