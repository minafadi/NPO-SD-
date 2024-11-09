package GUI_Page;
import Classes.Patient;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorsListPage extends JFrame{
    public JList DoctorList;
    public JComboBox DoctorCBox;
    private JButton SubmitButton;
    private JPanel DList;
    private Patient p;
    public String [] Docs;
    public DoctorsListPage(Patient p){
        this.p=p;
        this.setContentPane(DList);
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("test");
            }
        });
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
    public boolean ReadDocsList(String [] d){
        Docs=d;
        System.out.println(d[0]);
        return true;
    }
}
