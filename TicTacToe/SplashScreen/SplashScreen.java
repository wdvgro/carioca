import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.Socket;

public class SplashScreen {
    private final JWindow window;
    private JLabel statusLabel;
    private JProgressBar progressBar;
    private long startTime;
    private int minimumMilliseconds;

    public SplashScreen() {
        window = new JWindow();
        var originalImage = new ImageIcon("C:\\Users\\Mbhst\\IdeaProjects\\GamerServer\\src\\GameLogo3.png").getImage();

        int scaledWidth = 719;
        int scaledHeight = 719;


        var scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        var image = new ImageIcon(scaledImage);

        window.getContentPane().setLayout(new BorderLayout());
        window.getContentPane().add(new JLabel("", image, SwingConstants.CENTER), BorderLayout.CENTER);


        statusLabel = new JLabel("Verbinding maken met de server...");
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

    public void connectToServer() {
        statusLabel.setText("Verbinding maken met de server...");
        progressBar.setIndeterminate(true);

        String serverHost = "localhost";
        int serverPort = 7789;

        try {
            Socket socket = new Socket(serverHost, serverPort);
            statusLabel.setText("Succesvol verbinding gemaakt met de server!");
            progressBar.setIndeterminate(false);
            socket.close();
        } catch (IOException e) {
            statusLabel.setText("Kan geen verbinding maken met de server: " + e.getMessage());
            progressBar.setIndeterminate(false);
            System.err.println("Kan niet verbinden met de server: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SplashScreen splash = new SplashScreen();
        splash.show(3000);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        splash.hide();

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
            JButton connectionStatusButton = new JButton("Verbinden");
            connectionStatusPanel.add(connectionStatusLabel);
            connectionStatusPanel.add(connectionStatusButton);
            mainPanel.add(connectionStatusPanel, BorderLayout.CENTER);

            JButton connectedButton = new JButton("Online");
            connectedButton.setBackground(Color.GREEN);
            connectedButton.setVisible(false);

            JPanel statusButtonPanel = new JPanel();
            statusButtonPanel.add(connectedButton);
            mainPanel.add(statusButtonPanel, BorderLayout.SOUTH);

            connectionStatusButton.addActionListener(e -> {
                if (attemptServerConnection()) {
                    connectionStatusLabel.setText("Verbonden met de server!");
                    connectionStatusButton.setVisible(false);
                    connectedButton.setVisible(true);
                } else {
                    connectionStatusLabel.setText("Kan niet verbinden met de server");
                }
            });


            mainFrame.add(mainPanel);

            mainFrame.setVisible(true);
        });
    }


    private static boolean attemptServerConnection() {
        String serverHost = "localhost";
        int serverPort = 7789;

        try {
            Socket socket = new Socket(serverHost, serverPort);
            socket.close();
            return true;
        } catch (IOException e) {
            System.err.println("Kan niet verbinden met de server: " + e.getMessage());
            return false;
        }
    }
}