package Commands;

import Controllers.AdminController;
import Models.ICommandAdmin;
import Views.AdminView;

public class CommandHomeAdmin implements ICommandAdmin {
    static AdminView receiver;
    public CommandHomeAdmin(){}
    public CommandHomeAdmin(AdminView v){
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
