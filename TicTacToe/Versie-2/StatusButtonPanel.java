import javax.swing.*;
import java.awt.*;

public class StatusButtonPanel extends JPanel {
    public StatusButtonPanel(JButton connectedButton) {
        setLayout(new FlowLayout());
        add(connectedButton);
    }
}
