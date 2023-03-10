package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules.ChangeColorRule;
import it.unicam.cs.pa2023.boardGamesLibrary.Colors;
import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class OthelloGameTest {

    private OthelloGame othelloGame;

    @Before
    public void setUp() throws Exception {
        this.othelloGame = new OthelloGame();
    }

    @Test
    public void playerCanPlayTurnTest() {
        assertTrue(othelloGame.playerCanPlayTurn(othelloGame.getPlayers().get(0)));
        assertTrue(othelloGame.playerCanPlayTurn(othelloGame.getPlayers().get(1)));
        Coordinate coordinate1 = new Coordinate(Integer.valueOf(5), Integer.valueOf(4), 1);
        Coordinate coordinate2 = new Coordinate(Integer.valueOf(4), Integer.valueOf(5), 1);
        othelloGame.getGameBoard().getCellFromCoordinate(coordinate1).get().getPieceOptional().get().setColor(Colors.LIGHT);
        othelloGame.getGameBoard().getCellFromCoordinate(coordinate2).get().getPieceOptional().get().setColor(Colors.LIGHT);
        assertFalse(othelloGame.playerCanPlayTurn(othelloGame.getPlayers().get(1)));
    }

    @Test
    public void playTurnTest(){
        String userInput1 = "c,4";
        ByteArrayInputStream input1 = new ByteArrayInputStream(userInput1.getBytes());
        System.setIn(input1);
        Coordinate coordinate1 = new Coordinate(3,4,1);
        othelloGame.playTurn(othelloGame.getPlayers().get(0));
        assertTrue(othelloGame.getGameBoard().getCellFromCoordinate(coordinate1).get().getPieceOptional().isPresent());
        assertEquals(Colors.DARK, othelloGame.getGameBoard().getCellFromCoordinate(coordinate1).get().getPieceOptional().get().getColor());
        Coordinate coordinate2 = new Coordinate(4,4,1);
        assertEquals(Colors.DARK, othelloGame.getGameBoard().getCellFromCoordinate(coordinate2).get().getPieceOptional().get().getColor());
        assertEquals(1,this.othelloGame.getGameStateHistory().size());
        assertEquals(1, this.othelloGame.getTurn());
        assertEquals(4, this.othelloGame.getPlayers().get(0).getScore());
        assertEquals(1, this.othelloGame.getPlayers().get(1).getScore());
    }

    @Test
    public void setUpGameTest(){
        OthelloBoard board = new OthelloBoard(8,8,1);
        othelloGame.setGameBoard(board);
        othelloGame.setupGame();
        Coordinate coordinate1 = new Coordinate(4,4,1);
        Coordinate coordinate2 = new Coordinate(4,5,1);
        Coordinate coordinate3 = new Coordinate(5,4,1);
        Coordinate coordinate4 = new Coordinate(5,5,1);
        assertTrue(othelloGame.getGameBoard().getCellFromCoordinate(coordinate1).get().getPieceOptional().isPresent());
        assertTrue(othelloGame.getGameBoard().getCellFromCoordinate(coordinate2).get().getPieceOptional().isPresent());
        assertTrue(othelloGame.getGameBoard().getCellFromCoordinate(coordinate3).get().getPieceOptional().isPresent());
        assertTrue(othelloGame.getGameBoard().getCellFromCoordinate(coordinate4).get().getPieceOptional().isPresent());
        assertEquals(Colors.LIGHT, othelloGame.getGameBoard().getCellFromCoordinate(coordinate1).get().getPieceOptional().get().getColor());
        assertEquals(Colors.LIGHT, othelloGame.getGameBoard().getCellFromCoordinate(coordinate4).get().getPieceOptional().get().getColor());
        assertEquals(Colors.DARK, othelloGame.getGameBoard().getCellFromCoordinate(coordinate2).get().getPieceOptional().get().getColor());
        assertEquals(Colors.DARK, othelloGame.getGameBoard().getCellFromCoordinate(coordinate3).get().getPieceOptional().get().getColor());
    }

}