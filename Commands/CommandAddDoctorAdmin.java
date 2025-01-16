package Commands;

import Controllers.AdminController;
import Models.ICommandAdmin;
import Views.AddDoctorView;

public class CommandAddDoctorAdmin implements ICommandAdmin {
    AddDoctorView receiver;
    public CommandAddDoctorAdmin(){}
    public CommandAddDoctorAdmin(AddDoctorView v){
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
