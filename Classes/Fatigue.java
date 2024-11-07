package Classes;

public class Fatigue extends Symptom {
    public Fatigue(Illness illness) {
        this.illness = illness;
    }
    
    @Override
    public int severity() {
        return illness.severity() + 2;
    }

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Unimplemented method 'calculateCost'");
    }
}
