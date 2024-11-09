package GUI_Page;

import Classes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.classfile.instruction.InvokeDynamicInstruction;

public class InVoicePage extends JFrame{
    private JLabel InVoiceLabel;
    public JTextField PatientTF;
    public JTextField DoctorTF;
    private JButton PayButton;
    private JLabel PatientLabel;
    private JLabel DoctorLabel;
    private JLabel DrugsLabel;
    private JLabel PaymentLabel;
    private JLabel AmountLabel;
    private JTextField textField1;
    private JTextField textField3;
    private JPanel invoice;
    private JComboBox comboBox1;

    public InVoicePage(){
        setContentPane(invoice);
        setSize(500,500);

    }
    public InVoicePage(int Did,int Pid){
        setContentPane(invoice);
        setSize(500,500);
        PayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Doctor d = new Doctor(Did);
                Patient p =new Patient(Pid);
                Invoice i = new Invoice();
                NotifybyEmail email = new NotifybyEmail(i);
                NotifybySMS SMS = new NotifybySMS(i);
                NotifybyWhatsapp whatsapp = new NotifybyWhatsapp(i);
                String s = i.updatnotify();
                Notifications n = new Notifications();
                n.textArea1.setText(s);
                n.setVisible(true);
            }
        });


    }
}
