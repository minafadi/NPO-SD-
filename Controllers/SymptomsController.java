package Controllers;

import Models.Patient;
import Models.Illness;
import Models.Doctor;
import Models.*;
import Views.SymptomsView;

public class SymptomsController {
    private static SymptomsView view;
    private static Patient patient;

    public SymptomsController(SymptomsView view, Patient patient) {
        this.view = view;
        this.patient = patient;
    }

    public static void handleSymptomsSelection(boolean headacheSelected, boolean feverSelected, boolean nauseaSelected, boolean shortnessOfBreathSelected) {
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

        patient.setIllness(illness);

        if (illness.AddIllness(patient)) {
            view.setVisible(false);
        }
    }

    public static void updateDoctorList() {
        DoctorController doctorController = new DoctorController(new Doctor());
        doctorController.updateDoctorListView(patient);
    }
}

