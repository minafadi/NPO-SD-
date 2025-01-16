package Models;

public class CashPaymentAdapter implements Payment{
    CashPayment Adaptee;
    public String description="Invoice Paid using Cash Method";
    public CashPaymentAdapter(CashPayment c ){
        Adaptee = c;
    }
    @Override
    public boolean executePayment(int amount) {
        description = Adaptee.DelegatePayement();
        return false;
    }

    @Override
    public double getTax() {
        return 0;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
