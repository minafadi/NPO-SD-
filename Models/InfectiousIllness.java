package Models;

public class InfectiousIllness extends Illness {

    public InfectiousIllness() {
        this.description="Suffering from Infectious Illness with symptoms:";
        this.Severity=2;
        this.treatmentCost=100;
    }

    @Override
    protected void prescribeDrugs() {
        Drug drug = Drug.readAllDrugs("InfectiousIllness");
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        return treatmentCost;
    }
}
