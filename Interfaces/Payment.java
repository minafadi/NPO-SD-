package Interfaces;

public interface Payment {
    public boolean executePayment();

    public double getTax();

    public String getDescription();
}
