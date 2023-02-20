package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.boardGamesLibrary.Colors;
import it.unicam.cs.pa2023.boardGamesLibrary.DefaultPlayer;
import it.unicam.cs.pa2023.boardGamesLibrary.Piece;

import java.util.ArrayList;

public class OthelloPlayer extends DefaultPlayer<OthelloCoordinateMapper> {

    public OthelloPlayer(String name, Colors color, ArrayList<Piece> playersPieces, int score, OthelloCoordinateMapper coordinateMapper) {
        super(name, color, playersPieces, score, coordinateMapper);
    }
}
