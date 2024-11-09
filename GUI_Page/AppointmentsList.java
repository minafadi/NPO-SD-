package GUI_Page;

import Classes.Appointment;
import Classes.Doctor;

import javax.swing.*;

public class AppointmentsList extends JFrame{
    public JComboBox comboBox1;
    private JButton reserveAppointmentButton;
    private JPanel AList;
    public JLabel labeldoc;
    private Appointment[] DoctorAppointments;
    private Doctor d;

    public AppointmentsList(Doctor d){
        setContentPane(AList);
        setSize(500,500);
        this.d=d;
    }

}
