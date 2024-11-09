import Classes.DB;
import GUI_Page.*;
import GUI_Page.AddDrug;
import GUI_Page.DoctorsListPage;
import GUI_Page.LoginPage;
import Classes.*;
import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
//        DB db = new DB();
//        Connection c = db.ConnectDB();
//        System.out.println("Connected to database");
        AddDoctorPage a = new AddDoctorPage();
        //a.setVisible(true);
//        AdminPage a = new AdminPage();
//        AppointmentPage a = new AppointmentPage();
//        a.setVisible(true);
//        DoctorsListPage d = new DoctorsListPage();
        //Illness i= new InfectiousIllness();

        //DoctorsListPage d = new DoctorsListPage();
        //d.setVisible(true);
        LoginPage l = new LoginPage();
        l.setVisible(true);
        //Patient p = new Patient("matwa","1234");
        //Patient p2 = new Patient("karim","1234",22,true,"1234");
        //Drug drug = new Drug("Augmantin",150,23.5);
        //AddDrug ad = new AddDrug();
        //ad.setVisible(true);
    }
}