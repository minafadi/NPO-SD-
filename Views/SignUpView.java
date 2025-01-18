package Views;

import javax.swing.*;
import java.awt.*;

public class SignUpView extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton signUpButton;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderButtonGroup;

    public SignUpView() {
        // Set up the frame
        setTitle("Sign Up");
        setSize(500, 500);  // Set a size for the window
        setLocationRelativeTo(null);  // Center the window on the screen
        setLayout(new GridLayout(10, 8));  // Use a GridLayout for positioning components

        // Initialize components
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        signUpButton = new JButton("Sign Up");
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        // Group the gender radio buttons
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        // Add components to the frame
        add(new JLabel("Name:"));
        add(textField1);
        add(new JLabel("Phone:"));
        add(textField2);
        add(new JLabel("Age:"));
        add(textField3);
        add(new JLabel("Password:"));
        add(passwordField1);
        add(new JLabel("Confirm Password:"));
        add(passwordField2);
        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        add(genderPanel);
        add(signUpButton);

        // Make the frame visible
        setVisible(true);
    }

    // Getter methods to access the components from the controller
    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public JPasswordField getPasswordField2() {
        return passwordField2;
    }

    public JRadioButton getMaleRadioButton() {
        return maleRadioButton;
    }

    public JRadioButton getFemaleRadioButton() {
        return femaleRadioButton;
    }
}
