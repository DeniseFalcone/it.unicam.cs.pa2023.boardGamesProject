package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import it.unicam.cs.pa2023.boardGamesLibrary.DefaultRule;
import it.unicam.cs.pa2023.boardGamesLibrary.Piece;

public class OthelloRule extends DefaultRule<OthelloBoard> {

    @Override
    public boolean applyRule(Piece piece, OthelloBoard board, Coordinate coordinate) {
        return false;
    }


}
