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

    public SymptomsView(Patient patient) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) (screenSize.width * 0.8), (int) (screenSize.height * 0.8));
        setLocationRelativeTo(null);
        setContentPane(Symptomss);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SymptomsController.handleSymptomsSelection(
                        headacheCheckBox.isSelected(),
                        feverCheckBox.isSelected(),
                        nauseaCheckBox.isSelected(),
                        shortnessOfBreathCheckBox.isSelected()
                );
                SymptomsController.updateDoctorList();
            }
        });
    }
}
