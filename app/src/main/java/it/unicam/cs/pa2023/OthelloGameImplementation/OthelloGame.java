package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules.ChangeColorRule;
import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules.InsertPieceRule;
import it.unicam.cs.pa2023.boardGamesLibrary.*;

import java.util.*;

public class OthelloGame extends DefaultGame<OthelloPlayer, OthelloRule, OthelloBoard, OthelloCoordinateMapper> {


    //sistemare così che non prende input
    public OthelloGame(ArrayList<OthelloRule> gameRules, ArrayList<OthelloPlayer> players, String gameName, OthelloBoard gameBoard, OthelloCoordinateMapper othelloCoordinateMapper) {
        super(gameRules, players, gameName, gameBoard, othelloCoordinateMapper);
    }

    /*
    @Override
    public boolean playGame(OthelloPlayer player) {
        GameState<OthelloBoard, OthelloPlayer> gameState = new GameState<>(this.getGameBoard(), player, this.getTurn());
        this.getGameStateHistory().add(gameState);
        if(!playerCanPlayTurn(player)){
            //checkIfBothDidn'tPlayTurn
            this.setTurn(this.getTurn()+1);
            playGame(this.getPlayers().get(this.getPlayers().indexOf(player)));
        }
        if(this.getTurn()==0){
            if(player.getColor() == Colors.DARK){
                Coordinate actionCoordinate = player.insertCoordinate();
                //accorciare magari con stream come altro metodo
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
     */

    private void playTurn(OthelloPlayer player){
        GameState<OthelloBoard, OthelloPlayer> gameState = new GameState<>(this.getGameBoard(), player, this.getTurn());
        this.getGameStateHistory().add(gameState);
        Coordinate turnCoordinate = getValidCoordinate(player);
        Piece playerPiece = this.getGamePieces().remove(0);
        playerPiece.setColor(player.getColor());
        for (OthelloRule rule : this.getGameRules()) {
            if(!rule.applyRule(playerPiece,this.getGameBoard(),turnCoordinate)){
                this.setGameBoard(gameState.getBoard());
                System.out.println("You can't make this action.");
                playTurn(gameState.getPlayer());
            }else{
                this.setTurn(this.getTurn() + 1);
            }
        }
    }

    public void playGame(){
        OthelloPlayer player = this.getPlayers().get(0);
        boolean gameEnded = false;
        while(!gameEnded){
            if(playerCanPlayTurn(player)){
                playTurn(player);
                player = switchPlayer(player);
            }else{
                player = switchPlayer(player);
                if(!playerCanPlayTurn(player)){
                    gameEnded = true;
                }
            }
        }
    }

    private Coordinate getValidCoordinate(OthelloPlayer player){
        Coordinate coordinate;
        do{
            System.out.println("Insert a valid coordinate to insert a piece.");
            coordinate = player.insertCoordinate();
        }
        while(!this.getGameBoard().checkIfCoordinateIsValid(coordinate));
        return coordinate;
    }

    //todo
    @Override
    public void setupGame(){
        setupPlayers();
        setupBoard();
        setupRules();
    }

    private void setupRules(){
        ChangeColorRule changeColorRule = new ChangeColorRule();
        InsertPieceRule insertPieceRule = new InsertPieceRule();
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
        OthelloPlayer player1 = new OthelloPlayer("Player1", Colors.DARK, 2, getDefaultCoordinateMapper());
        OthelloPlayer player2 = new OthelloPlayer("Player2", Colors.LIGHT,2, getDefaultCoordinateMapper());
        this.addPlayer(player1);
        this.addPlayer(player2);
    }

    /*
     * Troppo lungo
     * This function sets up the board for the game

    private void setupBoard(){
        Coordinate coordinate1 = new Coordinate(Integer.valueOf(4), Integer.valueOf(4), 1);
        Coordinate coordinate2 = new Coordinate(Integer.valueOf(5), Integer.valueOf(5), 1);
        Coordinate coordinate3 = new Coordinate(Integer.valueOf(5), Integer.valueOf(4), 1);
        Coordinate coordinate4 = new Coordinate(Integer.valueOf(4), Integer.valueOf(5), 1);
        Piece whitePiece = this.getGamePieces().remove(0);
        whitePiece.setColor(Colors.LIGHT);
        this.getGameBoard().replacePieceInCell(coordinate1, Optional.of(whitePiece));
        whitePiece = this.getGamePieces().remove(0);
        whitePiece.setColor(Colors.LIGHT);
        this.getGameBoard().replacePieceInCell(coordinate2, Optional.of(whitePiece));
        Piece blackPiece = this.getGamePieces().remove(0);
        blackPiece.setColor(Colors.DARK);
        this.getGameBoard().replacePieceInCell(coordinate3, Optional.of(blackPiece));
        blackPiece = this.getGamePieces().remove(0);
        blackPiece.setColor(Colors.DARK);
        this.getGameBoard().replacePieceInCell(coordinate4, Optional.of(blackPiece));
    }
    */

    private void setupBoard() {
        Coordinate[] coordinates = {
                new Coordinate(4, 4, 1),
                new Coordinate(5, 5, 1),
                new Coordinate(5, 4, 1),
                new Coordinate(4, 5, 1)
        };
        Colors[] colors = {Colors.LIGHT, Colors.LIGHT, Colors.DARK, Colors.DARK};
        for (int i = 0; i < coordinates.length; i++) {
            Piece piece = this.getGamePieces().remove(0);
            piece.setColor(colors[i]);
            this.getGameBoard().replacePieceInCell(coordinates[i], Optional.of(piece));
        }
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


    protected boolean playerCanPlayTurn(OthelloPlayer player){
        Piece playerPiece = this.getGamePieces().get(0);
        playerPiece.setColor(player.getColor());
        for(Cell cell: this.getGameBoard().getBoard()){
            OthelloBoard tempBoard = this.getGameBoard();
            if(getGameRules().stream()
                    .allMatch(x -> x.applyRule(playerPiece, tempBoard, cell.getCoordinate()))){
                return true;
            }
        }
        return false;
    }



}
