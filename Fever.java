public class Fever extends Symptom {
    private double temperature;

    public Fever(Illness illness) {
        this.illness = illness;
    }
    
    @Override
    public int severity() {
        return illness.severity() + 2;
    }

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Not supported yet.");
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
