package Classes;

import static Classes.Drug.readAllDrugs;

public class MentalIllness extends Illness {

    public MentalIllness() {
        super.description = "suffering from Mental Illness with symptoms: ";
        //System.out.println(readAllDrugs("MentalIllness").getDrugName());
        super.addDrug(readAllDrugs("MentalIllness"));
    }

    @Override
    public double calculateCost() {
        return 40;
    }

    @Override
    public int severity() {
        return 16;
    }
}
