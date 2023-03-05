package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules.ChangeColorRule;
import it.unicam.cs.pa2023.boardGamesLibrary.Colors;
import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class OthelloGameTest {

    private OthelloGame othelloGame;

    @Before
    public void setUp() throws Exception {
        ArrayList<OthelloRule> rules = new ArrayList<>();
        ArrayList<OthelloPlayer> othelloPlayers = new ArrayList<>();
        OthelloBoard othelloBoard = new OthelloBoard(8,8,1);
        Map<Character,Integer> map = new HashMap<>();
        OthelloCoordinateMapper othelloCoordinateMapper = new OthelloCoordinateMapper(map);
        this.othelloGame = new OthelloGame(rules, othelloPlayers, "Othello", othelloBoard, othelloCoordinateMapper);
        this.othelloGame.setupGame();
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
}