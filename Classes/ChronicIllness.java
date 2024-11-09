package Classes;

public class ChronicIllness extends Illness {


    public ChronicIllness() {
        super.description="Suffering from infectious disease with symptoms:";
    }

    @Override
    public double calculateCost() {
        return 50;
    }

    @Override
    public int severity() {
        return 2;
    }


}
