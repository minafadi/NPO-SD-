package Commands;

import Controllers.AdminController;
import Models.ICommandAdmin;
import Views.AddDrugView;

public class CommandAddDrugAdmin implements ICommandAdmin {
    AddDrugView receiver;
    public CommandAddDrugAdmin(){}
    public CommandAddDrugAdmin(AddDrugView v){
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
