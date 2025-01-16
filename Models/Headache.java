package Models;

public class Headache extends Symptom {

    public Headache(Illness illness, DBProxy dbProxy) {
        this.illness = illness;
        this.illness.addDrug(Drug.readAllDrugs("Headache", dbProxy));
    }

    @Override
    public int severity() {
        return illness.severity() + 3;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"headache,";
    }

    @Override
    public double calculateCost() {
        return illness.calculateCost()+60;
    }

}
