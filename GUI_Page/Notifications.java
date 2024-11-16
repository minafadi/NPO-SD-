package GUI_Page;

import Classes.Invoice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notifications extends JFrame{
    public JTextArea textArea1;
    private JPanel notif;

    public Notifications(){
        setContentPane(notif);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);


    }
}
