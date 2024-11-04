import java.util.ArrayList;
import java.util.List;

public abstract class Illness {
    private  String description;
    private int TreatmentCost;
    private  int Severity;
    private int Duration;
    private boolean Contagious;
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
        return TreatmentCost;
    }

    public void setTreatmentCost(int TreatmentCost) {
        this.TreatmentCost = TreatmentCost;
    }

    public int getSeverity() {
        return Severity;
    }

    public void setSeverity(int Severity) {
        this.Severity = Severity;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    public boolean isContagious() {
        return Contagious;
    }

    public void setContagious(boolean Contagious) {
        this.Contagious = Contagious;
    }

    public List<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<Drug> drugList) {
        this.drugList = drugList;
    }
}
