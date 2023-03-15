package it.unicam.cs.pa2023.boardGamesLibrary;
import java.util.Objects;
import java.util.Optional;

/**
 * This class represents a single cell of a chessboard.
 * It has three attributes: coordinate (a Coordinate object that represents the position of the cell
 * on the board), color (the color of the cell), and pieceOptional (an Optional which can contain a piece or be empty).
 */
public class Cell {

    private final Coordinate coordinate;
    private Colors color;
    private Optional<Piece> pieceOptional;


    public Cell(Coordinate coordinate, Colors color, Optional<Piece> pieceOptional) {
        this.coordinate = coordinate;
        this.color = color;
        this.pieceOptional = pieceOptional;
    }

    /**
     * This method returns true if the cell has a piece and false otherwise.
     *
     * @return true if the cell contains a piece and false otherwise.
     */
    public boolean hasPiece(){
        return pieceOptional.isPresent();
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public Colors getColor() {
        return this.color;
    }

    public Optional<Piece> getPieceOptional() {
        return this.pieceOptional;
    }

    public void setPieceOptional(Optional<Piece> pieceOptional) {
        this.pieceOptional = pieceOptional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(getCoordinate(), cell.getCoordinate()) && getColor() == cell.getColor() && Objects.equals(getPieceOptional(), cell.getPieceOptional());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordinate(), getColor(), getPieceOptional());
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "coordinate=" + coordinate +
                ", color=" + color +
                ", pieceOptional=" + pieceOptional.toString() +
                '}';
    }
}
