package it.unicam.cs.pa2023.boardGamesLibrary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class DefaultBoardTest {

    @Test
    public void boardCreationTest(){
        try{
            DefaultBoard board = new DefaultBoard(8,8,1,Colors.DARK);
        }catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void paramsIllegalArgumentTest(){
        Exception exception1 = assertThrows(
                IllegalArgumentException.class,
                () -> new DefaultBoard(0,8,1,Colors.DARK));
        assertEquals("The parameters passed are less than the required amount.", exception1.getMessage());
        Exception exception2 = assertThrows(
                IllegalArgumentException.class,
                () -> new DefaultBoard(8,-5,1,Colors.DARK));
        assertEquals("The parameters passed are less than the required amount.", exception2.getMessage());
        Exception exception3 = assertThrows(
                IllegalArgumentException.class,
                () -> new DefaultBoard(8,8,0,Colors.DARK));
        assertEquals("The parameters passed are less than the required amount.", exception3.getMessage());
        DefaultBoard board = new DefaultBoard(8,8,1,Colors.DARK);
        assertEquals(64, board.getBoard().size());
        DefaultBoard board2 = new DefaultBoard(2,3,2,Colors.DARK);
        assertEquals(12, board2.getBoard().size());
    }

    @Test
    public void getCellFromCoordinateTest(){
        DefaultBoard board = new DefaultBoard(8,8,1,Colors.DARK);
        Integer x=1, y=4, z=1;
        Coordinate coordinate = new Coordinate(x,y,z);
        Cell testCell = new Cell(coordinate, Colors.LIGHT, Optional.empty());
        assertEquals(testCell, board.getCellFromCoordinate(coordinate).get());
    }

    @Test
    public void getCellFromPieceTest(){
        DefaultBoard board = new DefaultBoard(8,8,1,Colors.DARK);
        Piece queen = new Piece(Colors.LIGHT, 9, "Queen");
        Piece rook = new Piece(Colors.DARK, 5, "Rook");
        Integer x=1, y=4, z=1;
        Coordinate coordinate = new Coordinate(x,y,z);
        DefaultAction putPieceAction = new DefaultAction();
        putPieceAction.doAction(Optional.empty(),Optional.of(coordinate),board,queen);
        Cell testCell = new Cell(coordinate, Colors.LIGHT, Optional.of(queen));
        Cell testCellError = new Cell(coordinate, Colors.LIGHT, Optional.of(rook));
        assertEquals(testCell, board.getCellFromPiece(queen));
        assertNotEquals(testCellError,board.getCellFromPiece(queen));
    }

    @Test
    public void getPiecesOfOneColorTest(){
        DefaultBoard board = new DefaultBoard(8,8,1,Colors.DARK);
        Piece queen = new Piece(Colors.LIGHT, 9, "Queen");
        Piece rook = new Piece(Colors.DARK, 5, "Rook");
        Piece pawn = new Piece(Colors.DARK, 1, "Pawn");
        Coordinate coordinate1 = new Coordinate(Integer.valueOf(4), Integer.valueOf(8), Integer.valueOf(1));
        Coordinate coordinate2 = new Coordinate(Integer.valueOf(3), Integer.valueOf(8), Integer.valueOf(1));
        Coordinate coordinate3 = new Coordinate(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
        Action action = new DefaultAction();
        action.doAction(Optional.empty(), Optional.of(coordinate1), board, queen);
        action.doAction(Optional.empty(), Optional.of(coordinate2), board, rook);
        action.doAction(Optional.empty(), Optional.of(coordinate3), board, pawn);
        assertTrue(board.getCellsWithPiecesOfOneColor(Colors.DARK).contains(board.getCellFromPiece(rook)));
        assertTrue(board.getCellsWithPiecesOfOneColor(Colors.DARK).contains(board.getCellFromPiece(pawn)));
        assertFalse(board.getCellsWithPiecesOfOneColor(Colors.DARK).contains(board.getCellFromPiece(queen)));
    }

    @Test
    public void removeAllPiecesTest(){
        DefaultBoard board = new DefaultBoard(8,8,1,Colors.DARK);
        Piece queen = new Piece(Colors.LIGHT, 9, "Queen");
        Piece rook = new Piece(Colors.DARK, 5, "Rook");
        Piece pawn = new Piece(Colors.DARK, 1, "Pawn");
        Coordinate coordinate1 = new Coordinate(Integer.valueOf(4), Integer.valueOf(8), Integer.valueOf(1));
        Coordinate coordinate2 = new Coordinate(Integer.valueOf(3), Integer.valueOf(8), Integer.valueOf(1));
        Coordinate coordinate3 = new Coordinate(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
        Action action = new DefaultAction();
        action.doAction(Optional.empty(), Optional.of(coordinate1), board, queen);
        action.doAction(Optional.empty(), Optional.of(coordinate2), board, rook);
        action.doAction(Optional.empty(), Optional.of(coordinate3), board, pawn);
        assertTrue(board.removeAllPieces());
    }


    @Test
    public void getCellsFromDirectionTest(){
        DefaultBoard board = new DefaultBoard(8,8,1, Colors.DARK);
        Coordinate coordinate1 = new Coordinate(Integer.valueOf(6), Integer.valueOf(8), Integer.valueOf(1));
        Integer[] direction = {Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)};
        ArrayList<Cell> cells = new ArrayList<>();
        Coordinate coordinate2 = new Coordinate(Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(1));
        Coordinate coordinate3 = new Coordinate(Integer.valueOf(8), Integer.valueOf(8), Integer.valueOf(1));
        cells.add(board.getCellFromCoordinate(coordinate2).get());
        cells.add(board.getCellFromCoordinate(coordinate3).get());
        assertEquals(cells,board.getCellsFromDirection(coordinate1,direction));
        Coordinate coordinate4 = new Coordinate(Integer.valueOf(5), Integer.valueOf(8), Integer.valueOf(1));
        assertNotEquals(cells,board.getCellsFromDirection(coordinate4,direction));
    }

}