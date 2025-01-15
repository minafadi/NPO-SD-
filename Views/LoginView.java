package Views;
import Models.Patient;
import Models.Admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controllers.*;

public class LoginView extends JFrame{
    private JTextField NameTF;
    private JComboBox OccupationCBox;
    private JButton LoginButton;
    private JLabel NameLabel;
    private JLabel PasswordLabel;
    private JLabel OccupationLabel;
    private JLabel ForgetLabel;
    private JPasswordField PasswordPF;
    private JPanel login;

    public LoginView() {
        setContentPane(login);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = NameTF.getText();
                String password = PasswordPF.getText();
                String selectedOccupation = (String) OccupationCBox.getSelectedItem();

                LoginController.login(name,password,selectedOccupation);
                /*if (OccupationCBox.getSelectedItem() == "Patient" && Patient.AuthenticatePatient(name,password)){
                    Patient p = new Patient(name,password);
                    ConcreteIllnessView conc = new ConcreteIllnessView(p);
                    conc.setVisible(true);
                }
                else if(OccupationCBox.getSelectedItem() == "Admin" && Admin.AuthenticateAdmin(name,password)){
                    AdminView p = new AdminView();
                    p.setVisible(true);
                }*/


            }
        });
    }
}
