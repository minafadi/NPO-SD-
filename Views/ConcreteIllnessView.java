package Views;

import Models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConcreteIllnessView extends JFrame {
    Patient patient;
    private JComboBox comboBox1;
    private JButton OKButton;
    //private JPanel ConcIll;
    private JPanel Concill;
    public ConcreteIllnessView(Patient patient) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);
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
                SymptomsView s=new SymptomsView(patient);
                System.out.println("fel concrete 7agm el array:");
                System.out.println(patient.getIllness().getDrugList().size());
                s.setVisible(true);

            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
