package it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules;

import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloBoard;
import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRule;
import it.unicam.cs.pa2023.boardGamesLibrary.*;

import java.util.List;

public class ChangeColorRule extends OthelloRule {

    @Override
    public boolean applyRule(Piece piece, OthelloBoard board, Coordinate coordinate) {
        return true;
    }

    public boolean checkNeighbours(Coordinate coordinate, OthelloBoard board) {
        return false;
    }

    //controllo vicini dim. 1 (se ho colore diverso considero la dimensione)
    //prende le linee rette da considerare
    //metodo che considera le varie dimensioni
}
