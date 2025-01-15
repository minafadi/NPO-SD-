package Controllers;

import Models.*;
import Views.AppointmentsListView;

public class AppointmentController {
    private Appointment model;
    private AppointmentsListView view;

    public AppointmentController(Appointment model) {
        this.model = model;
    }
    public void updateAppointmentListView(Patient p, Drug[] dd){
        Appointment[] Allapps = model.ReadDoctorApps(model.getDoctorId());
        Doctor d = new Doctor(model.getDoctorId());
        double total = Illness.getDrugscost(dd);
        double total2 = d.getSalary();
        double total3=p.getIllness().calculateCost();
        //Insert invoice to db
        Invoice.insert(p.getName(),d.getName(),dd,(total+total2+total3));
        this.view = new AppointmentsListView(d,p,dd,Allapps,(total+total2+total3));
        this.view.setVisible(true);
    }



}
