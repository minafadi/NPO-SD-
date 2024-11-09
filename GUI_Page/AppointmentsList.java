package GUI_Page;

import Classes.Appointment;
import Classes.Doctor;

import javax.swing.*;

public class AppointmentsList extends JFrame{
    public JComboBox comboBox1;
    private JButton reserveAppointmentButton;
    private JPanel AList;
    public JLabel labeldoc;
    public int Did;

    public AppointmentsList(int Did){
        setContentPane(AList);
        setSize(500,500);
        this.Did=Did;
    }

}
