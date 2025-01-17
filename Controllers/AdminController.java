package Controllers;
import Commands.CommandAddAppointmentAdmin;
import Models.Admin;
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

    static public void DeleteDoctor(int id){
        Admin.deleteDoctor(id);
        return;
    }
    static public void DeleteDrug(String name){
        Admin.deleteDrug(name);
    }
    static public void DeleteApp(int id){
        Admin.deleteApp(id);
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
