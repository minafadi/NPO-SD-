package Controllers;
import Models.*;
import Controllers.ConcreteIllnessController;
import Views.*;
public class LoginController {
    //private Patient patient;
    private LoginView view;

    public LoginController() {
        view = new LoginView();
        view.setVisible(true);
    }
    public static void login(String name, String password, String selecteditem){
        if(selecteditem == "Patient" && Patient.AuthenticatePatient(name,password)){
            Patient p = (Patient)UserFactory.createUser("Patient",name,password);
            ConcreteIllnessController ConcreteIllnessController= new ConcreteIllnessController(p);

        }
        else if(selecteditem == "Admin" && Admin.AuthenticateAdmin(name,password)){
            AdminController adminController=new AdminController();
            adminController.ExecuteCommand();
        }


    }
}
