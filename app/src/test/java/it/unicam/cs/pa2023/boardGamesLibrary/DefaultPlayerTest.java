package it.unicam.cs.pa2023.boardGamesLibrary;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DefaultPlayerTest {


    public static Character a = 'a';
    public static Character b = 'b';
    public static Character c = 'c';
    public static Integer one = 1;
    public static Integer two = 2;
    public static Integer three = 3;
    public static Map<Character, Integer> map() {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        characterIntegerMap.putIfAbsent(a, one);
        characterIntegerMap.putIfAbsent(b, two);
        characterIntegerMap.putIfAbsent(c, three);
        return characterIntegerMap;
    }

    public static DefaultCoordinateMapper coordinateMapper = new DefaultCoordinateMapper(map());


    @Test
    public void insertCoordinateTest(){
        DefaultPlayer player = new DefaultPlayer("Denise", Colors.DARK,0, coordinateMapper);
        String userInput1 = "c,6,3";
        ByteArrayInputStream input1 = new ByteArrayInputStream(userInput1.getBytes());
        System.setIn(input1);
        Coordinate coordinate1 = new Coordinate(Integer.valueOf(3),Integer.valueOf(6), Integer.valueOf(3));
        assertEquals(coordinate1,player.insertCoordinate());
        String userInput2 = "c,6";
        ByteArrayInputStream input2 = new ByteArrayInputStream(userInput2.getBytes());
        System.setIn(input2);
        Coordinate coordinate2 = new Coordinate(Integer.valueOf(3),Integer.valueOf(6), Integer.valueOf(1));
        assertEquals(coordinate2,player.insertCoordinate());
        String userInput3 = "4,6,8";
        ByteArrayInputStream input3 = new ByteArrayInputStream(userInput3.getBytes());
        System.setIn(input3);
        Coordinate coordinate3 = new Coordinate(Integer.valueOf(4),Integer.valueOf(6), Integer.valueOf(8));
        assertEquals(coordinate3,player.insertCoordinate());
    }
}