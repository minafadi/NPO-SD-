package Classes;
import GUI_Page.DoctorsListPage;

public class DoctorController {
    private Doctor model;
    private DoctorsListPage view;

    public DoctorController(Doctor model, DoctorsListPage view) {
        this.model = model;
        this.view = view;
    }

    public void updateDoctorListView() {
        Doctor[] doctorArray = model.readAllDoctors();
        String[] doctorNames = new String[doctorArray.length];
        for (int i = 0; i < doctorArray.length; i++) {
            doctorNames[i] = doctorArray[i].getName();
        }

        view.ReadDocsList(doctorNames);
    }
}
