import Classes.DB;
import GUI_Page.AdminPage;
import GUI_Page.AppointmentPage;
import GUI_Page.DoctorsListPage;
import GUI_Page.LoginPage;
import Classes.*;
import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        DB db = new DB();
        Connection c = db.ConnectDB();
        System.out.println("Connected to database");
//        AdminPage a = new AdminPage();
        AppointmentPage a = new AppointmentPage();
        a.setVisible(true);
//        DoctorsListPage d = new DoctorsListPage();
        //d.setVisible(true);
//        LoginPage l = new LoginPage();
//        l.setVisible(true);
        //Patient p = new Patient("matwa","1234");
        //Patient p2 = new Patient("karim","1234",22,true,"1234");

    }
}