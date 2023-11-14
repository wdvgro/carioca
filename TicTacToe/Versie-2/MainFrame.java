import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame {
    public MainFrame() {
        JFrame mainFrame = new JFrame("Carioca AI");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
        mainFrame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel textLabel = new JLabel("Welcome to Carioca AI");
        textLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(textLabel, BorderLayout.NORTH);

        ConnectionPanel connectionPanel = new ConnectionPanel();
        mainPanel.add(connectionPanel, BorderLayout.CENTER);

        JButton connectedButton = new JButton("Online");
        connectedButton.setBackground(Color.GREEN);
        connectedButton.setVisible(false);

        StatusButtonPanel statusButtonPanel = new StatusButtonPanel(connectedButton);
        mainPanel.add(statusButtonPanel, BorderLayout.SOUTH);

        connectionPanel.setConnectActionListener(() -> {
            String serverHost = connectionPanel.getHostField().getText();
            int serverPort = Integer.parseInt(connectionPanel.getPortField().getText());

            if (ConnectionUtil.attemptServerConnection(serverHost, serverPort)) {
                connectionPanel.getConnectionStatusLabel().setText("Connected to the server!");
                connectionPanel.getConnectButton().setVisible(false);
                connectedButton.setVisible(true);

                // Open de TicTacToe window
                TicTacToe tttWindow = new TicTacToe();
                tttWindow.initialize();

                // Sluit window
                mainFrame.setVisible(false);
            } else {
                connectionPanel.getConnectionStatusLabel().setText("Cannot connect to the server: Connection refused");
            }
        });

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}
