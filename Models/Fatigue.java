package Models;

public class Fatigue extends Symptom {
    public Fatigue(Illness illness) {
        this.illness = illness;
    }


    @Override
    protected void prescribeDrugs() {
        illness.prescribeDrugs(); // Delegate to the wrapped illness
        Drug drug = Drug.readAllDrugs("Fatigue");
        if (drug != null) {
            illness.addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        // Delegate to the wrapped illness
        return illness.calculateTreatmentCost() + 30;
    }


    @Override
    public int severity() {
        return illness.severity() + 2;
    }
    //For the Decorator DP wrapping of description
    @Override
    public String getDescription() {
        return illness.getDescription()+" Fatigue, ";
    }

    //For the Decorator DP wrapping of cost
    @Override
    public double calculateCost() {
        return calculateTreatmentCost();
    }

}
