package Controllers;

import Models.*;
import Views.DoctorsListView;

public class DoctorsListController {
    Doctor[] allDocs;
    Patient p;
    DoctorsListView v;
    static DBProxy dbProxy;

    public DoctorsListController(Doctor[] allDocs, Patient p, DBProxy dbProxy) {
        this.allDocs = allDocs;
        this.p = p;
        this.dbProxy = dbProxy;
        v = new DoctorsListView(p, allDocs);
    }

    public static void chooseDoctor(String chosenDoctorName, Doctor[] allDocs, Patient patient){
        Doctor chosenDoctor = null;
        for(Doctor d : allDocs){
            if(d.getName().equals(chosenDoctorName)){
                chosenDoctor = d;
                break;
            }
        }
        Drug[] patientDrugs = patient.getIllness().getDrugList().toArray(new Drug[0]);
        AppointmentController appointmentController = new AppointmentController(new Appointment(chosenDoctor.getDRid()),dbProxy);
        appointmentController.updateAppointmentListView(patient,patientDrugs);
    }
}
