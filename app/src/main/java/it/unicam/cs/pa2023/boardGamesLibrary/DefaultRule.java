package it.unicam.cs.pa2023.boardGamesLibrary;

/**
 * This abstract class is necessary for test purposes.
 *
 * @param <B> A class that extends the Board interface.
 */
public abstract class DefaultRule<B extends DefaultBoard> implements Rule<B>{

    @Override
    public abstract boolean applyRule(Piece piece, B board, Coordinate coordinate);


}
