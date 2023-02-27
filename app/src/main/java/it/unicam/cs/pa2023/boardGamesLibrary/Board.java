package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.Optional;

public interface Board{

    //Prend la coordinata dell'azione già calcolata e ne controlla la correttezza in termini spaziali
    //es. coord. 9,2,2 con scacchiera max 8,8,1 da' errore.
    boolean isActionValid(Coordinate coordinate);

    Optional<Cell> getCellFromCoordinate(Coordinate coordinates);

    Cell getCellFromPiece(Piece piece);

    ArrayList<Cell> getCellsWithPiecesOfOneColor(Colors pieceColor);

    boolean removeAllPieces();

    /**
     * Given a coordinate and a direction, return all the cells in that direction.
     *
     * @param coordinate The coordinate of the cell you want to start from.
     * @param direction An array of two integers, the first being the x direction and the second being the y direction.
     * @return An ArrayList of Cell objects.
     */
    ArrayList<Cell> getCellsFromDirection(Coordinate coordinate, Integer[] direction);

    ArrayList<Optional<Cell>> getCellNeighbours(Coordinate coordinate);

    void replacePieceInCell(Coordinate newCoordinate, Optional<Piece> piece);
}
