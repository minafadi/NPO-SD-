package Classes;

public class ChronicIllness extends Illness {
    int durationInYears;
    Boolean isLifelong;

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Unimplemented method 'calculateCost'");
    }

    @Override
    public int severity() {
        return 2;
    }

    public boolean requiresLongTermCare() {
        return durationInYears > 1 || isLifelong;
    }

    public int getDurationInYears() {
        return durationInYears;
    }

    public void setDurationInYears(int durationInYears) {
        this.durationInYears = durationInYears;
    }

    public boolean getIsLifelong() {
        return isLifelong;
    }

    public void setIsLifelong(Boolean isLifelong) {
        this.isLifelong = isLifelong;
    }

}
