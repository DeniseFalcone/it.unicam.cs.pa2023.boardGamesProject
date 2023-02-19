package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Map;
import java.util.Optional;

/**
 * A CoordinateMapper is an object that can convert between two coordinate systems.
 */
public class DefaultCoordinateMapper implements CoordinateMapper{

    private final Map<Character, Integer> map;

    public DefaultCoordinateMapper(Map<Character, Integer> map) {
        this.map = map;
    }

    public Integer getValueFromMap(Character key){
        if(!map.containsKey(key)){
            throw new IllegalArgumentException("This key doesn't exist.");
        }
        return map.get(key);
    }

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
}
