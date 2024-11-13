package GUI_Page;

import Classes.*;

import javax.print.Doc;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentsList extends JFrame{
    public JComboBox comboBox1;
    private JButton reserveAppointmentButton;
    private JPanel AList;
    public JLabel labeldoc;
    String drugss;
    public AppointmentsList(Doctor d, Patient p,Drug[] dd,Appointment[] Allapps){
        setContentPane(AList);
        setSize(500,500);
        for (Appointment a : Allapps){
            comboBox1.addItem("Doctor: "+a.getDoctorNameById() + ", Date: "+a.getDate());
        }
        labeldoc.setText(d.getName()+"'s Available Appointments");
        reserveAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<dd.length;i++){
                    drugss+=dd[i].getDrugName()+", ";
                }
                InVoicePage i = new InVoicePage(d.getDRid(),p.getid());
                double total = Illness.getDrugscost(dd);
                double total2 = d.getSalary();
                double total3=p.getIllness().calculateCost();
                i.textField3.setText(String.valueOf(total + total2 + total3));
                i.PatientTF.setText(p.getName());
                i.DoctorTF.setText(d.getName());
                i.PatientTF.setEnabled(false);
                i.DoctorTF.setEnabled(false);
                i.textField1.setEnabled(false);
                i.textField3.setEnabled(false);
                i.textField1.setText(drugss);
                i.setVisible(true);
            }
        });
    }

}
