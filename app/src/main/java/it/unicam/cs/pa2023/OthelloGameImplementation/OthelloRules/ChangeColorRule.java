package it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules;

import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloBoard;
import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRule;
import it.unicam.cs.pa2023.boardGamesLibrary.*;
import java.util.*;

/**
 * This class extends the OthelloRule class implementing the ChangeColor rule.
 */
public class ChangeColorRule extends OthelloRule {

    public ChangeColorRule() {
        super();
    }

    /**
     * Given a piece, an othelloBoard and a coordinate, this method first checks the neighboring cells of the given coordinate
     * and, if it finds the opponent pieces, takes all the opponent pieces in that direction that end with a piece of the same
     * color of the given piece, and changes their color to the color of the given piece. Returns true if at least one cell changed
     * color, false otherwise.
     *
     * @param piece The piece whose color is to be applied to the other pieces on the board.
     * @param board The current Othello board.
     * @param coordinate The coordinate of the cell whose neighboring cells are to be checked.
     * @return true if the color of at least one piece is changed, false otherwise.
     */
    @Override
    public boolean applyRule(Piece piece, OthelloBoard board, Coordinate coordinate) {
        boolean colorChanged = false;
        for(Optional<Cell> cell : board.getCellNeighbours(coordinate)){
            if(cell.isPresent()){
                if(cell.get().getPieceOptional().isPresent()){
                    if(cell.get().getPieceOptional().get().getColor() != piece.getColor()){
                        Integer[] direction = board.getDirection(coordinate,cell.get().getCoordinate());
                        ArrayList<Cell> cellsFromOneDirection = board.getCellsFromDirection(coordinate, direction);
                        if(board.checkCellsColorOneDirection(cellsFromOneDirection, piece.getColor()) != null){
                            colorChanged = true;
                            changePieceColor(Objects.requireNonNull(board.checkCellsColorOneDirection(cellsFromOneDirection, piece.getColor())),piece.getColor());
                        }
                    }
                }
            }
        }
        return colorChanged;
    }

    /**
     * Given a list of cells and a color, it changes the color of all the pieces in the
     * given list with the color passed.
     *
     * @param cells the cells with the pieces that are going to change color.
     * @param color the color to be given to the pieces.
     */
    private void changePieceColor(ArrayList<Cell> cells, Colors color){
        for (Cell cell: cells) {
            if(cell.getPieceOptional().isPresent()){
                cell.getPieceOptional().get().setColor(color);
            }
        }
    }

}
