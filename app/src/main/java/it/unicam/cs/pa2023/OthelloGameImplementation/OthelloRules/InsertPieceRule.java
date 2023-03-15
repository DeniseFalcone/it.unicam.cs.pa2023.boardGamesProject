package it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules;

import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloBoard;
import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRule;
import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import it.unicam.cs.pa2023.boardGamesLibrary.Piece;
import java.util.Optional;

/**
 * This class extends the OthelloRule class implementing the InsertPiece rule.
 */
public class InsertPieceRule extends OthelloRule {


    public InsertPieceRule() {
        super();
    }

    /**
     * Given a piece, an othelloBoard and a coordinate, if the cell at the given coordinate is free, insert the
     * given piece and return true, otherwise return false.
     *
     * @param piece The piece that is being placed.
     * @param board The board that the piece is being placed on.
     * @param coordinate The coordinate that the piece is going to be placed in.
     * @return true if the color of at least one piece is changed, false otherwise.
     */
    @Override
    public boolean applyRule(Piece piece, OthelloBoard board, Coordinate coordinate) {
        if(board.getCellFromCoordinate(coordinate).isPresent()){
            if(!board.getCellFromCoordinate(coordinate).get().hasPiece()){
                this.getAction().doAction(Optional.empty(),Optional.of(coordinate),board,piece);
                return true;
            }
        }
        return false;
    }
}
