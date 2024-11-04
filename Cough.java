public class Cough extends Symptom {
    private int frequency;

    @Override
    public Boolean setSeverity(Illness illness) {
        illness.setSeverity(illness.getSeverity() + 1);
        return true;
    }

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Boolean isChronic() {
        return frequency > 10;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

}
