package Models;

public class Headache extends Symptom {

    public Headache(Illness illness) {
        this.illness = illness;
    }

    @Override
    protected void diagnose() {
        illness.diagnose();
        System.out.println("Adding diagnosis for headache...");
    }

    @Override
    protected void prescribeDrugs() {
        illness.prescribeDrugs(); // Delegate to the wrapped illness
        System.out.println("Adding prescription for headache...");
        Drug drug = Drug.readAllDrugs("Headache");
        if (drug != null) {
            illness.addDrug(drug); // Add the drug only if it's not null
        }
        else {
            System.out.println("No specific drugs found for Headache Symptom.");
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        // Delegate to the wrapped illness
        System.out.println("Adding additional cost for headache...");
        return illness.calculateTreatmentCost() + 20;
    }

    @Override
    public int severity() {
        return illness.severity() + 3;
    }

    @Override
    public String getDescription() {
        return illness.getDescription()+" Headache, ";
    }

    @Override
    public double calculateCost() {
        return calculateTreatmentCost();
    }

}
