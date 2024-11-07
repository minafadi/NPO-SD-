package Classes;

public class Nausea extends Symptom {
    private int intensity;

    public Nausea(Illness illness) {
        this.illness = illness;
    }

    @Override
    public int severity() {
        return illness.severity() + 3;
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
