package Controllers;

import Models.*;
import Views.ConcreteIllnessView;

public class ConcreteIllnessController {
    Patient patient;
    ConcreteIllnessView view;
    public ConcreteIllnessController(Patient patient) {
        this.patient = patient;
        view = new ConcreteIllnessView(patient);
        view.setVisible(true);
    }

    public static void updateIllness(String illness, Patient patient) {
        if (illness == "MentalIllness") {
            Illness i = new MentalIllness();
            patient.setIllness(i);
        } else if (illness == "InfectiousIllness") {
            Illness i = new InfectiousIllness();
            patient.setIllness(i);
        } else if (illness == "GeneticIllness") {
            Illness i = new GeneticIllness();
            patient.setIllness(i);
        } else if (illness == "AcuteIllness") {
            Illness i = new AcuteIllness();
            patient.setIllness(i);
        } else if (illness == "AutoImmuneIllness") {
            Illness i = new AutoimmuneIllness();
            patient.setIllness(i);
        } else if (illness == "ChronicIllness") {
            Illness i = new ChronicIllness();
            patient.setIllness(i);
        }
        SymptomsController s = new SymptomsController(patient);

}
