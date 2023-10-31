package Beginscherm;

// Custom class to represent a game
public class Game {

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