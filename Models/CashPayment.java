package Models;

import javax.management.Descriptor;

public class CashPayment{
    private double tax;
    private String description="Invoice Paid using Cash Method";


    public String DelegatePayement() {
        return "Payment Delegated after Appointment";
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
