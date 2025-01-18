package Models;

public class Nausea extends Symptom {

    public Nausea(Illness illness, DBProxy dbProxy) {
        this.illness = illness;
        this.dbProxy = dbProxy;
    }

    @Override
    protected void prescribeDrugs() {
        illness.prescribeDrugs(); // Delegate to the wrapped illness
        Drug drug = Drug.readAllDrugs("Nausea", dbProxy);
        if (drug != null) {
            illness.addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        // Delegate to the wrapped illness
        return illness.calculateTreatmentCost() + 70;
    }

    public String getDescription() {
        return illness.getDescription()+" nausea, ";
    }
    @Override
    public int severity() {
        return illness.severity() + 3;
    }

    @Override
    public double calculateCost() {
        return  calculateTreatmentCost();
    }

}
