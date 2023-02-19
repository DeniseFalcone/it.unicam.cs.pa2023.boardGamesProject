package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.List;

public interface Player<E extends DefaultGame> {

    Piece selectPiece();

    Coordinate insertCoordinate();


    E chooseGame(ArrayList<E> listOfGames);

}
