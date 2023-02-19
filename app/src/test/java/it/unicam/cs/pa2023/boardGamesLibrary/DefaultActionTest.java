package it.unicam.cs.pa2023.boardGamesLibrary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class DefaultActionTest {

    @Test
    public void testActions(){
        Integer x=1, y=4, z=1;
        Coordinate coordinate = new Coordinate(x,y,z);
        Coordinate resultCoordinate = new Coordinate(x, Integer.valueOf(7),z);
        DefaultAction action = new DefaultAction();
        assertEquals(resultCoordinate,action.verticalMovement(coordinate,3));
        Exception exception1 = assertThrows(
                IllegalArgumentException.class,
                () -> action.verticalMovement(coordinate,0));
        assertEquals("The number of steps passed is not valid. Insert a valid number.", exception1.getMessage());
        resultCoordinate = new Coordinate(Integer.valueOf(4),y,z);
        assertEquals(resultCoordinate,action.horizontalMovement(coordinate,3));
        Exception exception2 = assertThrows(
                IllegalArgumentException.class,
                () -> action.horizontalMovement(coordinate,0));
        assertEquals("The number of steps passed is not valid. Insert a valid number.", exception2.getMessage());
        resultCoordinate = new Coordinate(Integer.valueOf(2), Integer.valueOf(5),z);
        assertEquals(resultCoordinate,action.diagonalMovement(coordinate,1));
        Exception exception3 = assertThrows(
                IllegalArgumentException.class,
                () -> action.diagonalMovement(coordinate,0));
        assertEquals("The number of steps passed is not valid. Insert a valid number.", exception3.getMessage());
        resultCoordinate = new Coordinate(x,y,Integer.valueOf(3));
        assertEquals(resultCoordinate,action.changeBoard(coordinate,3));
        Exception exception4 = assertThrows(
                IllegalArgumentException.class,
                () -> action.changeBoard(coordinate,0));
        assertEquals("The board number passed is not valid. Insert a valid number.", exception4.getMessage());
        Exception exception5 = assertThrows(
                IllegalArgumentException.class,
                () -> action.changeBoard(coordinate,1));
        assertEquals("The board number passed is not valid. Insert a valid number.", exception5.getMessage());
    }

    @Test
    public void doActionTest(){
        DefaultBoard board = new DefaultBoard(8,8,1,Colors.DARK);
        Piece queen = new Piece(Colors.LIGHT, 9, "Queen");
        Integer x=1, y=4, z=1;
        Coordinate coordinate1 = new Coordinate(x,y,z);
        Cell testCell1 = new Cell(coordinate1,Colors.LIGHT,Optional.of(queen));
        DefaultAction action = new DefaultAction();
        //Put a Piece on the board.
        assertTrue(action.doAction(Optional.empty(), Optional.of(coordinate1), board, queen).getBoard().contains(testCell1));
        //Remove a Piece from the board.
        assertFalse(action.doAction(Optional.of(coordinate1), Optional.empty(), board, queen).getBoard().contains(testCell1));
        //Move a cell
        Coordinate coordinate2 = new Coordinate(Integer.valueOf(3), Integer.valueOf(4), z);
        Coordinate coordinate3 = new Coordinate(Integer.valueOf(7), Integer.valueOf(4), z);
        action.doAction(Optional.empty(),Optional.of(coordinate2), board, queen);
        assertNotEquals(Optional.empty(), action.doAction(Optional.of(coordinate2), Optional.of(coordinate3),board,queen).getCellFromCoordinate(coordinate3).getPieceOptional());
        assertEquals(Optional.of(queen), action.doAction(Optional.of(coordinate2), Optional.of(coordinate3), board, queen).getCellFromCoordinate(coordinate3).getPieceOptional());
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> action.doAction(Optional.empty(), Optional.empty(), board, queen));
        assertEquals("You didn't pass any coordinate set. You have to pass at least one.", exception.getMessage());
    }

}