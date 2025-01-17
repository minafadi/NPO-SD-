package Views;

import javax.swing.*;
import java.awt.*;

public class AppointmentView extends JFrame {
    private JPanel Appointment;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton addAppointmentButton;
    private JCheckBox reserveForPatientCheckBox;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;

    public AppointmentView() {
        setContentPane(Appointment);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8), (int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);

        // Spinner models
        spinner1.setModel(new SpinnerNumberModel(1, 1, 31, 1));
        spinner2.setModel(new SpinnerNumberModel(1, 1, 12, 1));
        spinner3.setModel(new SpinnerNumberModel(2024, 2024, 2040, 1));
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public JButton getAddAppointmentButton() {
        return addAppointmentButton;
    }

    public JCheckBox getReserveForPatientCheckBox() {
        return reserveForPatientCheckBox;
    }

    public JSpinner getSpinner1() {
        return spinner1;
    }

    public JSpinner getSpinner2() {
        return spinner2;
    }

    public JSpinner getSpinner3() {
        return spinner3;
    }
}
