package Models;

public class AutoimmuneIllness extends Illness {

    public AutoimmuneIllness() {
        this.description="Suffering from AutoImmune disease with symptoms:";
        this.Severity=5;
        this.treatmentCost=90;
    }


    @Override
    protected void prescribeDrugs() {
        Drug drug = Drug.readAllDrugs("AutoImmuneIllness");
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }

    }

    @Override
    protected double calculateTreatmentCost() {
        return treatmentCost;
    }


}
