package it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules;

import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloBoard;
import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRule;
import it.unicam.cs.pa2023.boardGamesLibrary.*;

import java.util.*;

public class ChangeColorRule extends OthelloRule {

    @Override
    public boolean applyRule(Piece piece, OthelloBoard board, Coordinate coordinate) {
        boolean colorChanged = false;
        for(Optional<Cell> cell : board.getCellNeighbours(coordinate)){
            if(cell.isPresent()){
                if(cell.get().getPieceOptional().isPresent()){
                    if(cell.get().getPieceOptional().get().getColor() != piece.getColor()){
                        Integer[] direction = board.getDirection(coordinate,cell.get().getCoordinate());
                        ArrayList<Cell> cellsFromOneDirection = board.getCellsFromDirection(coordinate, direction);
                        if(board.checkCellsColorOneDirection(cellsFromOneDirection,piece.getColor()) != null){
                            colorChanged = true;
                            changePieceColor(Objects.requireNonNull(board.checkCellsColorOneDirection(cellsFromOneDirection, piece.getColor())),piece.getColor());
                        }
                    }
                }
            }
        }
        return colorChanged;
    }

    private void changePieceColor(ArrayList<Cell> cells, Colors color){
        for (Cell cell: cells) {
            if(cell.getPieceOptional().isPresent()){
                cell.getPieceOptional().get().setColor(color);
            }
        }
    }




}
