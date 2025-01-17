package Models;

public class Cough extends Symptom {
    private int frequency;

    public Cough(Illness illness) {
        this.illness = illness;
    }

    @Override
    protected void prescribeDrugs() {
        illness.prescribeDrugs(); // Delegate to the wrapped illness
        Drug drug = Drug.readAllDrugs("Cough");
        if (drug != null) {
            illness.addDrug(drug); // Add the drug only if it's not null
        }
    }

    @Override
    protected double calculateTreatmentCost() {
        // Delegate to the wrapped illness
        return illness.calculateTreatmentCost() + 70;
    }

    @Override
    public int severity() {
        return illness.severity() + 1;
    }

    @Override
    public String getDescription() {
        return illness.getDescription()+ " Cough, ";
    }

    @Override
    public double calculateCost() {
        return calculateTreatmentCost();
    }

    public boolean isChronic() {
        return frequency > 10;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

}
