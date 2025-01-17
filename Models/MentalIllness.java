package Models;

public class MentalIllness extends Illness {
DBProxy dbProxy;
    public MentalIllness(DBProxy dbProxy) {
        this.description = "Suffering from Mental Illness with symptoms: ";
        this.Severity=9;
        this.treatmentCost=700;
        this.dbProxy = dbProxy;
    }

    @Override
    protected void prescribeDrugs() {
        Drug drug = Drug.readAllDrugs("MentalIllness", dbProxy);
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        return treatmentCost;
    }

}
