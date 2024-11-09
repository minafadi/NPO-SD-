package Classes;

import static Classes.Drug.readAllDrugs;

public class AutoimmuneIllness extends Illness {
    public AutoimmuneIllness() {
        super.description="Suffering from AutoImmune disease with symptoms:";
        super.addDrug(readAllDrugs("AutoImmuneIllness"));
    }

    @Override
    public double calculateCost() {
        return 30;
    }

    @Override
    public int severity() {
        return 8;
    }

}
