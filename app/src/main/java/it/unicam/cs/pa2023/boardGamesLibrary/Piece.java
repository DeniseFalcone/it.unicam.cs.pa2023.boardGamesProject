package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Objects;

public class Piece {

    private Colors color;
    private Integer value;
    private String name;

    public Piece(Colors color, Integer value, String name) {
        this.color = color;
        this.value = value;
        this.name = name;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

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
