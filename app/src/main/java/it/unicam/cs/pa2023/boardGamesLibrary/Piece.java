package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Objects;

public class Piece {

    private Colors color;
    private Integer value;
    private String name;

    /**
     * Piece constructor that creates the pieces needed for the game.
     *
     * @param color color of the piece.
     * @param value value of the piece.
     * @param name name of the piece.
     */
    public Piece(Colors color, Integer value, String name) {
        this.color = color;
        this.value = value;
        this.name = name;
    }

    /**
     * This method returns the color of piece.
     *
     * @return the color of the piece.
     */
    public Colors getColor() {
        return color;
    }

    /**
     * This method sets the color of the piece.
     */
    public void setColor(Colors color) {
        this.color = color;
    }

    /**
     * This method sets the value of the piece.
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * This method sets the name of the piece.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the value of piece.
     *
     * @return the value of the piece.
     */
    public Integer getValue() {
        return value;
    }

    /**
     * This method returns the name of piece.
     *
     * @return the name of the piece.
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return getColor() == piece.getColor() && Objects.equals(getValue(), piece.getValue()) && Objects.equals(getName(), piece.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getValue(), getName());
    }

    @Override
    public String toString() {
        return "Piece: " +
                "color=" + color +
                ", name='" + name + '\'';
    }
}
