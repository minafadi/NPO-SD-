package Models;

public class GeneticIllness extends Illness {

    public GeneticIllness(DBProxy dbProxy) {
        this.description="Suffering from hereditary Genetic illness with symptoms:";
        this.Severity=5;
        this.treatmentCost=400;
        this.dbProxy = dbProxy;
    }

    @Override
    protected void prescribeDrugs() {
        Drug drug = Drug.readAllDrugs("GeneticIllness", dbProxy);
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        return treatmentCost;
    }
}
