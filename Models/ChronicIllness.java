package Models;

public class ChronicIllness extends Illness {

    public ChronicIllness(DBProxy dbProxy) {
        this.description="Suffering from Chronic Illness with symptoms:";
        this.Severity=3;
        this.treatmentCost=120;
        this.dbProxy = dbProxy;
    }


    @Override
    protected void prescribeDrugs() {
        Drug drug = Drug.readAllDrugs("ChronicIllness", dbProxy);
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        return treatmentCost;
    }
}
