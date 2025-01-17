package Models;

import static Models.Drug.readAllDrugs;

public class AutoimmuneIllness extends Illness {

    public AutoimmuneIllness(DBProxy dbProxy) {
        this.description="Suffering from AutoImmune disease with symptoms:";
        this.Severity=5;
        this.treatmentCost=90;
        this.dbProxy = dbProxy;
    }


    @Override
    protected void prescribeDrugs() {
        Drug drug = Drug.readAllDrugs("AutoImmuneIllness", dbProxy);
        if (drug != null) {
            addDrug(drug); // Add the drug only if it's not null
        }

    }

    @Override
    protected double calculateTreatmentCost() {
        return treatmentCost;
    }


}
