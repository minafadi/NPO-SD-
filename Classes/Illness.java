package Classes;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class Illness {
    private String description;
    private int treatmentCost;
    private Duration duration;
    private boolean contagious;
    private List<Drug> drugList = new ArrayList<>();

    public abstract double calculateCost();

    public abstract int severity();

    public boolean isDrugAvailable(Drug drug) {
        return drugList.contains(drug);
    }

    public double getDrugPrice(Drug drug) {
        return drugList.get(drugList.indexOf(drug)).getPrice();
    }

    public boolean addDrug(Drug drug) {
        drugList.add(drug);
        return true;
    }

    public boolean removeDrug(Drug drug) {
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

    public boolean setDuration(Duration duration) {
        this.duration = duration;
        return true;
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
