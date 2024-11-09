package Classes;

public class GeneticIllness extends Illness {
    private Boolean hereditary;
    
    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Unimplemented method 'calculateCost'");
    }

    @Override
    public int severity() {
        return 4;
    }

    public boolean isHereditary() {
        return hereditary;
    }

    public void setHereditary(Boolean hereditary) {
        this.hereditary = hereditary;
    }

}
