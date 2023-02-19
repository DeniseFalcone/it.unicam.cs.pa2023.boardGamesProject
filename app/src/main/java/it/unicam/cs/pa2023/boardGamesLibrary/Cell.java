package it.unicam.cs.pa2023.boardGamesLibrary;
import java.util.Objects;
import java.util.Optional;

public class Cell {

    private final Coordinate coordinate;
    private Colors color;
    private Optional<Piece> pieceOptional;


    public Cell(Coordinate coordinate, Colors color, Optional<Piece> pieceOptional) {
        this.coordinate = coordinate;
        this.color = color;
        this.pieceOptional = pieceOptional;
    }

    public boolean isFree(){
        return pieceOptional.isEmpty();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Colors getColor() {
        return color;
    }

    public Optional<Piece> getPieceOptional() {
        return pieceOptional;
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
