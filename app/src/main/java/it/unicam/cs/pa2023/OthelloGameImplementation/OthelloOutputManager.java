package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.boardGamesLibrary.Colors;
import it.unicam.cs.pa2023.boardGamesLibrary.Coordinate;
import it.unicam.cs.pa2023.boardGamesLibrary.Piece;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OthelloOutputManager {

    private static OthelloOutputManager othelloOutputManager;
    private OthelloOutputManager(){}

    public static OthelloOutputManager getInstance(){
        if (othelloOutputManager == null) {
            othelloOutputManager = new OthelloOutputManager();
        }
        return othelloOutputManager;
    }


    public void printBoard(OthelloBoard board, OthelloCoordinateMapper mapper){
        printGrid(board, mapper);
    }

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
            System.out.println("Player " +player.getName()+ " score: " + player.getScore());
        }
    }

    public void printTurnPlayer(OthelloPlayer player){
        System.out.println("Player " + player.getName() + " turn.");
    }

    public void printWinner(ArrayList<OthelloPlayer> players){
        OthelloPlayer winner = players.stream()
                .max(Comparator.comparing(OthelloPlayer::getScore))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("\nThe game is over!");
        System.out.println("The winner is: " + winner.getName() + " with: " + winner.getScore() + " points.");
    }

}
