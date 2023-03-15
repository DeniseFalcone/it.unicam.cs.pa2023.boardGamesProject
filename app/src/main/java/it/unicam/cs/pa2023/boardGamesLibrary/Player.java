package it.unicam.cs.pa2023.boardGamesLibrary;

/**
 * This interface can be used to create a player and make the player insert a coordinate.
 */
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
