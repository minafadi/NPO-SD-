package Models;

public class AutoimmuneIllness extends Illness {

    public AutoimmuneIllness() {
        this.description="Suffering from AutoImmune disease with symptoms:";
        this.Severity=5;
        this.treatmentCost=90;
    }

    @Override
    protected void diagnose() {
        System.out.println("Diagnosing autoImmune illness...");
    }

    @Override
    protected void prescribeDrugs() {
        System.out.println("Prescribing drugs for autoImmune illness...");
        Drug drug = Drug.readAllDrugs("AutoImmuneIllness");
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
        else {
            System.out.println("No specific drugs found for autoImmune illness.");
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        System.out.println("Calculating treatment cost for autoImmune illness = " + treatmentCost);
        return treatmentCost;
    }


}
