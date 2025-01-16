package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Commands.CommandHomeAdmin;
import Controllers.*;
import Commands.CommandAddAppointmentAdmin;
import Commands.CommandAddDoctorAdmin;
import Commands.CommandAddDrugAdmin;
import Models.ICommandAdmin;

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
        ICommandAdmin appCommand = new CommandAddAppointmentAdmin(new AppointmentView());
        ICommandAdmin docCommand = new CommandAddDoctorAdmin(new AddDoctorView());
        ICommandAdmin drugCommand = new CommandAddDrugAdmin(new AddDrugView());
        ICommandAdmin homeCommand = new CommandHomeAdmin(this);
        AddAppointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController.setCommand(appCommand);
                AdminController.ExecuteCommand();
            }
        });
        AddDocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController.setCommand(docCommand);
                AdminController.ExecuteCommand();
            }
        });
        AddDrugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController.setCommand(drugCommand);
                AdminController.ExecuteCommand();
            }
        });
        DoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController.setCommand(homeCommand);
                AdminController.UndoCommand();
            }
        });
    }
}
