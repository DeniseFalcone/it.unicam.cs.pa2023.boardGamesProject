package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Locale;
import java.util.Objects;

/**
 * Default implementation of the Player interface.
 * It has four attributes: the name of the player, the color assigned to the player, the player score and
 * a mapper to map the coordinates the player inserts.
 *
 * @param <D> A class that extends the DefaultCoordinateMapper.
 */
public class DefaultPlayer<D extends DefaultCoordinateMapper> implements Player{

    private int score;
    private String name;
    private Colors color;
    private D mapper;

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
        if(Coordinate.checkCoordinate(coordinate)){
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    @Override
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public D getMapper() {
        return mapper;
    }

    public void setMapper(D mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultPlayer<?> that = (DefaultPlayer<?>) o;
        return getScore() == that.getScore() && Objects.equals(getName(), that.getName()) && getColor() == that.getColor() && Objects.equals(getMapper(), that.getMapper());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScore(), getName(), getColor(), getMapper());
    }

    @Override
    public String toString() {
        return "Player " + name +
                ", color = " + color +
                ", score = " + score;
    }




}
