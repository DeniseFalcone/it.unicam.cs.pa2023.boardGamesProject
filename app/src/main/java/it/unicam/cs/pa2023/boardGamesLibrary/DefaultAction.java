package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Optional;

public class DefaultAction<B extends DefaultBoard> implements Action<B>{

    @Override
    public B doAction(Optional<Coordinate> oldCoordinate, Optional<Coordinate> newCoordinate, B board, Piece piece) {
        if(oldCoordinate.isEmpty() && newCoordinate.isPresent()){
            board.replacePieceInCell(newCoordinate.get(), Optional.of(piece));
        }else if(newCoordinate.isEmpty() && oldCoordinate.isPresent())
            board.replacePieceInCell(oldCoordinate.get(), Optional.empty());
        else if(oldCoordinate.isPresent()){
            board.replacePieceInCell(newCoordinate.get(), Optional.of(piece));
            board.replacePieceInCell(oldCoordinate.get(), Optional.empty());
        }else{
            throw new IllegalArgumentException("You didn't pass any coordinate set. You have to pass at least one.");
        }
        return board;
    }

    @Override
    public Coordinate getCoordinateFromDirection(Coordinate coordinate, int x, int y, int z){
        return new Coordinate(coordinate.getX() + x, coordinate.getY() + y, coordinate.getZ() + z);
    }

    @Override
    public Coordinate changeBoard(Coordinate coordinate, int n_board){
        if(n_board <= 0 || n_board == coordinate.getZ() ){
            throw new IllegalArgumentException("The board number passed is not valid. Insert a valid number.");
        }
        return new Coordinate(coordinate.getX(), coordinate.getY(), n_board);
    }

    @Override
    public Coordinate diagonalMovement(Coordinate coordinate, int x_steps, int y_steps){
        if(y_steps == 0 || x_steps == 0){
            throw new IllegalArgumentException("The number of steps passed is not valid. Insert a valid number.");
        }
        return new Coordinate(coordinate.getX() + x_steps, coordinate.getY() + y_steps, coordinate.getZ());
    }

    @Override
    public Coordinate horizontalMovement(Coordinate coordinate, int n_steps){
        if(n_steps == 0){
            throw new IllegalArgumentException("The number of steps passed is not valid. Insert a valid number.");
        }
        return new Coordinate(coordinate.getX() + n_steps, coordinate.getY(), coordinate.getZ());
    }

    @Override
    public  Coordinate verticalMovement(Coordinate coordinate, int n_steps){
        if(n_steps == 0){
            throw new IllegalArgumentException("The number of steps passed is not valid. Insert a valid number.");
        }
        return new Coordinate(coordinate.getX(), coordinate.getY() + n_steps, coordinate.getZ());
    }

}
