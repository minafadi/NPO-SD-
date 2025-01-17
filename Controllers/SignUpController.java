package Controllers;

import Models.DBProxy;
import Models.Patient;
import Views.SignUpView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController {
    SignUpView view;
    Patient patient;
    DBProxy dbProxy;

    // Constructor with DBProxy dependency injection
    public SignUpController(DBProxy dbProxy) {
        this.view = new SignUpView();
        this.view.setVisible(true);
        this.dbProxy = dbProxy;
        initialize();
    }

    private void initialize() {
        // Set up the action listener for the sign-up button
        view.getSignUpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve data from the view
                String name = view.getTextField1().getText();
                String phone = view.getTextField2().getText();
                int age = Integer.parseInt(view.getTextField3().getText());


                String password = new String(view.getPasswordField1().getPassword());
                String confirmPassword = new String(view.getPasswordField2().getPassword());
                boolean gender = view.getMaleRadioButton().isSelected();

                // Check if the passwords match
                if (!password.equals(confirmPassword)) {
//                    view.showMessage("Passwords do not match.");
                    return;
                }

                // Create a new patient object if validation passes
                patient = new Patient(name, phone, age, gender, password, dbProxy);
                view.setVisible(false);
                // Optionally, you can add code to save the patient to the database, etc.
//                view.showMessage("Sign-up successful!");
            }
        });
    }
}
