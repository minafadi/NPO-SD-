package Classes;

import static Classes.Drug.readAllDrugs;

public class InfectiousIllness extends Illness {
    private int contagionLevel;

    public InfectiousIllness() {
        super.description="Suffering from infectious disease with symptoms:";
        super.Severity=2;
        super.treatmentCost=50;
        super.addDrug(readAllDrugs("InfectiousIllness"));
    }


}
