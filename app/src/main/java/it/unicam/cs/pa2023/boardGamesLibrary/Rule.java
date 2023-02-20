package it.unicam.cs.pa2023.boardGamesLibrary;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface Rule<B extends Board> {


    /**
     * "Given a piece and a board state, return true if the piece can be placed on the board, and false otherwise."
     *
     * The function is called "apply_rule" because it applies the rule of the game to the piece and the board state
     *
     * @param piece The piece that is being placed on the board.
     * @param board A list of all the cells on the board.
     * @return A boolean value.
     */
    boolean applyRule(Piece piece, B board, Coordinate coordinate);

}
