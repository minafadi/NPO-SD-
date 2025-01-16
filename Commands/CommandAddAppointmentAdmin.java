package Commands;

import Controllers.AdminController;
import Models.ICommandAdmin;
import Views.*;
public class CommandAddAppointmentAdmin implements ICommandAdmin {
    AppointmentView receiver;
    public CommandAddAppointmentAdmin(){}
    public CommandAddAppointmentAdmin(AppointmentView v){
        receiver = v;
    }

    @Override
    public void executecommand() {
        receiver.setVisible(true);
    }

    @Override
    public void undocommand() {
        receiver.setVisible(false);
    }
}
