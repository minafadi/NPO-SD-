package GUI_Page;
import Classes.Doctor;
import Classes.DoctorController;
import Classes.Patient;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame{
    private JTextField NameTF;
    private JComboBox OccupationCBox;
    private JButton LoginButton;
    private JLabel NameLabel;
    private JLabel PasswordLabel;
    private JLabel OccupationLabel;
    private JLabel ForgetLabel;
    private JPasswordField PasswordPF;
    private JPanel login;

    public LoginPage() {
        setContentPane(login);
        setSize(500,500);
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = NameTF.getText();
                System.out.println(name);
                String password = PasswordPF.getText();
                System.out.println(password);
                Patient p = new Patient(name,password);
                DoctorsListPage dlist = new DoctorsListPage(p);
                DoctorController c = new DoctorController(new Doctor(),dlist);
                c.updateDoctorListView();
                for (String st : dlist.Docs) {
                    dlist.DoctorCBox.addItem(st);
                }
                //dlist.DoctorList.add
                dlist.setVisible(true);
            }
        });
    }
}
