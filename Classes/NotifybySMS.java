package Classes;

public class NotifybySMS implements IObserver{
    InterfaceInvoice ref;


    public NotifybySMS(InterfaceInvoice x)
    {
        ref=x;
        ref.add(this);
    }
    @Override
    public String update() {
        return "Notify By SMS\n";
    }
}
