package Controllers;
import Commands.CommandAddAppointmentAdmin;
import Models.DBProxy;
import Models.ICommandAdmin;
import Views.AdminView;

public class AdminController{
    static DBProxy dbProxy = new DBProxy(1);
    static public ICommandAdmin command = new CommandAddAppointmentAdmin(new AppointmentController(AdminController.getDbProxy()));
    AdminView view;

    public AdminController() {
        this.view = new AdminView();
        this.view.setVisible(true);
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

    static public DBProxy getDbProxy(){return dbProxy;}

}
