package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.boardGamesLibrary.Cell;
import it.unicam.cs.pa2023.boardGamesLibrary.Colors;
import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import it.unicam.cs.pa2023.boardGamesLibrary.Piece;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class OthelloBoardTest {

    @Test
    public void getDirectionTest() {
        OthelloBoard board = new OthelloBoard(8,8,1);
        Coordinate coordinate1 = new Coordinate(4,5,1);
        Coordinate coordinate2 = new Coordinate(5,5,1);
        Integer[] direction1 = {1,0,0};
        assertArrayEquals(board.getDirection(coordinate1, coordinate2), direction1);
        coordinate2.setX(4);
        coordinate2.setY(4);
        Integer[] direction2 = {0,-1,0};
        assertArrayEquals(board.getDirection(coordinate1, coordinate2), direction2);
    }

    @Test
    public void CheckCellsColorOneDirectionTest() {
        OthelloBoard board = new OthelloBoard(8,8,1);
        Piece blackPiece = new Piece(Colors.DARK,1,"piece");
        Piece whitePiece = new Piece(Colors.LIGHT, 1, "piece");
        Coordinate coordinate1 = new Coordinate(4,4,1);
        Coordinate coordinate2 = new Coordinate(5,4,1);
        Cell resultCell = new Cell(coordinate1,Colors.LIGHT,Optional.of(whitePiece));
        Cell cell2 = new Cell(coordinate2,Colors.DARK, Optional.of(blackPiece));
        ArrayList<Cell> resultArray = new ArrayList<>();
        resultArray.add(resultCell);
        ArrayList<Cell> toCheckArray = new ArrayList<>();
        toCheckArray.add(resultCell);
        toCheckArray.add(cell2);
        assertEquals(resultArray,board.checkCellsColorOneDirection(toCheckArray,Colors.DARK));
    }
}