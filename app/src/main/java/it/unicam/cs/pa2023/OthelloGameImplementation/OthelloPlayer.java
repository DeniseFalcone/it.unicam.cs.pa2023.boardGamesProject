package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.boardGamesLibrary.Colors;
import it.unicam.cs.pa2023.boardGamesLibrary.DefaultPlayer;

/**
 * This class extends the DefaultPlayer class and implements the OthelloPlayer.
 */
public class OthelloPlayer extends DefaultPlayer<OthelloCoordinateMapper> {

    public OthelloPlayer(String name, Colors color, int score, OthelloCoordinateMapper mapper) {
        super(name, color, score, mapper);
    }
}
