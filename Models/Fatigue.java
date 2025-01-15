package Models;

public class Fatigue extends Symptom {
    public Fatigue(Illness illness) {
        this.illness = illness;
        this.illness.addDrug(Drug.readAllDrugs("Fatigue"));
    }
    
    @Override
    public int severity() {
        return illness.severity() + 2;
    }

    @Override
    public double calculateCost() {
        return illness.calculateCost()+30;
    }
}
