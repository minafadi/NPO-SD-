package Controllers;
import Models.ICommandAdmin;
import Commands.CommandHomeAdmin;
import Views.*;
public class AdminController {
    static public ICommandAdmin command;
    public AdminController() {
        command = new CommandHomeAdmin(new AdminView());
    }

    static public void setCommand(ICommandAdmin c){
        command = c;
    }

    static public void ExecuteCommand(){
        command.executecommand();
    }

    static public void UndoCommand(){
        command.undocommand();
    }

}
