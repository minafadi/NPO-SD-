package Classes;

import Interfaces.IObserver;
import Interfaces.InterfaceInvoice;

public class NotifybySMS implements IObserver {
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
