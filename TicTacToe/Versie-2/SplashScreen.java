import javax.swing.*;
import java.awt.*;
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
        var originalImage = new ImageIcon("C:\\Users\\Mbhst\\IdeaProjects\\GamerServer\\src\\GameLogo3.png").getImage();

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
        splash.hide();

        // Creating and showing the main frame
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
