package GUI_Page;

import Classes.*;

import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConcreteIllness extends JFrame {
    Patient patient;
    private JComboBox comboBox1;
    private JButton OKButton;
    //private JPanel ConcIll;
    private JPanel Concill;

    public ConcreteIllness(Patient patient) {
        this.patient = patient;
        setContentPane(Concill);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = comboBox1.getSelectedItem().toString();
                if(name=="MentalIllness"){
                    Illness i=new MentalIllness();
                    patient.setIllness(i);
                }
                else if (name==
                        "InfectiousIllness") {
                    Illness i=new InfectiousIllness();
                    patient.setIllness(i);

                }else if (name==
                        "GeneticIllness") {

                    Illness i=new GeneticIllness();
                    patient.setIllness(i);
                }else if (name==
                        "AcuteIllness") {
                    Illness i=new AcuteIllness();
                    patient.setIllness(i);

                }else if (name==
                        "AutoImmuneIllness"){
                    Illness i=new AutoimmuneIllness();
                    patient.setIllness(i);

                }


                else if (name==
                        "ChronicIllness"
                ) {
                    Illness i=new ChronicIllness();
                    patient.setIllness(i);

                }
                Symptoms s=new Symptoms(patient);
                s.setVisible(true);

            }
        });
    }

}
