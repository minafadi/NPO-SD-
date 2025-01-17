package Controllers;

import Models.DBProxy;
import Models.Doctor;
import Models.ICommandAdmin;
import Views.AddDoctorView;

public class AddDoctorController implements ICommandAdmin {
    private static Doctor DocModel;
    private AddDoctorView addDoctorView;
    static DBProxy dbProxy;

    @Override
    public void executecommand() {
        addDoctorView = new AddDoctorView();
        addDoctorView.setVisible(true);
    }

    @Override
    public void undocommand() {
        this.addDoctorView.setVisible(false);
    }

    public AddDoctorController(DBProxy dbProxy) {
        this.dbProxy = dbProxy;
    }

    public static String AddNewDoctor(String name, String phoneNumeber, String specialization, String degree, int graduationYear, double salary, String password){
        DocModel = new Doctor(name, phoneNumeber, specialization, degree, graduationYear, salary, password, dbProxy);

        String docID = String.valueOf(DocModel.getDRid());
        return docID;
    }
}
