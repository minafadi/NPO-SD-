public class VisaPayment implements Payment {
    private double tax;
    private String description;

    @Override
    public Boolean executePayment() {
        throw new UnsupportedOperationException("Unimplemented method 'executePayment'");
    }

    @Override
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