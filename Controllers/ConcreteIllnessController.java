package Controllers;

import Models.*;
import Views.ConcreteIllnessView;

public class ConcreteIllnessController extends ParentController implements State {
    Patient patient;
    ConcreteIllnessView view;
    static DBProxy dbProxy;

    public ConcreteIllnessController(Patient patient, DBProxy dbProxy) {
        this.patient = patient;
        this.dbProxy = dbProxy;
        view = new ConcreteIllnessView(patient,this);
        ParentController.setnextState(this);
    }

    public void updateIllness(String illness, Patient patient) {
        Illness i;
        if (illness == "Mental") {
            i = new MentalIllness(dbProxy);
            patient.setIllness(i);
        } else if (illness == "Infectious") {
            i = new InfectiousIllness(dbProxy);
            patient.setIllness(i);
        } else if (illness == "Genetic") {
            i = new GeneticIllness(dbProxy);
            patient.setIllness(i);
        } else if (illness == "Acute") {
            i = new AcuteIllness(dbProxy);
            patient.setIllness(i);
        } else if (illness == "Auto-Immune") {
            i = new AutoimmuneIllness(dbProxy);
            patient.setIllness(i);
        } else{
            i = new ChronicIllness(dbProxy);
            patient.setIllness(i);
        }

        // Use the Template Design Pattern to treat the illness
        i.treatIllness(patient, dbProxy);

        ParentController.nextPage();

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
        new SymptomsController(patient,dbProxy);
    }
}
