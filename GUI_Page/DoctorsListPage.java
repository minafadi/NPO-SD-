package GUI_Page;
import Classes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorsListPage extends JFrame{
    public DefaultListModel<String> listModel = new DefaultListModel<>();
    public JComboBox DoctorCBox;
    private JButton SubmitButton;
    private JPanel DList;
    public JTextArea textArea1;
    public DoctorsListPage(Patient p,Doctor[] Alldocs){
        this.setContentPane(DList);
        setSize(500,500);
        for (Doctor d : Alldocs){
            String doctorInfo = "Name: " + d.getName() + ", Phone: " + d.getPhone() +
                    ", Specialization: " + d.getSpecialization() +
                    ", Degree: " + d.getDegree() + "\n";
            textArea1.append(doctorInfo);
        }
        for(Doctor d : Alldocs){
            DoctorCBox.addItem(d.getName());
        }
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Doctor chosendoctor=new Doctor();
                for (Doctor d : Alldocs){
                    if(d.getName().equals(DoctorCBox.getSelectedItem())){
                        chosendoctor = d;
                    }
                }
                Drug dd[]=p.getIllness().getDrugList().toArray(new Drug[0]);
                //Appointment MVC
                AppointmentController cont = new AppointmentController(new Appointment(chosendoctor.getDRid()),p,dd);
                cont.updateAppointmentListView();

            }
        });
    }
}
