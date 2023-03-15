package it.unicam.cs.pa2023.boardGamesLibrary;

/**
 * This interface can be used to map a given coordinate where at least one of the values is a Character.
 */
public interface CoordinateMapper {

    /**
     * Given an Integer, return the Character that is mapped to that Integer in the map.
     *
     * @param value the value to search for in the map.
     * @return The Character object associated with the value.
     */
    Character getKeyFromMap(Integer value);

    /**
     * Given a key, return the value from the map.
     *
     * @param key the key to look for in the map.
     * @return The value associated with the key.
     */
    Integer getValueFromMap(Character key);

    /**
     * Given a string array of a coordinate, return an integer array of the same coordinate.
     *
     * @param inputCoordinate the coordinate to map.
     * @return An array of integers that corresponds to the coordinate passed.
     */
    Integer[] mapCoordinate(String[] inputCoordinate);
}
