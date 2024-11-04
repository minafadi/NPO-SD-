public class Headache extends Symptom {
    private String location;
    private int intensity;
    
    @Override
    public Boolean setSeverity(Illness illness) {
        illness.setSeverity(illness.getSeverity() + 3);
        return true;
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
