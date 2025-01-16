package Models;

public interface Payment {
    public boolean executePayment(int amount);

    public double getTax();

    public String getDescription();
}
