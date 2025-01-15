package Controllers;
import Views.*;

public class NotificationsController {
    public NotificationsController(String s) {
        NotificationsView Not =new NotificationsView();
        Not.textArea1.setText(s);
        Not.setVisible(true);
    }
}
