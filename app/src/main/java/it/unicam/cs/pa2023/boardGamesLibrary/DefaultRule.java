package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.List;

public abstract class DefaultRule implements Rule{



    @Override
    public boolean apply_rule(Piece piece, List<Cell> board_state) {
        return false;
    }
}
