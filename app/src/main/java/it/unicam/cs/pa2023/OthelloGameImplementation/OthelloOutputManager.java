package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.boardGamesLibrary.Colors;
import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import it.unicam.cs.pa2023.boardGamesLibrary.Piece;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OthelloOutputManager {

    private static OthelloOutputManager othelloOutputManager;

    private OthelloOutputManager(){

    }

    public static OthelloOutputManager getInstance(){
        if (othelloOutputManager == null) {
            othelloOutputManager = new OthelloOutputManager();
        }
        return othelloOutputManager;
    }


    public void printBoard(OthelloBoard board, OthelloCoordinateMapper mapper){
        printGrid(board, mapper);
    }

    /*
    private void printGrid2(OthelloBoard board, OthelloCoordinateMapper mapper) {
        System.out.println("\n");
        int row, cols;
        System.out.print("  ");
        for (cols = 1; cols <= board.getWidth(); cols++) {
            System.out.print("  " + mapper.getKeyFromMap(cols) + " ");
        }
        System.out.println("\n  +---+---+---+---+---+---+---+---+ ");
        for (row = 1; row <= board.getHeight(); row++) {
            System.out.print(row + " | ");
            for (cols = 0; cols < 10; cols++) {
                if(board.getCellFromCoordinate(new Coordinate(cols, row,1)).isPresent()){
                    if(board.getCellFromCoordinate(new Coordinate(cols, row,1)).get().getPieceOptional().isPresent()){
                        if(board.getCellFromCoordinate(new Coordinate(cols, row,1)).get().getPieceOptional().get().getColor() == Colors.DARK){
                            System.out.print( "B" + " | ");
                        }else{
                            System.out.print( "W" + " | ");
                        }
                    }else{
                        System.out.print( " " + " | ");
                    }
                }
            }
            System.out.println("\n  +---+---+---+---+---+---+---+---+ ");
        }
    }
    */

    private void printGrid(OthelloBoard board, OthelloCoordinateMapper mapper) {
        System.out.print("\n  " + IntStream.rangeClosed(1, board.getWidth())
                .mapToObj(i -> "  " + mapper.getKeyFromMap(i) + " ")
                .collect(Collectors.joining()));
        System.out.println("\n  +---+---+---+---+---+---+---+---+ ");
        for (int i = 1; i <= board.getHeight(); i++) {
            System.out.print(i + " |");
            for (int j = 1; j <= board.getWidth(); j++) {
                String value = board.getCellFromCoordinate(new Coordinate(j, i, 1))
                        .flatMap(cell -> cell.getPieceOptional().map(Piece::getColor)
                                .map(color -> color == Colors.DARK ? "B" : "W"))
                        .orElse(" ");
                System.out.print(" " + value + " |");
            }
            System.out.println("\n  +" + "---+".repeat(board.getWidth() - 1) + "---+ ");
        }
    }

    public void printScore(ArrayList<OthelloPlayer> players){
        for (OthelloPlayer player : players) {
            System.out.println("\nPlayer " +player.getColor()+ " score: " + player.getScore());
        }
    }

}
