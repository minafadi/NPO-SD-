package GUI_Page;

import Classes.*;

import javax.swing.*;
import java.awt.*;
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
    public JLabel DrugsLabel;
    private JLabel PaymentLabel;
    public JLabel AmountLabel;
    public JTextField textField1;
    public JTextField textField3;
    private JPanel invoice;
    private JComboBox comboBox1;
    String PaymentMethod;
    public InVoicePage(){
        setContentPane(invoice);
        setSize(500,500);

    }
    public InVoicePage(int Did,int Pid){
        setContentPane(invoice);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);
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
                Invoice inv = new Invoice();
                PaymentMethod=comboBox1.getSelectedItem().toString();
                if(PaymentMethod=="Cash"){
                    inv.setPayment(new CashPayment());
                } else if (PaymentMethod=="Visa") {
                    inv.setPayment(new VisaPayment());

                } else if (PaymentMethod=="Fawry") {
                    inv.setPayment(new FawryPayment());
                }
                Notifications n = new Notifications();
                n.textArea1.setText(s);
                n.textArea1.append(inv.getPayment().getDescription());


                n.setVisible(true);

            }
        });


    }
}
