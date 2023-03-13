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

    /**
     * This method returns true if the cell has a piece and false otherwise.
     *
     * @return true if the cell contains a piece and false otherwise.
     */
    public boolean hasPiece(){
        return pieceOptional.isPresent();
    }

    /**
     * This method returns the coordinate of the cell.
     *
     * @return The coordinate of the cell.
     */
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    /**
     * This method returns the color of the cell.
     *
     * @return The color of the cell.
     */
    public Colors getColor() {
        return this.color;
    }

    /**
     * This method returns Optional.Empty if the cell is empty and Optional.of(Piece) if the cell has a piece.
     *
     * @return Optional.Empty if the cell is empty and Optional.of(Piece) if the cell has a piece.
     */
    public Optional<Piece> getPieceOptional() {
        return this.pieceOptional;
    }

    /**
     * If this.pieceOptional is not null, then set it to the pieceOptional passed in.
     *
     * @param pieceOptional This is the optional piece that is being set.
     */
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

    /**
     * This method sets the color of the cell to the color passed in.
     *
     * @param color The color of the cell.
     */
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
