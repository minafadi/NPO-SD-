package Controllers;

import Models.Patient;
import Models.Illness;
import Models.Doctor;
import Models.*;
import Views.SymptomsView;

public class SymptomsController {
    private static SymptomsView view;
    private static Patient patient;

    public SymptomsController(Patient patient) {

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
            illness = new Headache(illness);
        }
        if (feverSelected) {
            illness = new Fever(illness);
        }
        if (nauseaSelected) {
            illness = new Nausea(illness);
        }
        if (shortnessOfBreathSelected) {
            illness = new ShortnessOfBreath(illness);
        }
        if (fatigueSelected) {
            illness = new Fatigue(illness);
        }
        if (coughSelected) {
            illness = new Cough(illness);
        }

        patient.setIllness(illness);

        if (illness.addIllnessToPatient(patient)) {
            view.setVisible(false);
        }
    }

    public static void updateDoctorList() {
        DoctorController doctorController = new DoctorController(new Doctor());
        doctorController.updateDoctorListView(patient);
    }
}

