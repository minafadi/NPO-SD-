public class Fatigue extends Symptom {
    @Override
    public Boolean setSeverity(Illness illness) {
        illness.setSeverity(illness.getSeverity() + 2);
        return true;
    }

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Unimplemented method 'calculateCost'");
    }
}
