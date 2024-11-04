import java.time.Duration;

public abstract class Symptom extends Illness {
    Illness illness;

    public abstract Boolean setSeverity(Illness illness);

    public String getDescription(Illness illness) {
        return illness.getDescription();
    }

    public int getSeverity(Illness illness) {
        return illness.getSeverity();
    }

    public Duration getDuration(Illness illness) {
        return illness.getDuration();
    }

    public Boolean isContagious(Illness illness) {
        return illness.isContagious();
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }
}
