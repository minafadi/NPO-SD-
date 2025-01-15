package Controllers;

import Models.*;
import Views.InVoiceView;

import javax.print.Doc;

public class InvoiceController {
    public InVoiceView view;
    public Invoice model = new Invoice();

    public Doctor d;
    public Patient p;
    public  InvoiceController(String total , Patient patient , Doctor doctor, String drugs){
        p = patient;
        d = doctor;
        view = new InVoiceView(patient.getId(), doctor.getDRid());
        view.textField3.setText(total);
        view.PatientTF.setText(patient.getName());
        view.DoctorTF.setText(doctor.getName());
        view.PatientTF.setEnabled(false);
        view.DoctorTF.setEnabled(false);
        view.textField1.setEnabled(false);
        view.textField3.setEnabled(false);
        view.textField1.setText(drugs);
        view.setVisible(true);
    }

    public static String PayPressed(String paymethod){
        Invoice i = new Invoice();
        NotifybyEmail email = new NotifybyEmail(i);
        NotifybySMS SMS = new NotifybySMS(i);
        NotifybyWhatsapp whatsapp = new NotifybyWhatsapp(i);
        String s = i.updatnotify();
        Invoice inv = new Invoice();
        //PaymentMethod=comboBox1.getSelectedItem().toString();
        if(paymethod=="Cash"){
            inv.setPayment(new CashPayment());
        } else if (paymethod=="Visa") {
            inv.setPayment(new VisaPayment());

        } else if (paymethod=="Fawry") {
            inv.setPayment(new FawryPayment());
        }
        String method = inv.getPayment().getDescription();
        s+=method;
        //String contains notifications + payment method
        return s;

    }

}
