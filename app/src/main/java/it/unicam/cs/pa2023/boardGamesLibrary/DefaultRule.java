package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.List;

public abstract class DefaultRule<B extends Board> implements Rule<B>{


    @Override
    public abstract boolean applyRule(Piece piece, B board, Coordinate coordinate);

    private boolean checkNeighbours(Coordinate coordinate, B board) {
        return false;
    }
}
