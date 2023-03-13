package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Locale;
import java.util.Objects;

public class DefaultPlayer<D extends DefaultCoordinateMapper> implements Player{

    private int score;
    private String name;
    private Colors color;
    private D mapper;

    /**
     * DefaultPlayer constructor that creates a player.
     * @param name name of the player.
     * @param color color of the player.
     * @param score score of the player.
     * @param mapper mapper for the coordinates.
     */
    public DefaultPlayer(String name, Colors color, int score, D mapper) {
        this.name = name;
        this.color = color;
        this.score = score;
        this.mapper = mapper;
    }

    @Override
    public Coordinate insertCoordinate() {
        System.out.println("Insert the coordinate of where you want to insert a piece, separated by comma: ");
        String coordinate = InputManager.getInstance().inputString().toLowerCase(Locale.ROOT);
        if(InputManager.getInstance().checkCoordinateInput(coordinate)){
            Integer[] coordinateValues = mapper.mapCoordinate(coordinate.split(","));
            return new Coordinate(coordinateValues[0], coordinateValues[1], coordinateValues[2]);
        }else{
            System.out.println("The given coordinate is not valid.");
            return insertCoordinate();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * This method sets the name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Colors getColor() {
        return color;
    }

    /**
     * This method sets the color of the player.
     */
    public void setColor(Colors color) {
        this.color = color;
    }

    @Override
    public int getScore() {
        return score;
    }

    /**
     * This method returns the coordinate mapper used by the player.
     *
     * @return the coordinate mapper.
     */
    public D getMapper() {
        return mapper;
    }

    /**
     * This method sets the mapper.
     */
    public void setMapper(D mapper) {
        this.mapper = mapper;
    }

    /**
     * This method sets the score of the player.
     */
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultPlayer that = (DefaultPlayer) o;
        return getScore() == that.getScore() && Objects.equals(getName(), that.getName()) && getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScore(), getName(), getColor());
    }

    @Override
    public String toString() {
        return "Player " + name +
                ", color = " + color +
                ", score = " + score;
    }




}
