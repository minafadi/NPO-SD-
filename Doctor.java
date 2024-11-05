public class Doctor extends User {
    private String specialization;
    private String degree;
    private int graduationYear;
    private double salary;

    public Doctor(String name, String phone, String specialization, String degree, int graduationYear, double salary) {
        super(name, phone);
        this.specialization = specialization;
        this.degree = degree;
        this.graduationYear = graduationYear;
        this.salary = salary;
    }

    public Boolean updateDoctor(Doctor doctor) {
        return true;
    }

    public Doctor readDoctor(Doctor doctor) {
        return doctor;
    }

    public Boolean removeDoctor(Doctor doctor) {
        return true;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
