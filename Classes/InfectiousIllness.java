package Classes;

import static Classes.Drug.readAllDrugs;

public class InfectiousIllness extends Illness {
    private int contagionLevel;

    public InfectiousIllness() {
        super.description="Suffering from infectious disease with symptoms:";
        super.addDrug(readAllDrugs("InfectiousIllness"));
    }
    public String getDescription(){
        return super.description;
    }

    @Override
    public double calculateCost() {
        return 30;
    }

    @Override
    public int severity() {
        return 1;
    }

    @Override
    public Boolean isContagious() {
        return contagionLevel > 7;
    }

    public int getContagionLevel() {
        return contagionLevel;
    }

    public void setContagionLevel(int contagionLevel) {
        this.contagionLevel = contagionLevel;
    }

}
