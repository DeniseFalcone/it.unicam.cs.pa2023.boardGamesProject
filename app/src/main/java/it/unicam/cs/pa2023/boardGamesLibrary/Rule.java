package it.unicam.cs.pa2023.boardGamesLibrary;

/**
 * This interface can be used to create the rules to play the game.
 *
 * @param <B> A class that extends the Board interface.
 */
@FunctionalInterface
public interface Rule<B extends Board> {


    /**
     * Given a piece, a board, and a coordinate, return true if the rule is successfully applied and false otherwise.
     *
     * @param piece The piece that is being moved.
     * @param board The board that the piece is being placed on.
     * @param coordinate The coordinate that the piece is trying to move to.
     * @return true if the pieces is successfully placed at the given coordinate and false otherwise.
     */
    boolean applyRule(Piece piece, B board, Coordinate coordinate);

}
