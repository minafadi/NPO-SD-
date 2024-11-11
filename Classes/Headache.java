package Classes;

public class Headache extends Symptom {

    public Headache(Illness illness) {
        this.illness = illness;
        this.illness.addDrug(Drug.readAllDrugs("Headache"));
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
