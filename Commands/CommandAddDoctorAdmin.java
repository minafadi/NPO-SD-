package Commands;

import Controllers.AdminController;
import Controllers.IAdminControllers;
import Models.ICommandAdmin;
import Views.AddDoctorView;

public class CommandAddDoctorAdmin implements ICommandAdmin {
    IAdminControllers receiver;
    public CommandAddDoctorAdmin(IAdminControllers receiver){this.receiver = receiver;}
//    public CommandAddDoctorAdmin(AddDoctorView v){
//        receiver = v;
//    }
    @Override
    public void executecommand() {}

    @Override
    public void undocommand() {}
}
