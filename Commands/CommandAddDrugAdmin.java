package Commands;

import Controllers.AdminController;
import Controllers.IAdminControllers;
import Models.ICommandAdmin;
import Views.AddDrugView;

public class CommandAddDrugAdmin implements ICommandAdmin {
    IAdminControllers receiver;
    public CommandAddDrugAdmin(IAdminControllers receiver){this.receiver = receiver;}
//    public CommandAddDrugAdmin(AddDrugView v){
//        receiver = v;
//    }
    @Override
    public void executecommand() {
//        this.receiver=receiver;
    }

    @Override
    public void undocommand() {}
}
