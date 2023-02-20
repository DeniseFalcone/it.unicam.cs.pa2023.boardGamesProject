package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.List;

public interface Player{

    Piece selectPiece();

    Coordinate insertCoordinate();

    String getName();

}
