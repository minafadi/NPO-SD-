package GUI_Page;
import Classes.Patient;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorsListPage extends JFrame{
    private JList DoctorList;
    private JComboBox DoctorCBox;
    private JButton SubmitButton;
    private JPanel DList;
    private Patient p;
    public DoctorsListPage(Patient p){
        this.p=p;

    }
    public DoctorsListPage() {
        this.setContentPane(DList);
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("test");
            }
        });
    }
}
