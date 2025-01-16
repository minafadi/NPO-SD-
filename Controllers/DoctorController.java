package Controllers;
import Models.DBProxy;
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
    DBProxy dbProxy;
    public DoctorController(Doctor model, DBProxy dbProxy) {
        this.model = model;
        this.dbProxy = dbProxy;
    }

    public void updateDoctorListView(Patient p) {
        Doctor[] doctorArray = model.readAllDoctors(dbProxy);
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
