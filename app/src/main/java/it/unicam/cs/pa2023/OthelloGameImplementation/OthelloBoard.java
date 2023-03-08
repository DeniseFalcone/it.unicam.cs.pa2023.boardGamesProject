package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.boardGamesLibrary.Cell;
import it.unicam.cs.pa2023.boardGamesLibrary.Colors;
import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import it.unicam.cs.pa2023.boardGamesLibrary.DefaultBoard;

import java.util.ArrayList;

public class OthelloBoard extends DefaultBoard {
    public OthelloBoard(int width, int height, int numberOfBoard) {
        super(width, height, numberOfBoard);
    }

    public Integer[] getDirection(Coordinate actualCoordinate, Coordinate neighbourCoordinate){
        Integer[] direction = new Integer[3];
        direction[0] = neighbourCoordinate.getX() - actualCoordinate.getX();
        direction[1] = neighbourCoordinate.getY() - actualCoordinate.getY();
        direction[2] = Integer.valueOf(0);
        return direction;
    }

    /**
     * It takes an array of cells and a color, and returns an array of cells that are the same color as the input color
     *
     * @param cells The cells that are being checked for the color.
     * @param color The color of the piece that is being moved.
     * @return The method is returning an ArrayList of Cells.
     */
    public ArrayList<Cell> checkCellsColorOneDirection(ArrayList<Cell> cells, Colors color){
        ArrayList<Cell> temp = new ArrayList<>();
        for(Cell cell: cells){
            if(cell.getPieceOptional().isPresent()){
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
