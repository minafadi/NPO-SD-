package Models;

public class ShortnessOfBreath extends Symptom {
    public ShortnessOfBreath(Illness illness, DBProxy dbProxy) {
        this.illness = illness;
        this.illness.addDrug(Drug.readAllDrugs("ShortnessOfBreath", dbProxy));
    }
    public String getDescription() {
        return super.getDescription()+"ShortnessOfBreath";
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
