package Controllers;
import Models.Doctor;
import Models.DoctorsCollection;
import Models.Iterator;
import Models.Patient;
import Views.DoctorsListView;

import java.util.ArrayList;
import java.util.List;

public class DoctorController {
    private Doctor model;
    private DoctorsListView view;
    public DoctorController(Doctor model) {
        this.model = model;
    }

    public void updateDoctorListView(Patient p) {
        DoctorsCollection doctorsCollection = model.readAllDoctors();

        Iterator<Doctor> iterator = doctorsCollection.getIterator();
        List<Doctor> doctorList = new ArrayList<>();

        while (iterator.hasNext()) {
            doctorList.add(iterator.next());
        }

        Doctor[] doctorArray = doctorList.toArray(new Doctor[0]);

        view = new DoctorsListView(p,doctorArray);
        view.setVisible(true);

    }
}
