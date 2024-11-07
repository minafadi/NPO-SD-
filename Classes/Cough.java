package Classes;

public class Cough extends Symptom {
    private int frequency;

    public Cough(Illness illness) {
        this.illness = illness;
    }
    
    @Override
    public int severity() {
        return illness.severity() + 1;
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
