package Models;

public class Fever extends Symptom {

    public Fever(Illness illness) {
        this.illness = illness;
    }


    @Override
    protected void prescribeDrugs() {
        illness.prescribeDrugs(); // Delegate to the wrapped illness
        Drug drug = Drug.readAllDrugs("Fever");
        if (drug != null) {
            illness.addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        // Delegate to the wrapped illness
        return illness.calculateTreatmentCost() + 50;
    }

    //For the Decorator DP wrapping of severity
    @Override
    public int severity() {
        return illness.severity() + 2;
    }

    //For the Decorator DP wrapping of description
    @Override
    public String getDescription() {
        return illness.getDescription()+" Fever, ";
    }

    //For the Decorator DP wrapping of cost
    @Override
    public double calculateCost() {
        return calculateTreatmentCost();
    }


}
