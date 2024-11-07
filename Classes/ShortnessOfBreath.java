package Classes;

public class ShortnessOfBreath extends Symptom {
    public ShortnessOfBreath(Illness illness) {
        this.illness = illness;
    }

    @Override
    public int severity() {
        return illness.severity() + 4;
    }

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
