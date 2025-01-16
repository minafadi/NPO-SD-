package Models;

public class VisaPayment implements Payment {
    private double tax;
    private String description="Invoice Paid by Visa Card";
    @Override
    public boolean executePayment(int amount) {
        description = "Invoice Paid by Visa Card : "+amount+" LE";
        return true;
    }

    @Override
    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
