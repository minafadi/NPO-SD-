package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class Illness {
    protected String description;
    protected int Severity;
    //private String description;
    public int treatmentCost;
    private Duration duration;
    private boolean contagious;
    public double drugscost=0;

    private final List<Drug> drugList = new ArrayList<>();

    public double calculateCost(){return treatmentCost;}

    public  int severity(){return Severity;}

    public void addDrug(Drug drug) {
        drugList.add(drug);
        System.out.println("ketaaaaaaaafbs:        ");
       // System.out.println(getDrugscost());
       // System.out.println(drugList.size());
    }

    public Boolean removeDrug(Drug drug) {
        drugList.remove(drug);
        return true;
    }

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

    public boolean AddIllness(Patient patient) {

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

    public Boolean isContagious() {
        return contagious;
    }

    public void setContagious(boolean contagious) {
        this.contagious = contagious;
    }

    static public double getDrugscost(Drug[] drugList) {
        double totalCost = 0;
        for (Drug drug : drugList) {
            totalCost += drug.getPrice();
        }
        return totalCost;
    }

    public List<Drug> getDrugList() {

        return new ArrayList<>(drugList);
    }
    //public abstract int getSeverity();

    //public void setDrugList(List<Drug> drugList) {
    //    this.drugList = drugList;
    //}
}
