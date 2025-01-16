package Controllers;

import Models.*;
import Views.AppointmentsListView;

public class AppointmentController {
    private Appointment model;
    private AppointmentsListView view;
    DBProxy dbProxy;

    public AppointmentController(Appointment model, DBProxy dbProxy) {
        this.model = model;
        this.dbProxy = dbProxy;
    }
    public void updateAppointmentListView(Patient p, Drug[] dd){
        Appointment[] Allapps = model.ReadDoctorApps(model.getDoctorId(), dbProxy);
        Doctor d = new Doctor(model.getDoctorId(), dbProxy);
        double total = Illness.getDrugscost(dd);
        double total2 = d.getSalary();
        double total3=p.getIllness().calculateCost();
        //Insert invoice to db
        Invoice.insert(p.getName(),d.getName(),dd,(total+total2+total3), dbProxy);
        this.view = new AppointmentsListView(d,p,dd,Allapps,(total+total2+total3));
        this.view.setVisible(true);
    }



}
