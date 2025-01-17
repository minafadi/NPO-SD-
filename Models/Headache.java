package Models;

public class Headache extends Symptom {

    public Headache(Illness illness) {
        this.illness = illness;
    }


    @Override
    protected void prescribeDrugs() {
        illness.prescribeDrugs(); // Delegate to the wrapped illness
        Drug drug = Drug.readAllDrugs("Headache");
        if (drug != null) {
            illness.addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        // Delegate to the wrapped illness
        return illness.calculateTreatmentCost() + 20;
    }

    @Override
    public int severity() {
        return illness.severity() + 3;
    }

    @Override
    public String getDescription() {
        return illness.getDescription()+" Headache, ";
    }

    @Override
    public double calculateCost() {
        return calculateTreatmentCost();
    }

}
