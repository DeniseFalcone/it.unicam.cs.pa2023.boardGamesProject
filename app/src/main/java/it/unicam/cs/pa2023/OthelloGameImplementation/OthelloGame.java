package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules.ChangeColorRule;
import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules.InsertPieceRule;
import it.unicam.cs.pa2023.boardGamesLibrary.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OthelloGame extends DefaultGame<OthelloPlayer, OthelloRule, OthelloBoard, OthelloCoordinateMapper> {

    public OthelloGame(ArrayList<OthelloRule> gameRules, ArrayList<OthelloPlayer> players, String gameName, OthelloBoard gameBoard, OthelloCoordinateMapper othelloCoordinateMapper) {
        super(gameRules, players, gameName, gameBoard, othelloCoordinateMapper);
    }


    //non e' considerato metodo implementato perche' passiamo OthelloPlayer al posto di P extends Player
    @Override
    public boolean playGame(OthelloPlayer player) {
        GameState<OthelloBoard, OthelloPlayer> gameState = new GameState<>(this.getGameBoard(), player, this.getTurn());
        this.getGameStateHistory().add(gameState);
        if(this.getTurn()==0){
            if(player.getColor() == Colors.DARK){
                Coordinate actionCoordinate = player.insertCoordinate();
                for(OthelloRule rule: this.getGameRules()){
                    if(!rule.applyRule(player.getPlayersPieces().remove(player.getPlayersPieces().size()-1), this.getGameBoard(), actionCoordinate)){
                        this.setGameBoard(gameState.getBoard());
                        this.getPlayers().set(this.getPlayers().indexOf(player), gameState.getPlayer());
                        System.out.println("You can't make this action.");
                        playGame(this.getPlayers().get(this.getPlayers().indexOf(player)));
                    }else{
                        this.setTurn(this.getTurn()+1);
                        return true;
                    }
                }
            }
        }
        return false;
    }



    //todo
    @Override
    public void setupGame(){
        setupPlayers();
        setupBoard();

        //regole
    }

    private void setupRules(){
        ChangeColorRule changeColorRule = new ChangeColorRule();
        InsertPieceRule insertPieceRule = new InsertPieceRule();
        ArrayList<OthelloRule> othelloRules = new ArrayList<>();
        this.addRule(changeColorRule);
        this.addRule(insertPieceRule);
    }

    /**
     * "Create two players, one with dark pieces and one with light pieces, and add them to the game."
     *
     * The first thing we do is create two players. The first parameter is the name of the player, the second is the color
     * of the pieces, the third is the pieces themselves, the fourth is the number of pieces the player starts with, and
     * the fifth is the coordinate mapper
     */
    private void setupPlayers(){
        OthelloPlayer player1 = new OthelloPlayer("Player1", Colors.DARK, createPlayerPieces(Colors.DARK), 2, getDefaultCoordinateMapper());
        OthelloPlayer player2 = new OthelloPlayer("Player2", Colors.LIGHT, createPlayerPieces(Colors.LIGHT), 2, getDefaultCoordinateMapper());
        this.addPlayer(player1);
        this.addPlayer(player2);
    }

    /**
     * This function sets up the board for the game
     */
    private void setupBoard(){
        Coordinate coordinate = new Coordinate(Integer.valueOf(4), Integer.valueOf(4), 1);
        this.getGameBoard().replacePieceInCell(coordinate, Optional.of(this.getPlayers().get(1).getPlayersPieces().get(0)));
        coordinate = new Coordinate(Integer.valueOf(5), Integer.valueOf(5), 1);
        this.getGameBoard().replacePieceInCell(coordinate, Optional.of(this.getPlayers().get(1).getPlayersPieces().get(1)));
        this.getPlayers().get(1).getPlayersPieces().remove(0);
        this.getPlayers().get(1).getPlayersPieces().remove(1);
        coordinate = new Coordinate(Integer.valueOf(5), Integer.valueOf(4), 1);
        this.getGameBoard().replacePieceInCell(coordinate, Optional.of(this.getPlayers().get(0).getPlayersPieces().get(0)));
        coordinate = new Coordinate(Integer.valueOf(4), Integer.valueOf(5), 1);
        this.getGameBoard().replacePieceInCell(coordinate, Optional.of(this.getPlayers().get(0).getPlayersPieces().get(1)));
        this.getPlayers().get(0).getPlayersPieces().remove(0);
        this.getPlayers().get(0).getPlayersPieces().remove(1);
    }

    /**
     * It creates 64 pieces of the same color and returns them in an ArrayList
     *
     * @param color the color of the player
     * @return An ArrayList of Piece objects.
     */
    private ArrayList<Piece> createPlayerPieces(Colors color){
        ArrayList<Piece> playerPieces = new ArrayList<>();
        for(int i=0; i<64;i++){
            Piece piece = new Piece(color, Integer.valueOf(1), "piece");
            playerPieces.add(piece);
        }
        return  playerPieces;
    }

    @Override
    public boolean getStatistics(OthelloPlayer player) {
        return false;
    }


    @Override
    public boolean updatePlayerScore(OthelloPlayer player) {
        return false;
    }




}
