package Models;

public class AcuteIllness extends Illness {
    DBProxy dbProxy;
    public AcuteIllness(DBProxy dbProxy) {
        this.description="Suffering from Acute Illness with symptoms:";
        this.Severity=1;
        this.treatmentCost=40;
        this.dbProxy = dbProxy;
    }

    @Override
    protected void prescribeDrugs() {
        Drug drug = Drug.readAllDrugs("AcuteIllness", dbProxy);
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        return treatmentCost;
    }
}
