public class Nausea extends Symptom {
    private int intensity;

    @Override
    public Boolean setSeverity(Illness illness) {
        illness.setSeverity(illness.getSeverity() + 3);
        return true;
    }

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Unimplemented method 'calculateCost'");
    }

    public Boolean isSevere() {
        return this.intensity > 6;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

}
