package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.boardGamesLibrary.Cell;
import it.unicam.cs.pa2023.boardGamesLibrary.Colors;
import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import it.unicam.cs.pa2023.boardGamesLibrary.DefaultBoard;

import java.util.ArrayList;

/**
 * This class extends the DefaultBoard class implementing an OthelloBoard.
 */
public class OthelloBoard extends DefaultBoard {

    public OthelloBoard(int width, int height, int numberOfBoard) {
        super(width, height, numberOfBoard);
    }

    /**
     * Given the coordinate of the current cell and the neighbouring cell, returns an array of integers
     * that represents the direction of the neighbour coordinate from the actual coordinate.
     *
     * @param actualCoordinate The coordinate of the current cell.
     * @param neighbourCoordinate The coordinate of the neighbouring cell.
     * @return The direction of the neighbour from the actual coordinate.
     */
    public Integer[] getDirection(Coordinate actualCoordinate, Coordinate neighbourCoordinate){
        Integer[] direction = new Integer[3];
        direction[0] = neighbourCoordinate.getX() - actualCoordinate.getX();
        direction[1] = neighbourCoordinate.getY() - actualCoordinate.getY();
        direction[2] = 0;
        return direction;
    }

    /**
     * Given an array of cells and a color, and returns an array of cells that have a
     * piece of the same color as the input color.
     *
     * @param cells The cells that are being checked.
     * @param color color of the pieces of which we want the cells.
     * @return ArrayList of cells with pieces of the same color as the color given in input.
     */
    public ArrayList<Cell> checkCellsColorOneDirection(ArrayList<Cell> cells, Colors color){
        ArrayList<Cell> temp = new ArrayList<>();
        for(Cell cell: cells){
            if(cell.hasPiece()){
                if(cell.getPieceOptional().get().getColor() != color){
                    temp.add(cell);
                }else{
                    return temp;
                }
            }else{
                return null;
            }
        }
        return null;
    }



}
