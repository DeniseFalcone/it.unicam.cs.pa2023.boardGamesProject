package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.Optional;

public interface Board{

    //Prend la coordinata dell'azione già calcolata e ne controlla la correttezza in termini spaziali
    //es. coord. 9,2,2 con scacchiera max 8,8,1 da' errore.
    boolean isActionValid(Coordinate coordinate);

    Cell getCellFromCoordinate(Coordinate coordinates);

    Cell getCellFromPiece(Piece piece);

    ArrayList<Cell> getCellsWithPiecesOfOneColor(Colors pieceColor);

    boolean removeAllPieces();

    void replacePieceInCell(Coordinate newCoordinate, Optional<Piece> piece);
}
