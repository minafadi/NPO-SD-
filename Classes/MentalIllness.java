package Classes;

import static Classes.Drug.readAllDrugs;

public class MentalIllness extends Illness {

    public MentalIllness() {
        super.description = "suffering from Mental Illness with symptoms: ";
        super.Severity=9;
        super.treatmentCost=700;
        //System.out.println(readAllDrugs("MentalIllness").getDrugName());
        super.addDrug(readAllDrugs("MentalIllness"));
    }

}
