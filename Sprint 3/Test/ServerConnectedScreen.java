package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerConnectedScreen {
    private static boolean isConnectedToServer = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Server Connected Screen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

            JButton openNewScreenButton = new JButton("Open New Screen");


            openNewScreenButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isConnectedToServer) {
                        // Open the new screen or window here
                        JOptionPane.showMessageDialog(frame, "Opening the new screen...");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Not connected to the server.");
                    }
                }
            });

            JButton connectToServerButton = new JButton("Connect to Server");

            connectToServerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Simulate a connection to the server
                    isConnectedToServer = true;
                    JOptionPane.showMessageDialog(frame, "Connected to the server.");
                }
            });

            panel.add(openNewScreenButton);
            panel.add(connectToServerButton);

            frame.add(panel);
            frame.setSize(300, 150);
            frame.setVisible(true);
        });
    }
}

