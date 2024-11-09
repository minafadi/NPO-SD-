package Classes;

import java.time.Duration;

public abstract class Symptom extends Illness {
    Illness illness;

    public String getDescription() {
        return illness.getDescription();
    }

    public int getSeverity() {
        return illness.severity();
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
