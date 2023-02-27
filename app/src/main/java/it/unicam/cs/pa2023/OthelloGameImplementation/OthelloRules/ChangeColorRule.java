package it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules;

import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloBoard;
import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRule;
import it.unicam.cs.pa2023.boardGamesLibrary.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChangeColorRule extends OthelloRule {

    @Override
    public boolean applyRule(Piece piece, OthelloBoard board, Coordinate coordinate) {
        return true;
    }

    private boolean checkNeighbours(Coordinate coordinate, OthelloBoard board, Colors color) {
        for(Optional<Cell> cell : board.getCellNeighbours(coordinate)){
            if(cell.isPresent()){
                if(cell.get().getPieceOptional().isPresent()){
                    if(cell.get().getPieceOptional().get().getColor() != color){
                        Integer[] direction = getDirection(coordinate,cell.get().getCoordinate());
                        ArrayList<Cell> cellsFromOneDirection = board.getCellsFromDirection(coordinate, direction);
                    }
                }
            }
        }
        return false;
    }

    private void checkCellsColorOneDirection(ArrayList<Cell> cells, Colors color){
        /*
        controlla che dato il nostro colore, finche' le pedine hanno colore opposto vado avanti e continuo il controllo;
        se trovo una cella con pedina dello stesso colore, ritorno l'arraylist corrispondente, altrimenti ritorno null.
         */
    }

    private Integer[] getDirection(Coordinate actualCoordinate, Coordinate neighbourCoordinate){
        Integer[] direction = new Integer[3];
        direction[0] = neighbourCoordinate.getX() - actualCoordinate.getX();
        direction[1] = neighbourCoordinate.getY() - actualCoordinate.getY();
        direction[2] = Integer.valueOf(0);
        return direction;
    }

    //controllo vicini dim. 1 (se ho colore diverso considero la direzione)
    //prende le linee rette da considerare
    //metodo che considera le varie dimensioni
}
