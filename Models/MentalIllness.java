package Models;

import static Models.Drug.readAllDrugs;

public class MentalIllness extends Illness {

    private String [] psychologicalSymptoms;

    public MentalIllness(DBProxy dbProxy) {
        super.description = "suffering from Mental Illness with symptoms: ";
        super.Severity=9;
        super.treatmentCost=700;
        //System.out.println(readAllDrugs("MentalIllness").getDrugName());
        super.addDrug(readAllDrugs("MentalIllness", dbProxy));
    }


}
