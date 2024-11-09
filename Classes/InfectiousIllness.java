package Classes;

public class InfectiousIllness extends Illness {
    private int contagionLevel;

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Unimplemented method 'calculateCost'");
    }

    @Override
    public int severity() {
        return 1;
    }

    @Override
    public boolean isContagious() {
        return contagionLevel > 7;
    }

    public int getContagionLevel() {
        return contagionLevel;
    }

    public void setContagionLevel(int contagionLevel) {
        this.contagionLevel = contagionLevel;
    }

}
