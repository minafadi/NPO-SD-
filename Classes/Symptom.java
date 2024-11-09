package Classes;

import java.time.Duration;

public abstract class Symptom extends Illness {
    Illness illness;

    public String getDescription(Illness illness) {
        return illness.getDescription();
    }

    public int getSeverity(Illness illness) {
        return illness.severity();
    }

    public Duration getDuration(Illness illness) {
        return illness.getDuration();
    }

    public boolean isContagious(Illness illness) {
        return illness.isContagious();
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }
}
