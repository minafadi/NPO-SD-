package Controllers;

import Models.*;
import Views.DoctorsListView;

import java.util.ArrayList;
import java.util.List;

public class DoctorsListController {
    Doctor[] allDocs;
    Patient p;
    DoctorsListView v;
    static DBProxy dbProxy;
    private Doctor model;
    private DoctorsListView view;

    public DoctorsListController(Doctor doctor, DBProxy dbProxy){
        this.model = doctor;
        this.dbProxy = dbProxy;
    }

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
        AppointmentListController appointmentListController = new AppointmentListController(new Appointment(chosenDoctor.getDRid()),dbProxy);
        appointmentListController.updateAppointmentListView(patient,patientDrugs);
    }

    public void updateDoctorListView(Patient p) {
//        this.dbProxy=dbProxy;
        DoctorsCollection doctorsCollection = model.readAllDoctors(dbProxy);
//        DoctorsCollection doctorsCollection = model.readAllDoctors();

        Iterator<Doctor> iterator = doctorsCollection.getIterator();
        List<Doctor> doctorList = new ArrayList<>();

        while (iterator.hasNext()) {
            doctorList.add(iterator.next());
        }

        Doctor[] doctorArray = doctorList.toArray(new Doctor[0]);

        view = new DoctorsListView(p,doctorArray);
        view.setVisible(true);

    }
}
