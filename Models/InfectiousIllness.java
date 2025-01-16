package Models;

public class InfectiousIllness extends Illness {

    public InfectiousIllness() {
        this.description="Suffering from Infectious Illness with symptoms:";
        this.Severity=2;
        this.treatmentCost=100;
    }

    @Override
    protected void diagnose() {
        System.out.println("Diagnosing infectious illness...");
    }

    @Override
    protected void prescribeDrugs() {
        System.out.println("Prescribing drugs for infectious illness...");
        Drug drug = Drug.readAllDrugs("InfectiousIllness");
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
        else {
            System.out.println("No specific drugs found for infectious illness.");
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        System.out.println("Calculating treatment cost for infectious illness = " + treatmentCost);
        return treatmentCost;
    }
}
