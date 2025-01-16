package Models;

public class GeneticIllness extends Illness {

    private double hereditaryFactor;

    public GeneticIllness() {
        this.description="Suffering from hereditary Genetic illness with symptoms:";
        this.Severity=5;
        this.treatmentCost=400;
    }

    @Override
    protected void diagnose() {
        System.out.println("Diagnosing genetic illness...");
    }

    @Override
    protected void prescribeDrugs() {
        System.out.println("Prescribing drugs for genetic illness...");
        Drug drug = Drug.readAllDrugs("GeneticIllness");
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
        else {
            System.out.println("No specific drugs found for genetic illness.");
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        System.out.println("Calculating treatment cost for genetic illness = " + treatmentCost);
        return treatmentCost;
    }
}
