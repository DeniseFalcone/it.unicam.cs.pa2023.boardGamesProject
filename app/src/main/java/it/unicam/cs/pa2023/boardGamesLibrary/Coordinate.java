package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Objects;

/**
 * Classe che descrive una qualsiasi coordinata nella board implementata.
 */
public class Coordinate {

    private Integer x;
    private Integer y;
    private Integer z;

    /**
     * Coordinate constructor that only takes the x and y values. The z is set by default at 1.
     *
     * @param x the x-axis value.
     * @param y the y-axis value.
     */
    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.z = 1;
    }

    /**
     * Coordinate constructor that takes the x y and z values.
     *
     * @param x the x-axis value.
     * @param y the y-axis value.
     * @param z the z-axis value.
     */
    public Coordinate(Integer x, Integer y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * This method returns the value of the x variable.
     *
     * @return The value of the x variable.
     */
    public Integer getX() {
        return x;
    }

    /**
     * This method sets the value of the x variable.
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * This method returns the value of the y variable.
     *
     * @return The value of the y variable.
     */
    public Integer getY() {
        return y;
    }


    /**
     * This method sets the value of the y variable.
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * This method returns the value of the z variable.
     *
     * @return The value of the z variable.
     */
    public Integer getZ() {
        return z;
    }

    /**
     * This method sets the value of the z variable.
     */
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
}
