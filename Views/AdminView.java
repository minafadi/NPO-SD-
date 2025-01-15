package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminView extends JFrame{
    private JButton AddAppointButton;
    private JButton AddDocButton;
    private JButton AddDrugButton;
    private JLabel AdminDashLabel;
    private JButton DoneButton;
    private JLabel AddDoctorLabel;
    private JLabel AddAppointLabel;
    private JLabel AddDrugLabel;
    private JPanel Admin;

    public AdminView() {
        setContentPane(Admin);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);

        AddAppointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppointmentView appointmentView = new AppointmentView();
                appointmentView.setVisible(true);
            }
        });
        AddDocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDoctorView d = new AddDoctorView();
                d.setVisible(true);
            }
        });
        AddDrugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDrugView d = new AddDrugView();
                d.setVisible(true);
            }
        });
    }
}
