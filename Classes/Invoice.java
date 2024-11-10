package Classes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Invoice implements InterfaceInvoice{
    private int appointmentId;
    private String patientName;
    private String doctorName;
    private List<Drug> drugList = new ArrayList<>();
    private Payment payment;
    private double totalPrice;
    public ArrayList<IObserver> mylist;


    public Invoice()
    {
        mylist=new ArrayList<IObserver>();
        //System.out.println(mylist.size());
        setPayment(new CashPayment());
    }
    public void add(IObserver x){
        mylist.add(x);
    }
    @Override
    public String updatnotify() {
        String str="";
        for (IObserver k:mylist)
        {
           str += k.update();
        }
        return str;
    }

    public Boolean isDrugAvailable(Drug drug) {
        return drugList.contains(drug);
    }

    public double getDrugPrice(Drug drug) {
        if (isDrugAvailable(drug))
            return drug.getPrice();
        else return -1;
    }

    public boolean addDrug(Drug drug) {
        drugList.add(drug);
        return true;
    }

    public Boolean removeDrug(Drug drug) {
        drugList.remove(drug);
        return true;
    }

    public Boolean pay() {
        return false;
    }

    public double getTax() {
        return payment.getTax();
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<Drug> drugList) {
        this.drugList = drugList;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
