package Controllers;
import Models.*;
import Controllers.ConcreteIllnessController;
import Views.*;
public class LoginController {
    //private Patient patient;
    private LoginView view;
    static DBProxy dbProxy;

    public LoginController() {
        view = new LoginView();
        view.setVisible(true);
    }
    public static void login(String name, String password, String selecteditem) {
        if (selecteditem == "Patient") {
            dbProxy = new DBProxy(0);
//            if (Patient.AuthenticatePatient(name, password, dbProxy)) {
//                Patient p = new Patient(name, password, dbProxy);
//                ConcreteIllnessController ConcreteIllnessController = new ConcreteIllnessController(p, dbProxy);
//            }
            if (selecteditem == "Patient" && Patient.AuthenticatePatient(name, password, dbProxy)) {
                Patient p = (Patient) UserFactory.createUser("Patient", name, password,dbProxy);
                ConcreteIllnessController ConcreteIllnessController = new ConcreteIllnessController(p, dbProxy);

            }


        }
        else if (selecteditem == "Admin" && Admin.AuthenticateAdmin(name, password)) {
            AdminController adminController = new AdminController();
//            AdminController adminController=new AdminController();
            adminController.ExecuteCommand();
        }
    }

    public static void signUp(){
        new SignUpController(new DBProxy(0));
    }
}
