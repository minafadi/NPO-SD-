package Controllers;
import Views.*;
public class AdminController {
    private AdminView AV;
    public AdminController() {
        AV = new AdminView();
        AV.setVisible(true);
    }
}
