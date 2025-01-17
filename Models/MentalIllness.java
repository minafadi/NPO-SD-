package Models;

public class MentalIllness extends Illness {

    public MentalIllness() {
        this.description = "Suffering from Mental Illness with symptoms: ";
        this.Severity=9;
        this.treatmentCost=700;
    }

    @Override
    protected void prescribeDrugs() {
        Drug drug = Drug.readAllDrugs("MentalIllness");
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        return treatmentCost;
    }

}
