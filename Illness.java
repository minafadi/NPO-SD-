import java.util.ArrayList;
import java.util.List;

public abstract class Illness {
    private String description;
    private int treatmentCost;
    private int severity;
    private int duration;
    private boolean contagious;
    private List<Drug> drugList = new ArrayList<>();

    public abstract double calculateCost();

    public Boolean isDrugAvailable(Drug drug) {
        return drugList.contains(drug);
    }

    public double getDrugPrice(Drug drug) {
        return drugList.get(drugList.indexOf(drug)).getPrice();
    }

    public Boolean addDrug(Drug drug) {
        drugList.add(drug);
        return true;
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

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isContagious() {
        return contagious;
    }

    public void setContagious(boolean contagious) {
        this.contagious = contagious;
    }

    public List<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<Drug> drugList) {
        this.drugList = drugList;
    }
}
