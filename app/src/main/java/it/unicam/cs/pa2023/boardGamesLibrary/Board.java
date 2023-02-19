package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.Optional;

public interface Board<A extends DefaultAction> {

    //controlla la validità del movimento
    boolean isActionValid(A action);

    Cell getCellFromCoordinate(Coordinate coordinates);

    Cell getCellFromPiece(Piece piece);

    ArrayList<Cell> getCellsWithPiecesOfOneColor(Colors pieceColor);

    boolean removeAllPieces();

    void replacePieceInCell(Coordinate newCoordinate, Optional<Piece> piece);
}
