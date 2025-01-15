package Views;

import Models.Drug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrugView extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTextField textField3;
    String value1;
    int value2;
    double value3;
    private JPanel addrug;
    private JComboBox comboBox1;
    String Value4;

    public AddDrugView() {
        setContentPane(addrug);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Convert textField1 to String
                    value1 = textField1.getText();
                    Value4=(String) comboBox1.getSelectedItem();
                    // Convert textField2 to int
                    value2 = Integer.parseInt(textField2.getText());

                    // Convert textField3 to double
                    value3 = Double.parseDouble(textField3.getText());

                    // Now you can use value1, value2, and value3 as needed
                    Drug dd=new Drug(value1,value2,value3,Value4);
                } catch (NumberFormatException ee) { // Fully specify the exception class
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values for fields 2 and 3.");
                    ee.printStackTrace();
                }
            }
        });
    }
}
