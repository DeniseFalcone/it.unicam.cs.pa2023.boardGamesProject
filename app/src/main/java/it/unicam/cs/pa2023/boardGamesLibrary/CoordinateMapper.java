package it.unicam.cs.pa2023.boardGamesLibrary;

public interface CoordinateMapper {

    Character getKeyFromMap(Integer value);

    Integer getValueFromMap(Character key);
}
