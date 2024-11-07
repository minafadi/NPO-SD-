package Classes;

public class AcuteIllness extends Illness {

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Unimplemented method 'calculateCost'");
    }

    @Override
    public int severity() {
        return 32;
    }

}
