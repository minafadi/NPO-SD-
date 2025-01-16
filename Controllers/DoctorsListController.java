package Controllers;

import Models.Appointment;
import Models.Doctor;
import Models.Drug;
import Models.Patient;
import Views.DoctorsListView;

public class DoctorsListController {
    Doctor[] allDocs;
    Patient p;
    DoctorsListView v;

    public DoctorsListController(Doctor[] allDocs, Patient p) {
        this.allDocs = allDocs;
        this.p = p;
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
        AppointmentController appointmentController = new AppointmentController(new Appointment(chosenDoctor.getDRid()));
        appointmentController.updateAppointmentListView(patient,patientDrugs);
    }
}
