
package Models;

public class FawryPayment implements Payment {
    private double tax;
    private String description="Invoice Paid by Fawry";

    @Override
    public boolean executePayment(int amount) {
        description = "Invoice Paid by Fawry : "+amount + "LE";
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
