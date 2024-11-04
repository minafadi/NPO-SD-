public class Fever extends Symptom {
    private double temperature;

    @Override
    public Boolean setSeverity(Illness illness) {
        illness.setSeverity(illness.getSeverity() + 2);
        return true;
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
