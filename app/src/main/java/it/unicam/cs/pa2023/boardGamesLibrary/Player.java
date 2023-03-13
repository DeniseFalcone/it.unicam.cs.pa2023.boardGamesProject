package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.List;

public interface Player{

    /**
     * This method returns a Coordinate object that is given by the user.
     *
     * @return a new coordinate object.
     */
    Coordinate insertCoordinate();

    /**
     * This method returns the name of the player.
     *
     * @return the name of the player.
     */
    String getName();

    /**
     * This method returns the color of the player.
     *
     * @return the color of the player.
     */
    Colors getColor();

    /**
     * This method returns the score of the player.
     *
     * @return the score of the player.
     */
    int getScore();

}
