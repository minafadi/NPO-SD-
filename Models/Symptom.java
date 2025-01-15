package Models;

import java.time.Duration;
import java.util.List;

public abstract class Symptom extends Illness {
    Illness illness;

    public String getDescription() {
        return illness.getDescription();
    }
    public void addDrug(Drug drug) {
        illness.addDrug(drug);  // Use the wrapped illness's drug list
    }

    @Override
    public List<Drug> getDrugList() {
        return illness.getDrugList(); // Access the original drug list
    }

    public Duration getDuration() {
        return illness.getDuration();
    }

    public Boolean isContagious() {
        return illness.isContagious();
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }
}
