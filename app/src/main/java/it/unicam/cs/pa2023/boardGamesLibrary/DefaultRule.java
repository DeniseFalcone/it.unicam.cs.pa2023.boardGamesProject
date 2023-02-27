package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.List;

public abstract class DefaultRule<B extends DefaultBoard> implements Rule<B>{



    @Override
    public abstract boolean applyRule(Piece piece, B board, Coordinate coordinate);


}
