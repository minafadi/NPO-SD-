package Models;

public class InfectiousIllness extends Illness {
DBProxy dbProxy;
    public InfectiousIllness(DBProxy dbProxy) {
        this.description="Suffering from Infectious Illness with symptoms:";
        this.Severity=2;
        this.treatmentCost=100;
        this.dbProxy = dbProxy;
    }

    @Override
    protected void prescribeDrugs() {
        Drug drug = Drug.readAllDrugs("InfectiousIllness", dbProxy);
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        return treatmentCost;
    }
}
