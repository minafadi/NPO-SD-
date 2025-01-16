package Models;

public class NotifybyEmail implements IObserver{
    InterfaceInvoice ref;


    public NotifybyEmail(InterfaceInvoice x)
    {
        ref=x;
        ref.add(this);
    }
    @Override
    public String update() {
        return "Notify By Email\n";
    }
}
