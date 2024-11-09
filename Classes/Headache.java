package Classes;

public class Headache extends Symptom {
    private String location;
    private int intensity;
    
    public Headache(Illness illness) {
        this.illness = illness;
        this.illness.addDrug(Drug.readAllDrugs("Headache"));
    }

    @Override
    public int severity() {
        return illness.severity() + 3;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"headache";
    }

    @Override
    public double calculateCost() {
        return illness.calculateCost()+5;
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
