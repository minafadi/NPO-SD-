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
    public int Did;
    public int Pid;
    public Illness il;
    String drugss;
    public AppointmentsList(int Did, int Pid,Illness il ,Drug[] dd){
        setContentPane(AList);
        setSize(500,500);
        this.Did=Did;
        this.Pid=Pid;
        this.il=il;
        reserveAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<dd.length;i++){
                    drugss+=dd[i].getDrugName()+", ";
                }
                InVoicePage i = new InVoicePage(Did,Pid);
                Doctor d = new Doctor(Did);
                Patient p =new Patient(Pid);
                //double total = il.getDrugscost();
                double total = Illness.getDrugscost(dd);
                double total2 = d.getSalary();
                double total3=il.calculateCost();
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
