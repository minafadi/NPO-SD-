package Controllers;

import Models.*;
import Views.AppointmentsListView;

public class AppointmentListController {
    private Appointment model;
    private AppointmentsListView view;
    DBProxy dbProxy;
    Appointment[] Allapps;
    public AppointmentListController(Appointment model, DBProxy dbProxy) {
        this.model = model;
        this.dbProxy = dbProxy;
        Allapps = model.ReadDoctorApps(model.getDoctorId(), dbProxy);
    }

    public void updateAppointmentListView(Patient p, Drug[] dd){
        //Appointment[] Allapps = model.ReadDoctorApps(model.getDoctorId(), dbProxy);
        Doctor d = new Doctor(model.getDoctorId(), dbProxy);
        double total = Illness.getDrugsCost(dd);
        double total2 = d.getSalary();
        double total3=p.getIllness().calculateCost();
        //Insert invoice to db
        Invoice.insert(p.getName(),d.getName(),dd,(total+total2+total3), dbProxy);
        this.view = new AppointmentsListView(d,p,dd,Allapps,(total+total2+total3), this);
        this.view.setVisible(true);
    }

    public void reserve(String total, Patient patient, Doctor doctor, String drugs, String date){
        InvoiceController i;
        for (Appointment a : Allapps){
            if(a.getDate().equals(date)) i = new InvoiceController(total,patient,doctor,drugs,a, dbProxy);
        }

    }



}
