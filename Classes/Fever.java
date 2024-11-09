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
    public double calculateCost() {
        return illness.calculateCost()+50;
    }

    public Boolean isHighFever() {
        return temperature > 38.0;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
