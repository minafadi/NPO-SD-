package Controllers;

import Models.DBProxy;
import Models.Doctor;
import Views.AddDoctorView;

public class AddDoctorController {
    private static Doctor DocModel;
    private AddDoctorView addDoctorView;
    static DBProxy dbProxy;

    public AddDoctorController(DBProxy dbProxy) {
        addDoctorView = new AddDoctorView();
        addDoctorView.setVisible(true);
        this.dbProxy = dbProxy;
    }

    public static String AddNewDoctor(String name, String phoneNumeber, String specialization, String degree, int graduationYear, double salary, String password){
        DocModel = new Doctor(name, phoneNumeber, specialization, degree, graduationYear, salary, password, dbProxy);

        String docID = String.valueOf(DocModel.getDRid());
        return docID;
    }
}
