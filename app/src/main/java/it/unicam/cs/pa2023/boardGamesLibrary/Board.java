package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.Optional;

/**
 * This interface can be used to implement a chessboard, get cells through different conditions and validate the action.
 */
public interface Board{


    /**
     * Given a coordinate, return the cell at that coordinate, or null if that cell doesn't exist.
     *
     * @param coordinates The coordinates of the cell you want to get.
     * @return Optional<Cell> the cell at the given coordinate, or null if it doesn't exist.
     */
    Optional<Cell> getCellFromCoordinate(Coordinate coordinates);


    /**
     * Given a piece, return the cell that contains it.
     *
     * @param piece The piece you want to get the cell from.
     * @return Cell that contains the piece.
     */
    Cell getCellFromPiece(Piece piece);


    /**
     * Given a color, return an ArrayList of all the cells that contain pieces of that color.
     *
     * @param pieceColor The color of the pieces you want to get the cells of.
     * @return An ArrayList of Cells that contain the pieces of the specified color.
     */
    ArrayList<Cell> getCellsWithPiecesOfOneColor(Colors pieceColor);


    /**
     * Removes all pieces from the board.
     *
     * @return A boolean value that returns true if all the pieces are removed from the board, and false otherwise.
     */
    boolean removeAllPieces();

    /**
     * Given a coordinate and a direction, return all the cells in that direction.
     *
     * @param coordinate the coordinate of the cell you want to start from.
     * @param direction an array of 3 integers, the first being the x-direction, the second being the y-direction and the third being the z-direction.
     * @return An ArrayList of all the cells in that direction.
     */
    ArrayList<Cell> getCellsFromDirection(Coordinate coordinate, Integer[] direction);


    /**
     * Given a coordinate, return an array of all its neighbouring cells.
     *
     * @param coordinate the coordinate of the cell from which to take the neighbors.
     * @return An ArrayList of Optional<Cell> that correspond to the cell neighbours.
     */
    ArrayList<Optional<Cell>> getCellNeighbours(Coordinate coordinate);

    /**
     * Given a coordinate and a piece, replace the piece in the cell at the corresponding coordinate with the given piece.
     *
     * @param newCoordinate the coordinate of the cell of which you want to replace the piece in.
     * @param piece the piece to be placed in the cell.
     */
    void replacePieceInCell(Coordinate newCoordinate, Optional<Piece> piece);

    /**
     * Given the coordinate, checks if it's valid.
     *
     * @param coordinate the coordinate to check.
     * @return A boolean value that returns true id the coordinate is valid and, false otherwise.
     */
    boolean checkIfCoordinateIsValid(Coordinate coordinate);

}
