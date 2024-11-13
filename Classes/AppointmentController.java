package Classes;

import GUI_Page.AppointmentsList;
import GUI_Page.DoctorsListPage;

import javax.print.Doc;

public class AppointmentController {
    private Appointment model;
    private AppointmentsList view;
    private Patient p;
    private Drug [] dd;

    public AppointmentController(Appointment model, Patient p,Drug[] dd) {
        this.model = model;
        this.p=p;
        this.dd=dd;

    }
    public void updateAppointmentListView(){
        Appointment[] Allapps = model.ReadDoctorApps(model.getDoctorId());
        Doctor d = new Doctor(model.getDoctorId());
        this.view = new AppointmentsList(d,p,dd,Allapps);
        this.view.setVisible(true);
    }



}
