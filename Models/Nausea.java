package Models;

public class Nausea extends Symptom {

    public Nausea(Illness illness) {
        this.illness = illness;
    }
    @Override
    protected void diagnose() {
        illness.diagnose();
        System.out.println("Adding diagnosis for nausea...");
    }

    @Override
    protected void prescribeDrugs() {
        illness.prescribeDrugs(); // Delegate to the wrapped illness
        System.out.println("Adding prescription for nausea...");
        Drug drug = Drug.readAllDrugs("Nausea");
        if (drug != null) {
            illness.addDrug(drug); // Add the drug only if it's not null
        }
        else {
            System.out.println("No specific drugs found for nausea Symptom.");
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        // Delegate to the wrapped illness
        System.out.println("Adding additional cost for nausea...");
        return illness.calculateTreatmentCost() + 70;
    }

    public String getDescription() {
        return illness.getDescription()+" nausea, ";
    }
    @Override
    public int severity() {
        return illness.severity() + 3;
    }

    @Override
    public double calculateCost() {
        return  calculateTreatmentCost();
    }

}
