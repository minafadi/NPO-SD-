public class ShortnessOfBreath extends Symptom {
    @Override
    public Boolean setSeverity(Illness illness) {
        illness.setSeverity(illness.getSeverity() + 4);
        return true;
    }

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
