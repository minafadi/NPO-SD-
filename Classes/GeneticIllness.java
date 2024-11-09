package Classes;

public class GeneticIllness extends Illness {


    public GeneticIllness() {
            super.description="Suffering from hereditary Genetic disease with symptoms:";
    }

    @Override
    public double calculateCost() {
        return 90;
    }

    @Override
    public int severity() {
        return 4;
    }

}
