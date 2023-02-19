package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Optional;

public class DefaultAction<B extends DefaultBoard> implements Action<B>{

    @Override
    public B doAction(Optional<Coordinate> oldCoordinate, Optional<Coordinate> newCoordinate, B board, Piece piece) {
        //We are positioning a piece in the new coordinates
        if(oldCoordinate.isEmpty() && newCoordinate.isPresent()){
            board.replacePieceInCell(newCoordinate.get(), Optional.of(piece));
        //We are removing a piece from the old coordinates
        }else if(newCoordinate.isEmpty() && oldCoordinate.isPresent()){
            board.replacePieceInCell(oldCoordinate.get(), Optional.empty());
        //We are changing the position of a piece from the old coordinates to the new ones.
        }else if(oldCoordinate.isPresent()){
            board.replacePieceInCell(newCoordinate.get(), Optional.of(piece));
            board.replacePieceInCell(oldCoordinate.get(), Optional.empty());
        }else{
            throw new IllegalArgumentException("You didn't pass any coordinate set. You have to pass at least one.");
        }
        return board;
    }

}
