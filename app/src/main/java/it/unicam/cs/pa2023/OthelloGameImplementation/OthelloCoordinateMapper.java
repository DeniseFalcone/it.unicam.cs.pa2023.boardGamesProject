package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.boardGamesLibrary.DefaultCoordinateMapper;

import java.util.Map;

public class OthelloCoordinateMapper extends DefaultCoordinateMapper {
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
