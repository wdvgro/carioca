package Test;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Woudje {

    private JFrame frame;
    private JPanel panel;

    private DefaultListModel<Game> gameListModel;
    private JList<Game> gameList;

    private JButton playButton;
    private JButton addGamesButton;

    private JLabel serverStatusLabel;


    public Woudje() {
        frame = new JFrame("Start Screen");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        gameListModel = new DefaultListModel<>();
        gameList = new JList<>(gameListModel);

        JScrollPane scrollPane = new JScrollPane(gameList);
        scrollPane.setPreferredSize(new Dimension(300, 400));

        // Add games to the list directly in the constructor
        Game game1 = new Game("Game 1", "Description 1");
        Game game2 = new Game("Game 2", "Description 2");
        gameListModel.addElement(game1);
        gameListModel.addElement(game2);

        playButton = new JButton("Play");
        playButton.addActionListener(e -> {
            Game selectedGame = gameList.getSelectedValue();
            if (selectedGame != null) {
                // Implement the logic to start the selected game here
                // You can access the selected game using selectedGame
            }


        });

        serverStatusLabel = new JLabel("Server Status: Not Connected");

        addGamesButton = new JButton("Add Games");
        addGamesButton.addActionListener(e -> {
            // Implement the logic to add games to the list


            // You can add games to the gameListModel here
        });

        panel.add(scrollPane);
        panel.add(playButton);
        panel.add(serverStatusLabel);
        panel.add(addGamesButton);

        frame.add(panel);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Woudje();
    }

    // Custom class to represent a game
    private class Game {
        private String name;
        private String description;

        public Game(String name, String description) {
            this.name = name;
            this.description = description;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
