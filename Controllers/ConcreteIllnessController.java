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
        Illness illnessInstance = null;

        // Create illness instance based on the string
        switch (illness) {
            case "MentalIllness":
                illnessInstance = new MentalIllness();
                break;
            case "InfectiousIllness":
                illnessInstance = new InfectiousIllness();
                break;
            case "GeneticIllness":
                illnessInstance = new GeneticIllness();
                break;
            case "AcuteIllness":
                illnessInstance = new AcuteIllness();
                break;
            case "AutoImmuneIllness":
                illnessInstance = new AutoimmuneIllness();
                break;
            case "ChronicIllness":
                illnessInstance = new ChronicIllness();
                break;
            default:
                System.out.println("Unknown illness type: " + illness);
                return;
        }

        // Update the patient's illness
        if (illnessInstance != null) {
            patient.setIllness(illnessInstance);

            // Use the Template Design Pattern to treat the illness
            illnessInstance.treatIllness(patient);

            // After treating illness, proceed with the symptoms controller
            SymptomsController symptomsController = new SymptomsController(patient);
        }
    }
}
