package Controllers;

import Models.*;
import Views.AppointmentsListView;

public class AppointmentListController extends ParentController implements State {
    private Appointment model;
    public Appointment app2;
    public String total2;
    public Patient patient2;
    public Doctor doctor2;
    public String drugs2;
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
        //this.view.setVisible(true);
        ParentController.setnextState(this);

    }

    public void reserve(String total, Patient patient, Doctor doctor, String drugs, String date){
        InvoiceController i;
        for (Appointment a : Allapps){
            if(a.getDate().equals(date)) {
                total2=total;
                patient2=patient;
                doctor2=doctor;
                app2=a;
                drugs2=drugs;
                ParentController.nextPage();
            }
        }

    }


    @Override
    public void show() {
        view.setVisible(true);
    }

    @Override
    public void hide() {
        view.setVisible(false);
    }

    @Override
    public void init() {
        //execute();
        new InvoiceController(total2,patient2,doctor2,drugs2,app2, dbProxy);
    }
    public void execute(String total ,Patient p, Doctor d,String drugs,Appointment app,DBProxy dbProxy){
        new InvoiceController(total,p,d,drugs,app, dbProxy);
    }
}
