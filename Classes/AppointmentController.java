package Classes;

import GUI_Page.AppointmentsList;
import GUI_Page.DoctorsListPage;

import javax.print.Doc;

public class AppointmentController {
    private Appointment model;
    private AppointmentsList view;

    public AppointmentController(Appointment model) {
        this.model = model;
    }
    public void updateAppointmentListView(Patient p,Drug [] dd){
        Appointment[] Allapps = model.ReadDoctorApps(model.getDoctorId());
        Doctor d = new Doctor(model.getDoctorId());
        double total = Illness.getDrugscost(dd);
        double total2 = d.getSalary();
        double total3=p.getIllness().calculateCost();
        //Insert invoice to db
        Invoice.insert(p.getName(),d.getName(),dd,(total+total2+total3));
        this.view = new AppointmentsList(d,p,dd,Allapps,(total+total2+total3));
        this.view.setVisible(true);
    }



}
