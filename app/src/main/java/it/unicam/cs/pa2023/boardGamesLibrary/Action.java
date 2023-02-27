package it.unicam.cs.pa2023.boardGamesLibrary;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Descrive un'azione del player durante il suo turno.
 */
@FunctionalInterface
public interface Action<B extends Board> {


    //Cambia lo stato della board eseguendo l'azione da essa validata
    // 0, x,y,z --> inserendo (prima non c'era, dopo si)
    // x,y,z, 0 --> cancellare
    // 0 0 --> cancella tutto
    B doAction(Optional<Coordinate> oldCoordinate, Optional<Coordinate> newCoordinate, B board, Piece piece);

    default Coordinate verticalMovement(Coordinate coordinate, int n_steps){
        if(n_steps == 0){
            throw new IllegalArgumentException("The number of steps passed is not valid. Insert a valid number.");
        }
        return new Coordinate(coordinate.getX(), coordinate.getY() + n_steps, coordinate.getZ());
    }

    default Coordinate horizontalMovement(Coordinate coordinate, int n_steps){
        if(n_steps == 0){
            throw new IllegalArgumentException("The number of steps passed is not valid. Insert a valid number.");
        }
        return new Coordinate(coordinate.getX() + n_steps, coordinate.getY(), coordinate.getZ());
    }

    default Coordinate diagonalMovement(Coordinate coordinate, int x_steps, int y_steps){
        if(y_steps == 0 || x_steps == 0){
            throw new IllegalArgumentException("The number of steps passed is not valid. Insert a valid number.");
        }
        return new Coordinate(coordinate.getX() + x_steps, coordinate.getY() + y_steps, coordinate.getZ());
    }

    default Coordinate getCoordinateFromDirection(Coordinate coordinate, int x, int y, int z){
        return new Coordinate(coordinate.getX() + x, coordinate.getY() + y, coordinate.getZ() + z);
    }

    default Coordinate changeBoard(Coordinate coordinate, int n_board){
        if(n_board <= 0 || n_board == coordinate.getZ() ){
            throw new IllegalArgumentException("The board number passed is not valid. Insert a valid number.");
        }
        return new Coordinate(coordinate.getX(), coordinate.getY(), n_board);
    }

}
