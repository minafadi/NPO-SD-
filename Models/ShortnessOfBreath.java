package Models;

public class ShortnessOfBreath extends Symptom {

    public ShortnessOfBreath(Illness illness, DBProxy dbProxy) {
        this.illness = illness;
        this.dbProxy = dbProxy;
    }


    @Override
    protected void prescribeDrugs() {
        illness.prescribeDrugs(); // Delegate to the wrapped illness
        Drug drug = Drug.readAllDrugs("ShortnessOfBreath", dbProxy);
        if (drug != null) {
            illness.addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        // Delegate to the wrapped illness
        return illness.calculateTreatmentCost() + 150;
    }

    public String getDescription() {
        return super.getDescription() + " Shortness of Breath, ";
    }

    @Override
    public int severity() {
        return illness.severity() + 4;
    }

    @Override
    public double calculateCost() {
        return calculateTreatmentCost();
    }
}
