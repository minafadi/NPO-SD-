package Models;

public class ChronicIllness extends Illness {

    public ChronicIllness() {
        this.description="Suffering from Chronic Illness with symptoms:";
        this.Severity=3;
        this.treatmentCost=120;
    }

    @Override
    protected void diagnose() {
        System.out.println("Diagnosing chronic illness...");
    }

    @Override
    protected void prescribeDrugs() {
        System.out.println("Prescribing drugs for chronic illness...");
        Drug drug = Drug.readAllDrugs("ChronicIllness");
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
        else {
            System.out.println("No specific drugs found for chronic illness.");
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        System.out.println("Calculating treatment cost for chronic illness...");
        return treatmentCost;
    }
}
