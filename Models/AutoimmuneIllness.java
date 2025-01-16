package Models;

import static Models.Drug.readAllDrugs;

public class AutoimmuneIllness extends Illness {

    private String affectedOrganSystem;

    public AutoimmuneIllness(DBProxy dbProxy) {
        super.description="Suffering from AutoImmune disease with symptoms:";
        super.Severity=5;
        super.treatmentCost=90;
        super.addDrug(readAllDrugs("AutoImmuneIllness", dbProxy ));
    }


}
