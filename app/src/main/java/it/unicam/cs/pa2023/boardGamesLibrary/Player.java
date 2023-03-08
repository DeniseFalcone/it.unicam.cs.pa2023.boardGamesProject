package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.List;

public interface Player{

    Coordinate insertCoordinate();

    String getName();

    int getScore();

}
