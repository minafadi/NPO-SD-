package GUI_Page;

import Classes.Appointment;
import Classes.Doctor;
import Classes.Patient;

import javax.print.Doc;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentsList extends JFrame{
    public JComboBox comboBox1;
    private JButton reserveAppointmentButton;
    private JPanel AList;
    public JLabel labeldoc;
    public int Did;
    public int Pid;
    public AppointmentsList(int Did){
        setContentPane(AList);
        setSize(500,500);
        this.Did=Did;
        reserveAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InVoicePage i = new InVoicePage();
                i.setVisible(true);
            }
        });
    }
    public AppointmentsList(int Did,int Pid){
        setContentPane(AList);
        setSize(500,500);
        this.Did=Did;
        this.Pid=Pid;
        reserveAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InVoicePage i = new InVoicePage(Did,Pid);
                Doctor d = new Doctor(Did);
                Patient p =new Patient(Pid);
                i.PatientTF.setText(p.getName());
                i.DoctorTF.setText(d.getName());
                i.PatientTF.setEnabled(false);
                i.DoctorTF.setEnabled(false);
                i.setVisible(true);
            }
        });
    }

}
