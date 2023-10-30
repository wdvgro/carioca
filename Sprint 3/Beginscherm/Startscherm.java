package Beginscherm;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Startscherm {

    private JFrame frame;
    private JPanel panel;

    private DefaultListModel<String> gameListModel;
    private JList <String> gameList;

    private JButton playButton;
    private JButton addGamesButton;

    private JLabel serverStatusLabel;


    public Startscherm (){

        frame = new JFrame("Start Screen");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        gameListModel = new DefaultListModel<>();
        gameList = new JList<>(gameListModel);

        new JScrollPane(gameList);

        playButton = new JButton("Play");
        playButton.setLayout(new FlowLayout());
        playButton.addActionListener(e -> {

            String selectedGame = gameList.getSelectedValue();
            // Implement the logic to start the selected game here

        });

        serverStatusLabel = new JLabel("Server Status: Not Connected");


        addGamesButton = new JButton("Add Games");
        addGamesButton.addActionListener(e -> {
            // Implement the logic to add games to the list
        });

        panel.add(gameList);
        panel.add(playButton);
        panel.add(serverStatusLabel);
        panel.add(addGamesButton);

        // Set layout manager and add components to the panel

        frame.add(panel);
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        new Startscherm();

    }

}
