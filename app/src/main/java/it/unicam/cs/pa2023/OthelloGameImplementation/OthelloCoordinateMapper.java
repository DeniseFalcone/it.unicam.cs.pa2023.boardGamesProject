package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.boardGamesLibrary.DefaultCoordinateMapper;

import java.util.Map;

/**
 * This class extends the DefaultCoordinateMapper class implementing an OthelloCoordinateMapper.
 */
public class OthelloCoordinateMapper extends DefaultCoordinateMapper {


    /**
     * OthelloCoordinateMapper constructor that creates a mapper for the Othello game.
     * This mapper takes an empty map and creates the mapper for the Othello game.
     * @param map an empty map that maps Character and Integer.
     */
    public OthelloCoordinateMapper(Map<Character, Integer> map) {
        super(map);
        map.putIfAbsent('a',1);
        map.putIfAbsent('b',2);
        map.putIfAbsent('c',3);
        map.putIfAbsent('d',4);
        map.putIfAbsent('e',5);
        map.putIfAbsent('f',6);
        map.putIfAbsent('g',7);
        map.putIfAbsent('h',8);
    }
}
