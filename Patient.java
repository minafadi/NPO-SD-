public class Patient extends User {
    private Illness illness;
    private int age;
    private String gender;

    public Patient(String name, String phone, Illness illness, int age, String gender) {
        super(name, phone);
        this.illness = illness;
        this.age = age;
        this.gender = gender;
    }

    public Boolean updatePatient(Patient patient) {
        return true;
    }

    public Patient readPatient(Patient patient) {
        return patient;
    }

    public Boolean removePatient(Patient patient) {
        return true;
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
