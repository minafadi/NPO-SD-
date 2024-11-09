package GUI_Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame{
    private JTextField AddDoctorTF;
    private JTextField AddAppointTF;
    private JButton AddAppointButton;
    private JButton AddDocButton;
    private JTextField AddDrugTF;
    private JButton AddDrugButton;
    private JLabel AdminDashLabel;
    private JButton DoneButton;
    private JLabel AddDoctorLabel;
    private JLabel AddAppointLabel;
    private JLabel AddDrugLabel;
    private JPanel Admin;

    public AdminPage() {
        setContentPane(Admin);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);

        AddAppointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppointmentPage appointmentPage = new AppointmentPage();
                appointmentPage.setVisible(true);
            }
        });
    }
}
