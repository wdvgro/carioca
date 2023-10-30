package Beginscherm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Startscherm {

    private JFrame frame;
    private JPanel panel;

    private DefaultListModel<String> gameListModel;
    private JList <String> gameList;

    private JButton playButton;

    public Startscherm (){

        frame = new JFrame("Start Screen");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        DefaultListModel<String> gameListModel = new DefaultListModel<>();
        JList<String> gameList = new JList<>(gameListModel);
        JScrollPane scrollPane = new JScrollPane(gameList);
        panel.add(scrollPane, BorderLayout.CENTER);

        new JScrollPane(gameList);

        playButton = new JButton("Play");
        playButton.setLayout(new BorderLayout());
        playButton.addActionListener(e -> {

            String selectedGame = gameList.getSelectedValue();
            // Implement the logic to start the selected game here

        });


        panel.add(playButton,BorderLayout.SOUTH);
        panel.add(gameList);

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
