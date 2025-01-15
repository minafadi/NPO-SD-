package Classes;
import GUI_Page.DoctorsListPage;

public class DoctorController {
    private Doctor model;
    private DoctorsListPage view;
    public DoctorController(Doctor model) {
        this.model = model;
    }

    public void updateDoctorListView(Patient p) {
        Doctor[] doctorArray = model.readAllDoctors();
        view = new DoctorsListPage(p,doctorArray);
        view.setVisible(true);

    }


}
