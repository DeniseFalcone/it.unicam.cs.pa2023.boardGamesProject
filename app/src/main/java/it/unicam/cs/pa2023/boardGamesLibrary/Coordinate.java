package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * This class is used to create a coordinate object.
 * It has three attributes: x, y and z values that represents the position on the board.
 * If only two values are passed to the constructor, the z value is going to be set to 1 by default.
 */
public class Coordinate {

    private Integer x;
    private Integer y;
    private Integer z;

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.z = 1;
    }

    public Coordinate(Integer x, Integer y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(getX(), that.getX()) && Objects.equals(getY(), that.getY()) && Objects.equals(getZ(), that.getZ());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getZ());
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    /**
     * Given a string, this static method checks if the input is not null and matches the pattern
     * of a letter or number, followed by a comma, followed by a number.
     * This check has to be done before creating the coordinate.
     *
     * @param string The string to be checked.
     * @return true if the string matches the pattern and false otherwise.
     */
    public static boolean checkCoordinate(String string){
        return string != null && Pattern.matches("[a-zA-Z0-9,]+,[0-9]+", string);
    }
}
