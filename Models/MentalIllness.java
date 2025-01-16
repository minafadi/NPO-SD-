package Models;

public class MentalIllness extends Illness {

    public MentalIllness() {
        this.description = "Suffering from Mental Illness with symptoms: ";
        this.Severity=9;
        this.treatmentCost=700;
    }

    @Override
    protected void diagnose() {
        System.out.println("Diagnosing mental illness...");
    }

    @Override
    protected void prescribeDrugs() {
        System.out.println("Prescribing drugs for mental illness...");
        Drug drug = Drug.readAllDrugs("MentalIllness");
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }
        else {
            System.out.println("No specific drugs found for mental illness.");
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        System.out.println("Calculating treatment cost for mental illness = " + treatmentCost);
        return treatmentCost;
    }

}
