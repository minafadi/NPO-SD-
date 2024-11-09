package GUI_Page;

import Classes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Symptoms extends JFrame {
    private JCheckBox headacheCheckBox;
    private JCheckBox feverCheckBox;
    private JCheckBox nauseaCheckBox;
    private JCheckBox shortnessOfBreathCheckBox;
    private JPanel Symptomss;
    private JButton confirmButton;
    Patient patient;

    public Symptoms(Patient patient) {
        setContentPane(Symptomss);
        this.patient = patient;
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Confirm button pressed");
                System.out.println(patient.getIllness().getDescription());
                if (headacheCheckBox.isSelected()) {
                    //patient.setIllness(new Headache(patient.getIllness() ));
                    Illness i = patient.getIllness();
                    i=new Headache(i);
                    patient.setIllness(i);
                    System.out.println(patient.getIllness().getDescription());
                }
                if (feverCheckBox.isSelected()) {
                    Illness i = patient.getIllness();
                    i=new Fever(i);
                    patient.setIllness(i);
                    System.out.println(patient.getIllness().getDescription());
                }if (nauseaCheckBox.isSelected()) {
                    Illness i = patient.getIllness();
                    i=new Nausea(i);
                    patient.setIllness(i);
                    System.out.println(patient.getIllness().getDescription());

                }
                if (shortnessOfBreathCheckBox.isSelected()) {
                    Illness i = patient.getIllness();
                    i=new ShortnessOfBreath(i);
                    patient.setIllness(i);
                    /*System.out.println(patient.getIllness().getDescription());
                    if(i.AddIllness(patient)){
                        for (int j=0;j<i.getDrugList().size();j++){
                            System.out.print(i.getDrugList().get(j));
                        }
                    }*/
                }
                //System.out.println("IDDDDD");
                //System.out.println(patient.getId());
                //System.out.println(patient.);
                if(patient.getIllness().AddIllness(patient)){
                    setVisible(false);
                }
            }
        });
    }
}
