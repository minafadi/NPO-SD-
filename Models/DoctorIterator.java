package Models;

public class DoctorIterator implements Iterator<Doctor> {
    private Doctor[] doctors;
    private int position = 0;

    public DoctorIterator(Doctor[] doctors) {
        this.doctors = doctors;
    }

    @Override
    public boolean hasNext() {
        return position < doctors.length && doctors[position] != null;
    }

    @Override
    public Doctor next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more doctors");
        }
        return doctors[position++];
    }
}
