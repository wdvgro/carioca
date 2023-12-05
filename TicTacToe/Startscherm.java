import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Startscherm {

    private JFrame frame;
    private JPanel panel;

    private DefaultListModel<Game> gameListModel;
    private JList<Game> gameList;

    private JButton playButton;
    private JLabel label;

    public Startscherm() {

        frame = new JFrame("Start Screen");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        gameListModel = new DefaultListModel<>();
        gameList = new JList<>(gameListModel);

        JScrollPane scrollPane = new JScrollPane(gameList);
        scrollPane.setPreferredSize(new Dimension(300, 400));

        Game game1 = new Game("Tic Tac Toe", "Description 1");
        Game game2 = new Game("Dammen", "Description 2");
        gameListModel.addElement(game1);
        gameListModel.addElement(game2);
        new JScrollPane(gameList);

        playButton = new JButton("Play");

        playButton.setLayout(new BorderLayout());

        Dimension buttonSize = new Dimension(0, 100);
        playButton.setPreferredSize(buttonSize);

        playButton.setBackground(Color.GREEN);

        playButton.addActionListener(e -> {
            String selectedGame = String.valueOf(gameList.getSelectedValue());
            // Check the selected game and open the corresponding window
            if (selectedGame.equals("Tic Tac Toe")) {
                SwingUtilities.invokeLater(() -> {
                    TicTacToe ticTacToe = new TicTacToe();
                    ticTacToe.initialize();
                });
            } else if (selectedGame.equals("Zeeslag")) {
                // Open other game windows as needed
            }
        });

        label = new JLabel("Kies een spel om te spelen");
        Font customFont = new Font("Arial", Font.PLAIN, 24);
        label.setFont(customFont);
        int spacingSize = 20;
        label.setBorder(BorderFactory.createEmptyBorder(spacingSize, 0, spacingSize, 0));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(playButton, BorderLayout.SOUTH);
        panel.add(gameList);

        frame.add(panel);
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(0x398743));

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Startscherm::new);
    }

    public void show() {
        frame.setVisible(true);
    }
}
