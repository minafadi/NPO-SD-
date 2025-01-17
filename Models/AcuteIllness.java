package Models;

public class AcuteIllness extends Illness {

    public AcuteIllness() {
        this.description="Suffering from Acute Illness with symptoms:";
        this.Severity=1;
        this.treatmentCost=40;
    }

    @Override
    protected void prescribeDrugs() {
        Drug drug = Drug.readAllDrugs("AcuteIllness");
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        return treatmentCost;
    }
}
