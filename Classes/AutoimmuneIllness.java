package Classes;

import static Classes.Drug.readAllDrugs;

public class AutoimmuneIllness extends Illness {
    public AutoimmuneIllness() {
        super.description="Suffering from AutoImmune disease with symptoms:";
        super.Severity=5;
        super.treatmentCost=90;
        super.addDrug(readAllDrugs("AutoImmuneIllness"));
    }


}
