package it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules;

import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloBoard;
import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRule;
import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import it.unicam.cs.pa2023.boardGamesLibrary.Piece;

import java.util.Optional;

public class InsertPieceRule extends OthelloRule {


    public InsertPieceRule() {
        super();
    }

    @Override
    public boolean applyRule(Piece piece, OthelloBoard board, Coordinate coordinate) {
        if(board.getCellFromCoordinate(coordinate).isPresent()){
            if(board.getCellFromCoordinate(coordinate).get().getPieceOptional().isEmpty()){
                this.getAction().doAction(Optional.empty(),Optional.of(coordinate),board,piece);
                return true;
            }
        }
        return false;
    }
}
