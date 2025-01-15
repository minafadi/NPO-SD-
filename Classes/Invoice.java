package Classes;

import Interfaces.IObserver;
import Interfaces.InterfaceInvoice;
import Interfaces.Payment;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Invoice implements InterfaceInvoice {
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

    public static void insert(String name, String docname, Drug[] dd, double total) {
        String invoiceQuery = "INSERT INTO invoice (pname, dname, total) VALUES (?, ?, ?)";
        String invDrugsQuery = "INSERT INTO invdrugs (IId, Drugname) VALUES (?, ?)";

        try (
                // Prepare the statement for inserting into the invoice table
                PreparedStatement invoiceStmt = DB.getInstance().getConnection().prepareStatement(invoiceQuery, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            // Set parameters for the invoice table
            invoiceStmt.setString(1, name);
            invoiceStmt.setString(2, docname);
            invoiceStmt.setDouble(3, total);

            // Execute the insert into the invoice table
            invoiceStmt.executeUpdate();

            // Retrieve the generated invoice ID
            try (ResultSet generatedKeys = invoiceStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int invoiceId = generatedKeys.getInt(1); // Get the auto-generated ID

                    // Insert each drug into the invdrugs table
                    try (PreparedStatement invDrugsStmt = DB.getInstance().getConnection().prepareStatement(invDrugsQuery)) {
                        for (Drug drug : dd) {
                            String drugName = drug.getDrugName(); // Assuming getDrugName() exists in the Drug class
                            invDrugsStmt.setInt(1, invoiceId); // Set the foreign key
                            invDrugsStmt.setString(2, drugName); // Set the drug name
                            invDrugsStmt.executeUpdate();
                        }
                    }
                } else {
                    throw new SQLException("Failed to retrieve the generated invoice ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception (e.g., logging or throwing a custom exception)
        }
    }

}
