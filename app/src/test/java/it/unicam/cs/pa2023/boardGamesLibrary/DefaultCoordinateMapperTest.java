package it.unicam.cs.pa2023.boardGamesLibrary;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class DefaultCoordinateMapperTest {

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
    public void getValueFromMapTest() {
        assertSame(coordinateMapper.getValueFromMap(a), one);
        assertSame(coordinateMapper.getValueFromMap(b), two);
        assertSame(coordinateMapper.getValueFromMap(c), three);
        assertNotSame(coordinateMapper.getValueFromMap(b), one);
        assertNotSame(coordinateMapper.getValueFromMap(b), three);
        Character f = 'f';
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> coordinateMapper.getValueFromMap(f));
        assertEquals("This key doesn't exist.", exception.getMessage());
    }

    @Test
    public void getKeyFromMapTest() {
        assertSame(coordinateMapper.getKeyFromMap(one), a);
        assertSame(coordinateMapper.getKeyFromMap(two), b);
        assertSame(coordinateMapper.getKeyFromMap(three), c);
        assertNotSame(coordinateMapper.getKeyFromMap(one), b);
        assertNotSame(coordinateMapper.getKeyFromMap(one), c);
        Integer four = 4;
        Exception exception = assertThrows(
                NullPointerException.class,
                () -> coordinateMapper.getKeyFromMap(4));
        assertEquals("The value is not present in the map.", exception.getMessage());
    }
}