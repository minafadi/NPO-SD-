package Controllers;

import Models.Doctor;
import Views.AddDoctorView;

public class AddDoctorController {
    private static Doctor DocModel;
    private AddDoctorView addDoctorView;

    public AddDoctorController() {
        addDoctorView = new AddDoctorView();
        addDoctorView.setVisible(true);
    }

    public static String AddNewDoctor(String name, String phoneNumeber, String specialization, String degree, int graduationYear, double salary, String password){
        DocModel = new Doctor(name, phoneNumeber, specialization, degree, graduationYear, salary, password);

        String docID = String.valueOf(DocModel.getDRid());
        return docID;
    }
}
