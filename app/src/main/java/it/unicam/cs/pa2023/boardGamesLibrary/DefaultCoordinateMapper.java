package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * A CoordinateMapper is an object that can convert between two coordinate systems.
 */
public class DefaultCoordinateMapper implements CoordinateMapper{

    private final Map<Character, Integer> map;

    public DefaultCoordinateMapper(Map<Character, Integer> map) {
        this.map = map;
    }

    @Override
    public Integer getValueFromMap(Character key){
        if(!map.containsKey(key)){
            throw new IllegalArgumentException("This key doesn't exist.");
        }
        return map.get(key);
    }

    @Override
    public Character getKeyFromMap(Integer value){
        Optional<Character> key = map.entrySet().stream()
                .filter(x -> value.equals(x.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        if (key.isEmpty()){
            throw new NullPointerException("The value is not present in the map.");
        }
        return key.get();
    }

    @Override
    public Integer[] mapCoordinate(String[] inputCoordinate){
        Integer[] coordinateArray = new Integer[3];
        if(inputCoordinate.length == 2){
            coordinateArray[2] = Integer.valueOf(1);
        }
        for (int i=0; i<inputCoordinate.length; i++) {
            if(!isNumeric(inputCoordinate[i])){
                Character character = Character.valueOf(inputCoordinate[i].toCharArray()[0]);
                coordinateArray[i] = this.getValueFromMap(character);
            }else{
                coordinateArray[i] = Integer.parseInt(inputCoordinate[i]);
            }
        }
        return coordinateArray;
    }


    /**
     * Given a string, if it's a number returns true, false otherwise.
     *
     * @param string The string to be tested.
     * @return true if the string is a number, false otherwise.
     */
    private boolean isNumeric(String string) {
        try {
            double d = Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
