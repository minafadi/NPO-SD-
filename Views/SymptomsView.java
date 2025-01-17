package Views;

import Controllers.SymptomsController;
import Models.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SymptomsView extends JFrame {
    private JCheckBox headacheCheckBox;
    private JCheckBox feverCheckBox;
    private JCheckBox nauseaCheckBox;
    private JCheckBox shortnessOfBreathCheckBox;
    private JPanel Symptomss;
    private JButton confirmButton;
    private JCheckBox fatigueCheckBox;
    private JCheckBox coughCheckBox;
    public SymptomsController controller;

    public SymptomsView(Patient patient, SymptomsController controller) {
        this.controller=controller;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) (screenSize.width * 0.8), (int) (screenSize.height * 0.8));
        setLocationRelativeTo(null);
        setContentPane(Symptomss);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleSymptomsSelection(
                        headacheCheckBox.isSelected(),
                        feverCheckBox.isSelected(),
                        nauseaCheckBox.isSelected(),
                        shortnessOfBreathCheckBox.isSelected(),
                        fatigueCheckBox.isSelected(),
                        coughCheckBox.isSelected()
                );
                SymptomsController.updateDoctorList();
            }
        });
    }
}
