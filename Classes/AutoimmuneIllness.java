package Classes;

public class AutoimmuneIllness extends Illness {

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Unimplemented method 'calculateCost'");
    }

    @Override
    public int severity() {
        return 8;
    }

}
