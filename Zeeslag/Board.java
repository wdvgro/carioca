package Zeeslag;

import java.util.ArrayList;

public class Board {
    /**
     * Creates a 2d grid in an array with the coordinates in it
     */
    private ArrayList board = new ArrayList<>();
    private int nrOfRows;
    private int nrOfColumns;


    public Board(int nrOfRows, int nrOfColumns) {
        this.nrOfRows = nrOfRows;
        this.nrOfColumns = nrOfColumns;
        createGrid(nrOfRows,nrOfColumns);
    }

    public void createGrid(int rows, int columns) {
        // Iterate through rows
        for (int i = 0; i < rows; i++) {
            // Iterate through columns
            for (int j = 0; j < columns; j++) {
                // Print the grid element (you can modify this to create your grid structure)
                String gridentry = "[" + i + "," + j + "]";
                this.board.add(gridentry);
            }
            this.board.add("\n");
        }
    }

    public static boolean checkMoveLegality(int[] startCoordinate, int[] endCoordinate){
        /**
         * returns true if move is legal, false if move is illegal
         *
         */
        return true;
    }

    public int getNrOfColumns() {
        return nrOfColumns;
    }

    public int getNrOfRows() {
        return nrOfRows;
    }

    @Override
    public String toString() {
        return board.toString();
    }


}