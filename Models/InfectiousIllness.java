package Models;

import static Models.Drug.readAllDrugs;

public class InfectiousIllness extends Illness {
    private int contagionLevel;

    public InfectiousIllness(DBProxy dbProxy) {
        super.description="Suffering from infectious disease with symptoms:";
        super.Severity=2;
        super.treatmentCost=50;
        super.addDrug(readAllDrugs("InfectiousIllness", dbProxy));
    }


}
