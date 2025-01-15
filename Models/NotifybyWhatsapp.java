package Models;

public class NotifybyWhatsapp implements IObserver{
    InterfaceInvoice ref;


    public NotifybyWhatsapp(InterfaceInvoice x)
    {
        ref=x;
        ref.add(this);
    }
    @Override
    public String update() {
        return "Notify By Whatsapp\n";
    }
}
