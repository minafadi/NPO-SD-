package Controllers;
import Models.DBProxy;
import Models.Doctor;
import Models.Patient;
import Views.DoctorsListView;

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
        view = new DoctorsListView(p,doctorArray);
        view.setVisible(true);

    }


}
