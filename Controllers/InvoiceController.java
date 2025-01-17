package Controllers;

import Models.*;
import Views.InVoiceView;

import java.util.*;
import javax.print.Doc;

public class InvoiceController extends ParentController implements State {
    public InVoiceView view;
    public Invoice model = new Invoice();
    static String total;
    public Doctor d;
    public Patient p;

    Appointment appointment;

    DBProxy dbProxy;

    public static String removeDuplicates(String inputString) {
        String[] words = inputString.split("\\s+");  // Split the string into words
        Set<String> uniqueWords = new LinkedHashSet<>();  // Preserve the order of words
        for (String word : words) {
            uniqueWords.add(word);  // Add each word to the set (duplicates will be ignored)
        }
        return String.join(" ", uniqueWords);  // Join the unique words back into a string
    }

    public  InvoiceController(String total , Patient patient , Doctor doctor, String drugs, Appointment appointment, DBProxy dbProxy){
        this.appointment = appointment;
        this.dbProxy = dbProxy;
        p = patient;
        d = doctor;
        view = new InVoiceView(patient.getId(), doctor.getDRid(),this);
        this.total = total;
        drugs = drugs.replaceAll("null","");
        drugs = removeDuplicates(drugs);
//        view = new InVoiceView(patient.getId(), doctor.getDRid());
        view.textField3.setText(total);
        view.PatientTF.setText(patient.getName());
        view.DoctorTF.setText(doctor.getName());
        view.PatientTF.setEnabled(false);
        view.DoctorTF.setEnabled(false);
        view.textField1.setEnabled(false);
        view.textField3.setEnabled(false);
        view.textField1.setText(drugs);
        //view.setVisible(true);
        ParentController.setnextState(this);
    }

    public String PayPressed(String paymethod){
        Invoice i = new Invoice();
        NotifybyEmail email = new NotifybyEmail(i);
        NotifybySMS SMS = new NotifybySMS(i);
        NotifybyWhatsapp whatsapp = new NotifybyWhatsapp(i);
        String s = i.updatnotify();
        Invoice inv = new Invoice();
        //PaymentMethod=comboBox1.getSelectedItem().toString();
        if(paymethod=="Cash"){
            inv.setPayment(new CashPaymentAdapter(new CashPayment()));
        } else if (paymethod=="Visa") {
            inv.setPayment(new VisaPayment());

        } else if (paymethod=="Fawry") {
            inv.setPayment(new FawryPayment());
        }
        //Double tot = Double.parseDouble(total);
        double tota = Double.parseDouble(String.valueOf(total));
        inv.pay((int) tota);
        String method = inv.getPayment().getDescription();
        s+=method;
        appointment.reserve(dbProxy,p);
        hide();
        //String contains notifications + payment method
        return s;

    }

    @Override
    public void show() {
        view.setVisible(true);
    }

    @Override
    public void hide() {
        view.setVisible(false);
    }

    @Override
    public void init() {

    }
}
