package Views;

import Models.Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

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
        addAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int day = (int) spinner1.getValue();
                int month = (int) spinner2.getValue();
                int year = (int) spinner3.getValue();

                LocalDate localDate = LocalDate.of(year, month, day);
                String appdate = day + " - " + month + " - " + year;
                Date appoinmentDate = java.sql.Date.valueOf(localDate);
                if(reserveForPatientCheckBox.isSelected()){
                    Models.Appointment a = new Appointment(Integer.parseInt(textField1.getText()),appdate, Integer.parseInt(textField2.getText()), textField3.getText());
                }
                else {
                    Appointment a = new Appointment(appdate, Integer.parseInt(textField2.getText()), textField3.getText());
                }
            }
        });
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
