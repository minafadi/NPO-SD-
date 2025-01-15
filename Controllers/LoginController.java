package Controllers;
import Models.*;
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
            Patient p = new Patient(name,password);
            ConcreteIllnessController ConcreteIllnessController= new ConcreteIllnesscontroller(p);

        }
        else if(selecteditem == "Admin" && Admin.AuthenticateAdmin(name,password)){
            AdminController adminController=new AdminController();
        }


    }
}
