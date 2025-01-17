package Commands;

import Controllers.IAdminControllers;
import Models.ICommandAdmin;

public class CommandAddAppointmentAdmin implements ICommandAdmin {
    ICommandAdmin receiver;
    public CommandAddAppointmentAdmin(ICommandAdmin receiver){this.receiver = receiver;}
//    public CommandAddAppointmentAdmin(AppointmentController v){
//        receiver = v;
//    }

    @Override
    public void executecommand() {}

    @Override
    public void undocommand() {}
}
