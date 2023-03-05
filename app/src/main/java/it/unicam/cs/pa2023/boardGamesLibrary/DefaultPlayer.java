package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DefaultPlayer<D extends DefaultCoordinateMapper> implements Player{

    private int score;
    private Scanner scanner;
    private String name;
    private Colors color;
    private D defaultCoordinateMapper;

    public DefaultPlayer(String name, Colors color, int score, D defaultCoordinateMapper) {
        this.name = name;
        this.color = color;
        this.score = score;
        this.defaultCoordinateMapper = defaultCoordinateMapper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public D getDefaultCoordinateMapper() {
        return defaultCoordinateMapper;
    }

    public void setDefaultCoordinateMapper(D defaultCoordinateMapper) {
        this.defaultCoordinateMapper = defaultCoordinateMapper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultPlayer<?> that = (DefaultPlayer<?>) o;
        return getScore() == that.getScore() && Objects.equals(scanner, that.scanner) && Objects.equals(getName(), that.getName()) && getColor() == that.getColor() && Objects.equals(getDefaultCoordinateMapper(), that.getDefaultCoordinateMapper());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScore(), scanner, getName(), getColor(), getDefaultCoordinateMapper());
    }

    @Override
    public String toString() {
        return "DefaultPlayer: " +
                "name='" + name + '\'' +
                ", color=" + color;
    }



    @Override
    public Coordinate insertCoordinate() {
        System.out.println("Write the coordinate separated by comma: ");
        this.scanner = new Scanner(System.in);
        String input = inputString();
        String[] coordinateInput = input.split(",");
        Integer[] coordinates = mapCoordinate(coordinateInput);
        return new Coordinate(coordinates[0], coordinates[1], coordinates[2]);
    }

    private Integer[] mapCoordinate(String[] inputCoordinate){
        Integer[] coordinateArray = new Integer[3];
        if(inputCoordinate.length == 2){
            coordinateArray[2] = Integer.valueOf(1);
        }
        for (int i=0; i<inputCoordinate.length; i++) {
            if(!isNumeric(inputCoordinate[i])){
                Character character = Character.valueOf(inputCoordinate[i].toCharArray()[0]);
                coordinateArray[i] = defaultCoordinateMapper.getValueFromMap(character);
            }else{
                coordinateArray[i] = Integer.parseInt(inputCoordinate[i]);
            }
        }
        return coordinateArray;
    }

    private boolean isNumeric(String string) {
        if (string == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private String inputString(){
        String input;
        input = this.scanner.next();
        return input;
    }
}
