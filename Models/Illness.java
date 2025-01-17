package Models;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class Illness {
    protected String description;
    protected int Severity;
    protected int treatmentCost;
    private Duration duration;
    private boolean contagious;
    protected int illnessId;
    public double drugsCost = 0;

    private final List<Drug> drugList = new ArrayList<>();

    // Template Design Pattern for defining the skeleton of the treatment process.
    public final void treatIllness(Patient patient, DBProxy dbProxy) {
        prescribeDrugs(); // For Prescribe of drugs
        calculateTreatmentCost(); // Calculate treatment cost
        addIllnessToPatient(patient, dbProxy); // Add illness to the patient record in the database
    }

    // Abstract methods to be implemented by subclasses illnesses
    protected abstract void prescribeDrugs();
    protected abstract double calculateTreatmentCost();

    // Concrete method to add illness to the patient's record
    public final boolean addIllnessToPatient(Patient patient, DBProxy dbProxy) {
//        for (Drug drug : this.getDrugList()) {
//            System.out.println(drug.getDrugName());
//        }

        // Use IllnessFacade to handle the operation
        IllnessFacade illnessFacade = new IllnessFacade();
        return illnessFacade.addIllnessToPatient(patient, this, dbProxy);
    }

    //For subclasses of symptoms
    public double calculateCost(){
        return treatmentCost;
    }

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

    public int getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(int illnessId) {
        this.illnessId = illnessId;
    }
}
