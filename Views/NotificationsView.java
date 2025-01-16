package Views;

import javax.swing.*;
import java.awt.*;

public class NotificationsView extends JFrame{
    public JTextArea textArea1;
    private JPanel notif;

    public NotificationsView(){
        setContentPane(notif);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);


    }
}
