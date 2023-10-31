package Test;

import Beginscherm.Game;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Woudje {

    private JFrame frame;
    private JPanel panel;

    private DefaultListModel<Game> gameListModel;
    private JList<Game> gameList;

    private JButton playButton;


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

        panel.add(scrollPane);
        panel.add(playButton);

        frame.add(panel);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Woudje();
    }

}
