package it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules;

import it.unicam.cs.pa2023.OthelloGameImplementation.*;
import it.unicam.cs.pa2023.boardGamesLibrary.Colors;
import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import it.unicam.cs.pa2023.boardGamesLibrary.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class InsertPieceRuleTest {

    private OthelloGame othelloGame;

    @Before
    public void setUp() {
        this.othelloGame = new OthelloGame();
    }

    @Test
    public void applyRuleTest(){
        Piece piece = new Piece(Colors.LIGHT, 1, "piece");
        Coordinate coordinate1 = new Coordinate(3, 4, 1);
        assertTrue(othelloGame.getGameRules().get(1).applyRule(piece, othelloGame.getGameBoard(), coordinate1));
        Coordinate coordinate2 = new Coordinate(4, 4, 1);
        assertFalse(othelloGame.getGameRules().get(1).applyRule(piece, othelloGame.getGameBoard(), coordinate2));
        Coordinate coordinate3 = new Coordinate(45, 8, 1);
        assertFalse(othelloGame.getGameRules().get(1).applyRule(piece, othelloGame.getGameBoard(), coordinate3));
    }
}