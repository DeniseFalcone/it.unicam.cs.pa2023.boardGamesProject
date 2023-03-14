package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Optional;


/**
 * -----------------------------------------------------
 * @param <B> A class that extends the Board interface.
 */
public interface Action<B extends Board> {



    /**
     * Given an old coordinate, a new coordinate, a board, and a piece, return: if both coordinates are present,
     * a new board with the piece moved from the old coordinate to the new coordinate; if it's present only
     * the old coordinate, a new board without the old piece; if it's present only the new coordinate,
     * a new board where the piece is added at the new coordinate.
     *
     * @param oldCoordinate The coordinate of the piece before doing the action.
     * @param newCoordinate The new coordinate where the piece is going to be positioned, moved or removed.
     * @param board The board that the piece is on or is going to be.
     * @param piece The piece that is being moved, added or removed.
     * @return A new board with the piece moved, added or removed.
     */
    B doAction(Optional<Coordinate> oldCoordinate, Optional<Coordinate> newCoordinate, B board, Piece piece);


    /**
     * Given a coordinate, return a new coordinate that is the same as the original one, but with the y-value
     * increased (or decreased) by n_steps.
     *
     * @param coordinate the coordinate to start from.
     * @param n_steps the number of steps to move.
     * @return A new Coordinate object with the same x and z coordinates as the coordinate passed as a parameter, but with
     * a y coordinate that is n_steps higher or lower.
     */
    Coordinate verticalMovement(Coordinate coordinate, int n_steps);

    /**
     * Given a coordinate, return a new coordinate that is the same as the original one, but with the x-value
     * increased (or decreased) by n_steps.
     *
     * @param coordinate the coordinate to start from.
     * @param n_steps the number of steps to move.
     * @return A new Coordinate object with the same y and z coordinates as the coordinate passed as a parameter, but with
     * a x coordinate that is n_steps higher or lower.
     */
    Coordinate horizontalMovement(Coordinate coordinate, int n_steps);

    /**
     * Given a coordinate, return a new coordinate that is the same as the original one, but with the x and y values
     * increased (or decreased) by x_steps and y_steps respectively.
     *
     * @param coordinate The coordinate to start from.
     * @param x_steps The number of steps to move in the x direction.
     * @param y_steps The number of steps to move in the y direction.
     * @return A new Coordinate object with the same z coordinate as the coordinate passed as a parameter, but with
     * the x and y coordinates respectively x_steps and y_steps higher or lower.
     */
    Coordinate diagonalMovement(Coordinate coordinate, int x_steps, int y_steps);

    /**
     * Given a coordinate and a board number, returns a new coordinate with the same x and y values but with the new
     * z-value (the number of the board).
     *
     * @param coordinate The coordinate you want to change the board of.
     * @param n_board the number of the board you want to change to.
     * @return A new coordinate with the same x and y values but with the new board number.
     */
    Coordinate changeBoard(Coordinate coordinate, int n_board);

    /**
     * Given a coordinate, and the x, y and z values passed as direction, returns a new coordinate with the corresponding
     * x, y and z values increased (or decreased) by the direction values.
     *
     * @param coordinate The coordinate to get the new coordinate from.
     * @param x The x coordinate of the direction.
     * @param y The y coordinate of the direction.
     * @param z The z coordinate of the direction.
     * @return A new Coordinate object with the x, y, and z values of the original Coordinate object plus the x, y, and z
     * values of the direction passed in.
     */
    Coordinate getCoordinateFromDirection(Coordinate coordinate, int x, int y, int z);

}
