public class Headache extends Symptom {
    private String location;
    private int intensity;
    
    public Headache(Illness illness) {
        this.illness = illness;
    }

    @Override
    public int severity() {
        return illness.severity() + 3;
    }

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Unimplemented method 'calculateCost'");
    }

    public Boolean isMigraine() {
        return intensity > 8 && "temples".equals(location);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}
