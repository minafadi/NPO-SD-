package Models;

public interface Payment {
    public boolean executePayment();

    public double getTax();

    public String getDescription();
}
