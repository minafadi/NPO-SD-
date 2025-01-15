package Views;

import Controllers.AddDrugController;
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
    private JPanel addrug;
    private JComboBox comboBox1;

    String drugName;
    int quantity;
    double price;
    String treatment;

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
                    drugName = textField1.getText();

                    treatment =(String) comboBox1.getSelectedItem();

                    // Convert textField2 to int
                    quantity = Integer.parseInt(textField2.getText());

                    // Convert textField3 to double
                    price = Double.parseDouble(textField3.getText());

                    // Adding a new Drug
                    AddDrugController addDrugController = new AddDrugController();
                    Drug drug = addDrugController.AddNewDrug(drugName,quantity,price,treatment);



                } catch (NumberFormatException ee) { // Fully specify the exception class
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values for fields 2 and 3.");
                    ee.printStackTrace();
                }
            }
        });
    }
}
