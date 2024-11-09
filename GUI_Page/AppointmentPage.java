package GUI_Page;

import Classes.Appointment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

public class AppointmentPage extends JFrame{
//    String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
//    String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
//    String[] years = {"2024", "2025", "2026", "2027", "2028", "2029", "2030"};
//    private JComboBox<String> comboBox1 = new JComboBox<>(days);
//    private JComboBox<String> comboBox2 = new JComboBox<>(months);
//    private JComboBox<String> comboBox3 = new JComboBox<>(years);
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton addAppointmentButton;
    private JCheckBox reserveForPatientCheckBox;
    private JPanel Appointment;
    private SpinnerNumberModel days = new SpinnerNumberModel(1, 1, 31, 1); // (initial value, min, max, step)
    private SpinnerNumberModel months = new SpinnerNumberModel(1, 1, 12, 1);
    private SpinnerNumberModel years = new SpinnerNumberModel(2024, 2024, 2040, 1);
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;


    public AppointmentPage() {
        setContentPane(Appointment);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);

        spinner1.setModel(days);
        spinner2.setModel(months);
        spinner3.setModel(years);


        addAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int day = (int) spinner1.getValue();
                int month = (int) spinner2.getValue();
                int year = (int) spinner3.getValue();

                System.out.println(day + " - " + month + " - " + year);
                LocalDate localDate = LocalDate.of(year, month, day);

                Date appoinmentDate = java.sql.Date.valueOf(localDate);
                System.out.println(appoinmentDate);
                if(reserveForPatientCheckBox.isSelected()){
                    Appointment a = new Appointment(Integer.parseInt(textField1.getText()),appoinmentDate, Integer.parseInt(textField2.getText()), textField3.getText());
                }
                else {
                    Appointment a = new Appointment(appoinmentDate, Integer.parseInt(textField2.getText()), textField3.getText());
                }
            }
        });
    }
}
