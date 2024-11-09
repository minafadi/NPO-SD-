package Classes;

public class AcuteIllness extends Illness {
    public AcuteIllness() {
        super.description="Suffering from Acute Illness with symptoms:";

    }

    @Override
    public double calculateCost() {
        return 16;
    }

    @Override
    public int severity() {
        return 1;
    }

}
