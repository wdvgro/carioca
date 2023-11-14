import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class ServerConnectScreen extends JFrame {

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
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            JLabel textLabel = new JLabel("Welkom bij Carioca AI");
            textLabel.setFont(new Font("Arial", Font.PLAIN, 25)); // Set font size to 25px
            textLabel.setHorizontalAlignment(SwingConstants.CENTER);
            mainPanel.add(textLabel, BorderLayout.NORTH);

            JPanel connectionStatusPanel = new JPanel();
            JLabel connectionStatusLabel = new JLabel("Verbinding maken met de server...");
            JTextField hostField = new JTextField("localhost", 15); // Default host
            JTextField portField = new JTextField("7789", 5); // Default port
            JButton connectionStatusButton = new JButton("Verbinden");

            connectionStatusPanel.add(connectionStatusLabel);
            connectionStatusPanel.add(hostField);
            connectionStatusPanel.add(portField);
            connectionStatusPanel.add(connectionStatusButton);
            mainPanel.add(connectionStatusPanel, BorderLayout.CENTER);

            JButton connectedButton = new JButton("Online");
            connectedButton.setBackground(Color.GREEN);
            connectedButton.setVisible(false);

            JPanel statusButtonPanel = new JPanel();
            statusButtonPanel.add(connectedButton);
            mainPanel.add(statusButtonPanel, BorderLayout.SOUTH);

            connectionStatusButton.addActionListener(e -> {
                String serverHost = hostField.getText();
                int serverPort = Integer.parseInt(portField.getText());

                if (attemptServerConnection(serverHost, serverPort)) {
                    connectionStatusLabel.setText("Verbonden met de server!");
                    connectionStatusButton.setVisible(false);
                    connectedButton.setVisible(true);
                } else {
                    connectionStatusLabel.setText("Kan niet verbinden met de server: Connection refused");
                }
            });

            this.getContentPane().add(mainPanel);
        });
    }

    private void initializeServerConnectScreen() {
        setTitle("Server Connection");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        scherm(); // Call the scherm() method to display the server connection screen
    }
}
