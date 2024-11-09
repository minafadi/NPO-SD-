package Classes;

public class ShortnessOfBreath extends Symptom {
    public ShortnessOfBreath(Illness illness) {
        this.illness = illness;
        this.illness.addDrug(Drug.readAllDrugs("ShortnessOfBreath"));
    }

    @Override
    public int severity() {
        return illness.severity() + 4;
    }

    @Override
    public double calculateCost() {
        return illness.calculateCost() + 150;
    }
}
