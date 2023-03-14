package it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules;

import it.unicam.cs.pa2023.OthelloGameImplementation.*;
import it.unicam.cs.pa2023.boardGamesLibrary.Colors;
import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import it.unicam.cs.pa2023.boardGamesLibrary.Piece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeColorRuleTest {

    private OthelloGame othelloGame;

    @Before
    public void setUp(){
        this.othelloGame = new OthelloGame();
    }

    @Test
    public void applyRuleTest() {
        Piece pieceBlack = this.othelloGame.getGamePieces().get(0);
        pieceBlack.setColor(Colors.DARK);
        Coordinate coordinate1 = new Coordinate(5, 2, 1);
        assertFalse(this.othelloGame.getGameRules().get(0).applyRule(pieceBlack, this.othelloGame.getGameBoard(), coordinate1));
        Coordinate coordinate2 = new Coordinate(3, 4, 1);
        assertTrue(this.othelloGame.getGameRules().get(0).applyRule(pieceBlack, this.othelloGame.getGameBoard(), coordinate2));
        Coordinate coordinate3 = new Coordinate(3, 3, 1);
        Piece pieceWhite = this.othelloGame.getGamePieces().get(0);
        pieceBlack.setColor(Colors.LIGHT);
        assertTrue(this.othelloGame.getGameRules().get(0).applyRule(pieceWhite, this.othelloGame.getGameBoard(), coordinate3));
        Coordinate coordinate4 = new Coordinate(1, 1, 1);
        assertFalse(this.othelloGame.getGameRules().get(0).applyRule(pieceWhite, this.othelloGame.getGameBoard(), coordinate4));
    }
}