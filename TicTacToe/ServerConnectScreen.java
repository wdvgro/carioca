import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class ServerConnectScreen extends JFrame {

    // Add this declaration
    private JFrame frame;

    public ServerConnectScreen() {
        initializeServerConnectScreen();
    }

    private static boolean attemptServerConnection(String serverHost, int serverPort) {
        try {
            Socket socket = new Socket(serverHost, serverPort);
            socket.close();
            return true;
        } catch (ConnectException e) {
            System.err.println("Kan niet verbinden met de server: Connection refused");
            return false;
        } catch (IOException e) {
            System.err.println("Kan niet verbinden met de server: " + e.getMessage());
            return false;
        }
    }



    public void scherm() {
        SwingUtilities.invokeLater(() -> {
            // Create and configure components for the server connection screen
            frame = new JFrame(); // Initialize the frame
            frame.setLayout(new BorderLayout());

            JLabel textLabel = new JLabel("Welkom bij Carioca AI");
            textLabel.setFont(new Font("Arial", Font.PLAIN, 25));
            textLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(textLabel, BorderLayout.NORTH);

            JPanel connectionStatusPanel = new JPanel();
            JLabel connectionStatusLabel = new JLabel("Verbinding maken met de server...");
            JTextField hostField = new JTextField("localhost", 15);
            JTextField portField = new JTextField("7789", 5);
            JButton connectionStatusButton = new JButton("Verbinden");
            JButton connectedButton = new JButton("Online");
            connectedButton.setBackground(Color.GREEN);
            connectedButton.setVisible(false);

            connectionStatusPanel.add(connectionStatusLabel);
            connectionStatusPanel.add(hostField);
            connectionStatusPanel.add(portField);
            connectionStatusPanel.add(connectionStatusButton);
            frame.add(connectionStatusPanel, BorderLayout.CENTER);

            JPanel statusButtonPanel = new JPanel();
            statusButtonPanel.add(connectedButton);
            frame.add(statusButtonPanel, BorderLayout.SOUTH);

            connectionStatusButton.addActionListener(e -> {
                String serverHost = hostField.getText();
                int serverPort = Integer.parseInt(portField.getText());

                if (attemptServerConnection(serverHost, serverPort)) {
                    connectionStatusLabel.setText("Verbonden met de server!");
                    connectionStatusButton.setVisible(false);
                    connectedButton.setVisible(true);

                    // After successful connection, open Startscherm
                    SwingUtilities.invokeLater(() -> {
                        Startscherm startscherm = new Startscherm();
                        startscherm.show();
                        frame.dispose();
                    });

                } else {
                    connectionStatusLabel.setText("Kan niet verbinden met de server: Connection refused");
                }
            });

            frame.setTitle("Server Connection");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            frame.setVisible(true); // Show the frame
        });
    }

    private void initializeServerConnectScreen() {
        // This method can remain empty or be used for any additional initialization
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ServerConnectScreen serverConnectScreen = new ServerConnectScreen();
            serverConnectScreen.scherm();
        });
    }
}
