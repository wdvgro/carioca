package Test;

import javax.swing.*;
import java.awt.*;

public class JLabelAndJListSpacingExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Label and List Spacing Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout to stack components vertically

            JLabel label = new JLabel("Label:flnlrefnlrjnflr");
            JList<String> list = new JList<>(new DefaultListModel<>());

            // Add some space between the label and the list using rigid areas
            panel.add(Box.createRigidArea(new Dimension(0, 10))); // 10 pixels of vertical spacing
            panel.add(label);
            panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add more spacing
            panel.add(list);
            panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add final spacing

            frame.add(panel);
            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}
