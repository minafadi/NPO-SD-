package Models;

public class Fever extends Symptom {

    public Fever(Illness illness) {
        this.illness = illness;
    }

    @Override
    protected void diagnose() {
        illness.diagnose();
        System.out.println("Adding diagnosis for fever...");
    }

    @Override
    protected void prescribeDrugs() {
        illness.prescribeDrugs(); // Delegate to the wrapped illness
        System.out.println("Adding prescription for fever...");
        Drug drug = Drug.readAllDrugs("Fever");
        if (drug != null) {
            illness.addDrug(drug); // Add the drug only if it's not null
        }
        else {
            System.out.println("No specific drugs found for Fever Symptom.");
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        // Delegate to the wrapped illness
        System.out.println("Adding additional cost for fever...");
        return illness.calculateTreatmentCost() + 50;
    }

    //For the Decorator DP wrapping of severity
    @Override
    public int severity() {
        return illness.severity() + 2;
    }

    //For the Decorator DP wrapping of description
    @Override
    public String getDescription() {
        return illness.getDescription()+" Fever, ";
    }

    //For the Decorator DP wrapping of cost
    @Override
    public double calculateCost() {
        return calculateTreatmentCost();
    }


}
