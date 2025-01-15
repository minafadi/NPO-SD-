package Controllers;

import Models.Doctor;
import Models.User;
import Views.AddDoctorView;

public class AddDoctorController {
    private Doctor DocModel;

    public Doctor AddNewDoctor(String name, String phoneNumeber, String specialization, String degree, int graduationYear, double salary, String password){
        DocModel = new Doctor(name, phoneNumeber, specialization, degree, graduationYear, salary, password);
        return DocModel;
    }
}
