package Controllers;

import Models.Patient;
import Models.Illness;
import Models.Doctor;
import Models.*;
import Views.SymptomsView;

public class SymptomsController {
    private static SymptomsView view;
    private static Patient patient;
    static DBProxy dbProxy;

    public SymptomsController(Patient patient, DBProxy dbProxy) {
        this.dbProxy = dbProxy;
        this.patient = patient;
        view = new SymptomsView(patient);
        view.setVisible(true);
    }

    public static void handleSymptomsSelection(
            boolean headacheSelected,
            boolean feverSelected,
            boolean nauseaSelected,
            boolean shortnessOfBreathSelected,
            boolean fatigueSelected,
            boolean coughSelected) {
        Illness illness = patient.getIllness();

        if (headacheSelected) {
            illness = new Headache(illness,dbProxy);
        }
        if (feverSelected) {
            illness = new Fever(illness,dbProxy);
        }
        if (nauseaSelected) {
            illness = new Nausea(illness,dbProxy);
        }
        if (shortnessOfBreathSelected) {
            illness = new ShortnessOfBreath(illness,dbProxy);
        }
        if (fatigueSelected) {
            illness = new Fatigue(illness, dbProxy);
        }
        if (coughSelected) {
            illness = new Cough(illness, dbProxy);
        }

        illness.treatIllness(patient);
        patient.setIllness(illness);
        System.out.println(illness);
        if (illness.addIllnessToPatient(patient, dbProxy)) {
            view.setVisible(false);
        }
    }

    public static void updateDoctorList() {
//        DoctorController doctorController = new DoctorController(new Doctor(),dbProxy);
//        doctorController.updateDoctorListView(patient);

        DoctorsListController doctorsListController = new DoctorsListController(new Doctor(), dbProxy);
        doctorsListController.updateDoctorListView(patient);

    }
}

