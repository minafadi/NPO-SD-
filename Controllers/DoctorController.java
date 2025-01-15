package Controllers;
import Models.Doctor;
import Models.Patient;
import Views.DoctorsListView;

public class DoctorController {
    private Doctor model;
    private DoctorsListView view;
    public DoctorController(Doctor model) {
        this.model = model;
    }

    public void updateDoctorListView(Patient p) {
        Doctor[] doctorArray = model.readAllDoctors();
        view = new DoctorsListView(p,doctorArray);
        view.setVisible(true);

    }


}
