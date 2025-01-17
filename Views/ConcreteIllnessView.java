package Views;

import Controllers.ConcreteIllnessController;
import Models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConcreteIllnessView extends JFrame {
    Patient patient;
    ConcreteIllnessController controller;
    private JComboBox comboBox1;
    private JButton OKButton;
    //private JPanel ConcIll;
    private JPanel Concill;
    public ConcreteIllnessView(Patient patient, ConcreteIllnessController controller) {
        this.controller=controller;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);
        this.patient = patient;
        setContentPane(Concill);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String illness = comboBox1.getSelectedItem().toString();
                controller.updateIllness(illness, patient);
            }
        });
    }

}
