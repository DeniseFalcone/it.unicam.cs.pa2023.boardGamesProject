package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import it.unicam.cs.pa2023.boardGamesLibrary.DefaultAction;
import it.unicam.cs.pa2023.boardGamesLibrary.DefaultRule;
import it.unicam.cs.pa2023.boardGamesLibrary.Piece;

public class OthelloRule extends DefaultRule<OthelloBoard> {

    private DefaultAction<OthelloBoard> action;

    public OthelloRule() {
        this.action = new DefaultAction<>();
    }

    @Override
    public boolean applyRule(Piece piece, OthelloBoard board, Coordinate coordinate) {
        return false;
    }

    public DefaultAction<OthelloBoard> getAction() {
        return action;
    }

    public void setAction(DefaultAction<OthelloBoard> action) {
        this.action = action;
    }
}
