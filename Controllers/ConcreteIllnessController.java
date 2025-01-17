package Controllers;

import Models.*;
import Views.ConcreteIllnessView;

public class ConcreteIllnessController {
    Patient patient;
    ConcreteIllnessView view;
    static DBProxy dbProxy;

    public ConcreteIllnessController(Patient patient, DBProxy dbProxy) {
        this.patient = patient;
        this.dbProxy = dbProxy;
        view = new ConcreteIllnessView(patient);
        view.setVisible(true);
    }

    public static void updateIllness(String illness, Patient patient) {
        Illness i;
        if (illness == "MentalIllness") {
            i = new MentalIllness(dbProxy);
            patient.setIllness(i);
        } else if (illness == "InfectiousIllness") {
            i = new InfectiousIllness(dbProxy);
            patient.setIllness(i);
        } else if (illness == "GeneticIllness") {
            i = new GeneticIllness(dbProxy);
            patient.setIllness(i);
        } else if (illness == "AcuteIllness") {
            i = new AcuteIllness(dbProxy);
            patient.setIllness(i);
        } else if (illness == "AutoImmuneIllness") {
            i = new AutoimmuneIllness(dbProxy);
            patient.setIllness(i);
        } else{
            i = new ChronicIllness(dbProxy);
            patient.setIllness(i);
        }

        // Update the patient's illness
//        if (illness != null) {
//            patient.setIllness(illness);

            // Use the Template Design Pattern to treat the illness
        i.treatIllness(patient, dbProxy);

        SymptomsController s = new SymptomsController(patient,dbProxy);

            // After treating illness, proceed with the symptoms controller
//        }
    }
}
