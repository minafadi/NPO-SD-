package Models;

public class ShortnessOfBreath extends Symptom {
    public ShortnessOfBreath(Illness illness) {
        this.illness = illness;
    }

    @Override
    protected void diagnose() {
        illness.diagnose();
        System.out.println("Adding diagnosis for shortness of breath...");
    }

    @Override
    protected void prescribeDrugs() {
        illness.prescribeDrugs(); // Delegate to the wrapped illness
        System.out.println("Adding prescription for shortness of breath...");
        Drug drug = Drug.readAllDrugs("ShortnessOfBreath");
        if (drug != null) {
            illness.addDrug(drug); // Add the drug only if it's not null
        }
        else {
            System.out.println("No specific drugs found for Shortness of breath Symptom.");
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        // Delegate to the wrapped illness
        System.out.println("Adding additional cost for Shortness of breath...");
        return illness.calculateTreatmentCost() + 150;
    }

    public String getDescription() {
        return super.getDescription() + " Shortness of Breath, ";
    }

    @Override
    public int severity() {
        return illness.severity() + 4;
    }

    @Override
    public double calculateCost() {
        return calculateTreatmentCost();
    }
}
