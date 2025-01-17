package Models;

public class GeneticIllness extends Illness {

    private double hereditaryFactor;

    public GeneticIllness() {
        this.description="Suffering from hereditary Genetic illness with symptoms:";
        this.Severity=5;
        this.treatmentCost=400;
    }

    @Override
    protected void prescribeDrugs() {
        Drug drug = Drug.readAllDrugs("GeneticIllness");
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        return treatmentCost;
    }
}
