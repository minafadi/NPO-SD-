package Views;

import Controllers.InvoiceController;
import Controllers.NotificationsController;
import Models.Doctor;
import Models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.lang.classfile.instruction.InvokeDynamicInstruction;

public class InVoiceView extends JFrame{
    private JLabel InVoiceLabel;
    public JTextField PatientTF;
    public JTextField DoctorTF;
    private JButton PayButton;
    private JLabel PatientLabel;
    private JLabel DoctorLabel;
    public JLabel DrugsLabel;
    private JLabel PaymentLabel;
    public JLabel AmountLabel;
    public JTextField textField1;
    public JTextField textField3;
    private JPanel invoice;
    private JComboBox comboBox1;
    InvoiceController controller;
    String PaymentMethod;
    public InVoiceView(){
        setContentPane(invoice);
        setSize(500,500);

    }
    public InVoiceView(int Did, int Pid,InvoiceController controller){
        this.controller=controller;
        setContentPane(invoice);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);
        PayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = controller.PayPressed(comboBox1.getSelectedItem().toString());

                NotificationsController cont = new NotificationsController(s);

            }
        });


    }
}
