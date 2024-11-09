package GUI_Page;

import Classes.Drug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrug extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTextField textField3;
    String value1;
    int value2;
    double value3;
    private JPanel addrug;

    public AddDrug() {
        setContentPane(addrug);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Convert textField1 to String
                    value1 = textField1.getText();

                    // Convert textField2 to int
                    value2 = Integer.parseInt(textField2.getText());

                    // Convert textField3 to double
                    value3 = Double.parseDouble(textField3.getText());

                    // Now you can use value1, value2, and value3 as needed
                    Drug dd=new Drug(value1,value2,value3);
                } catch (NumberFormatException ee) { // Fully specify the exception class
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values for fields 2 and 3.");
                    ee.printStackTrace();
                }
            }
        });
    }
}
