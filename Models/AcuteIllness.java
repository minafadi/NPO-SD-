package Models;

public class AcuteIllness extends Illness {

    public AcuteIllness() {
        this.description="Suffering from Acute Illness with symptoms:";
        this.Severity=1;
        this.treatmentCost=40;
    }

    @Override
    protected void diagnose() {
        System.out.println("Diagnosing acute illness...");
    }

    @Override
    protected void prescribeDrugs() {
        System.out.println("Prescribing drugs for acute illness...");
        Drug drug = Drug.readAllDrugs("AcuteIllness");
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
        else {
            System.out.println("No specific drugs found for acute illness.");
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        System.out.println("Calculating treatment cost for acute illness...");
        return treatmentCost;
    }
}
