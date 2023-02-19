package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.boardGamesLibrary.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OthelloGame extends DefaultGame {

    private OthelloCoordinateMapper othelloCoordinateMapper;

    public OthelloGame(ArrayList<OthelloRule> gameRules, ArrayList<OthelloPlayer> players, String gameName, OthelloBoard gameBoard) {
        super(gameRules, players, gameName, gameBoard);
        this.othelloCoordinateMapper = createOthelloCoordinateMapper();
    }


    //non e' considerato metodo implementato perche' passiamo OthelloPlayer al posto di P extends Player
    //@Override
    public void playGame(OthelloPlayer player) {
        if(this.getTurn()==0){
            if(player.getColor() == Colors.DARK){
                Coordinate actionCoordinate = player.insertCoordinate();
                //rules
            }
        }
    }

    //todo
    @Override
    public void setupGame(){
        OthelloPlayer player1 = new OthelloPlayer("Player1", Colors.DARK, createPlayerPieces(Colors.DARK), 2, this.getOthelloCoordinateMapper());
        OthelloPlayer player2 = new OthelloPlayer("Player2", Colors.LIGHT, createPlayerPieces(Colors.LIGHT), 2, this.getOthelloCoordinateMapper());
        this.addPlayer(player1);
        this.addPlayer(player2);
        Coordinate coordinate = new Coordinate(Integer.valueOf(4), Integer.valueOf(4), 1);
        this.getGameBoard().replacePieceInCell(coordinate, Optional.of(player2.getPlayersPieces().get(0)));
        coordinate = new Coordinate(Integer.valueOf(5), Integer.valueOf(5), 1);
        this.getGameBoard().replacePieceInCell(coordinate, Optional.of(player2.getPlayersPieces().get(1)));
        player2.getPlayersPieces().remove(0);
        player2.getPlayersPieces().remove(1);
        coordinate = new Coordinate(Integer.valueOf(5), Integer.valueOf(4), 1);
        this.getGameBoard().replacePieceInCell(coordinate, Optional.of(player1.getPlayersPieces().get(0)));
        coordinate = new Coordinate(Integer.valueOf(4), Integer.valueOf(5), 1);
        this.getGameBoard().replacePieceInCell(coordinate, Optional.of(player1.getPlayersPieces().get(1)));
        player1.getPlayersPieces().remove(0);
        player1.getPlayersPieces().remove(1);
        //regole
    }

    private ArrayList<Piece> createPlayerPieces(Colors color){
        Piece blackPiece = new Piece(Colors.DARK, Integer.valueOf(1), "pedina");
        ArrayList<Piece> playerPieces = new ArrayList<>();
        for(int i=0; i<64;i++){
            playerPieces.add(blackPiece);
        }
        return  playerPieces;
    }

    @Override
    public boolean getStatistics(DefaultPlayer player) {
        return false;
    }


    @Override
    public boolean updatePlayerScore(DefaultPlayer player) {
        return false;
    }

    private static OthelloCoordinateMapper createOthelloCoordinateMapper(){
        Map<Character, Integer> map = new HashMap<>();
        map.putIfAbsent(Character.valueOf('a'), Integer.valueOf(1));
        map.putIfAbsent(Character.valueOf('b'), Integer.valueOf(2));
        map.putIfAbsent(Character.valueOf('c'), Integer.valueOf(3));
        map.putIfAbsent(Character.valueOf('d'), Integer.valueOf(4));
        map.putIfAbsent(Character.valueOf('e'), Integer.valueOf(5));
        map.putIfAbsent(Character.valueOf('f'), Integer.valueOf(6));
        map.putIfAbsent(Character.valueOf('g'), Integer.valueOf(7));
        map.putIfAbsent(Character.valueOf('h'), Integer.valueOf(8));
        return new OthelloCoordinateMapper(map);
    }

    public OthelloCoordinateMapper getOthelloCoordinateMapper() {
        return othelloCoordinateMapper;
    }

    public void setOthelloCoordinateMapper(OthelloCoordinateMapper othelloCoordinateMapper) {
        this.othelloCoordinateMapper = othelloCoordinateMapper;
    }
}
