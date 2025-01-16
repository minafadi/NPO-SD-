package Models;

public class DoctorsCollection {
    private Doctor[] doctors;

    public DoctorsCollection(Doctor[] doctors) {
        this.doctors = doctors;
    }

    public Iterator<Doctor> getIterator() {
        return new DoctorIterator(doctors);
    }
}
