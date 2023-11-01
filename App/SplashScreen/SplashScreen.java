package SplashScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.Socket;
import java.net.ConnectException;

public class SplashScreen {
    private final JWindow window;
    private JLabel statusLabel;
    private JProgressBar progressBar;
    private long startTime;
    private int minimumMilliseconds;

    public SplashScreen() {
        window = new JWindow();
        var originalImage = new ImageIcon("/Users/gustavocostaaraujo/Documents/College/2ᵉ Jaar/Intelligente systemen I & II/Project Intelligente Systemen I & II/carioca/Sprint 3/Bashar/GameLogo3.png").getImage();

        int scaledWidth = 719;
        int scaledHeight = 719;

        var scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        var image = new ImageIcon(scaledImage);

        window.getContentPane().setLayout(new BorderLayout());
        window.getContentPane().add(new JLabel("", image, SwingConstants.CENTER), BorderLayout.CENTER);

        statusLabel = new JLabel("Loading application...");
        statusLabel.setBackground(Color.GREEN);
        statusLabel.setOpaque(true);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        window.getContentPane().add(statusLabel, BorderLayout.SOUTH);

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setBackground(Color.DARK_GRAY);
        window.getContentPane().add(progressBar, BorderLayout.NORTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setBounds((int) ((screenSize.getWidth() - image.getIconWidth()) / 2),
                (int) ((screenSize.getHeight() - image.getIconHeight()) / 2),
                image.getIconWidth(), image.getIconHeight());

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

    public void scherm(){


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Carioca AI");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(800, 600); // Set your desired size
            mainFrame.setLocationRelativeTo(null);

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

            mainFrame.add(mainPanel);

            mainFrame.setVisible(true);
        });

    }

    public void show(int minimumMilliseconds) {
        this.minimumMilliseconds = minimumMilliseconds;
        window.setVisible(true);
        startTime = System.currentTimeMillis();
    }

    public void hide() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        try {
            Thread.sleep(Math.max(minimumMilliseconds - elapsedTime, 0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
    }

    public static void main(String[] args) {
        SplashScreen splash = new SplashScreen();
        splash.show(3000);
        splash.scherm();
        splash.hide();
    }
}