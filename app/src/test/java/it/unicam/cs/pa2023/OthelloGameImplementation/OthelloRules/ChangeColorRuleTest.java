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

public class ChangeColorRuleTest {

    private OthelloGame othelloGame;

    @Before
    public void setUp() throws Exception {
        this.othelloGame = new OthelloGame();
    }

    @Test
    public void applyRuleTest() {
        Piece pieceBlack = this.othelloGame.getGamePieces().get(0);
        pieceBlack.setColor(Colors.DARK);
        Coordinate coordinate1 = new Coordinate(Integer.valueOf(5),Integer.valueOf(2),Integer.valueOf(1));
        assertFalse(this.othelloGame.getGameRules().get(0).applyRule(pieceBlack, this.othelloGame.getGameBoard(), coordinate1));
        Coordinate coordinate2 = new Coordinate(Integer.valueOf(3),Integer.valueOf(4),Integer.valueOf(1));
        assertTrue(this.othelloGame.getGameRules().get(0).applyRule(pieceBlack, this.othelloGame.getGameBoard(), coordinate2));
        Coordinate coordinate3 = new Coordinate(Integer.valueOf(3),Integer.valueOf(3),Integer.valueOf(1));
        Piece pieceWhite = this.othelloGame.getGamePieces().get(0);
        pieceBlack.setColor(Colors.LIGHT);
        assertTrue(this.othelloGame.getGameRules().get(0).applyRule(pieceWhite, this.othelloGame.getGameBoard(), coordinate3));
        Coordinate coordinate4 = new Coordinate(Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(1));
        assertFalse(this.othelloGame.getGameRules().get(0).applyRule(pieceWhite, this.othelloGame.getGameBoard(), coordinate4));
    }
}