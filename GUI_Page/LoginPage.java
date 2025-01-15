package GUI_Page;
import Classes.Doctor;
import Classes.DoctorController;
import Classes.Patient;
import Classes.Admin;
import javax.swing.*;
import java.awt.*;
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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = NameTF.getText();
                String password = PasswordPF.getText();
                if (OccupationCBox.getSelectedItem() == "Patient" && Patient.AuthenticatePatient(name,password)){
                    Patient p = new Patient(name,password);
                    ConcreteIllness conc = new ConcreteIllness(p);
                    conc.setVisible(true);
                }
                else if(OccupationCBox.getSelectedItem() == "Admin" && Admin.AuthenticateAdmin(name,password)){
                    AdminPage p = new AdminPage();
                    p.setVisible(true);
                }


            }
        });
    }
}
