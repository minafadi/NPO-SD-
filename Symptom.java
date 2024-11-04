public abstract class Symptom extends Illness {
    private Illness illness;
    
    @Override
    public abstract double calculateCost();

    public abstract Boolean setSeverity(Illness illness);

    public String getDescription(Illness illness) {
        return illness.getDescription();
    }

    public int getSeverity(Illness illness) {
        return illness.getSeverity();
    }

    public int getDuration(Illness illness) {
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
