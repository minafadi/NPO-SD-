package Classes;

public class Fever extends Symptom {
    private double temperature;

    public Fever(Illness illness) {
        this.illness = illness;
        this.illness.addDrug(Drug.readAllDrugs("Fever"));
    }
    
    @Override
    public int severity() {
        return illness.severity() + 2;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"Fever,";
    }

    @Override
    public double calculateCost() {
        return illness.calculateCost()+50;
    }


}
