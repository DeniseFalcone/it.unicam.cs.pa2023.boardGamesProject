package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules.ChangeColorRule;
import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules.InsertPieceRule;
import it.unicam.cs.pa2023.boardGamesLibrary.*;
import java.util.*;

/**
 * This class extends the DefaultGame class and implements an OthelloGame.
 */
public class OthelloGame extends DefaultGame<OthelloPlayer, OthelloRule, OthelloBoard, OthelloCoordinateMapper> {

    public OthelloGame() {
        super();
        this.setDefaultCoordinateMapper(new OthelloCoordinateMapper(new HashMap<>()));
        this.setGameName("Othello");
        this.setupGame();
    }

    /**
     * Given a player, firstly it prints the board and the turn player, then gets a valid coordinate from the player,
     * applies the rules to the coordinate, updates the turn and the players' score and returns true, otherwise,
     * if the action is not valid, returns false without saving the board whit the rules applied and the game state.
     *
     * @param player The player whose turn it is.
     * @return true if the player played his turn, false otherwise.
     */
    protected boolean playTurn(OthelloPlayer player){
        GameState<OthelloBoard, OthelloPlayer> gameState = new GameState<>(this.cloneOthelloBoard(this.getGameBoard()), player, this.getTurn());
        OthelloOutputManager.getInstance().printBoard(this.getGameBoard(),this.getDefaultCoordinateMapper());
        OthelloOutputManager.getInstance().printTurnPlayer(player);
        Coordinate turnCoordinate = getValidCoordinate(player);
        Piece playerPiece = this.getGamePieces().remove(0);
        playerPiece.setColor(player.getColor());
        for (OthelloRule rule : this.getGameRules()) {
            if(!rule.applyRule(playerPiece, this.getGameBoard(), turnCoordinate)){
                this.setGameBoard(this.cloneOthelloBoard(gameState.getBoard()));
                System.out.println("You can't make this action.");
                this.getGamePieces().add(playerPiece);
                return false;
            }
        }
        this.setTurn(this.getTurn() + 1);
        this.addGameState(gameState);
        updatePlayersScore();
        OthelloOutputManager.getInstance().printScore(this.getPlayers());
        return true;
    }

    /**
     * This method makes the players play Othello. The game is played until one of the players
     * can't play a turn, then the other player is checked to see if they can play.
     * If they can't, the game is over, otherwise they continue until they both can't play.
     */
    @Override
    public void playGame(){
        OthelloPlayer player = this.getPlayers().get(0);
        boolean gameEnded = false;
        while(!gameEnded){
            if(playerCanPlayTurn(player)){
                boolean validTurn = false;
                while(!validTurn){
                    validTurn = playTurn(player);
                }
                player = switchPlayer(player);
            }else{
                player = switchPlayer(player);
                if(!playerCanPlayTurn(player)){
                    gameEnded = true;
                }
            }
        }
        OthelloOutputManager.getInstance().printWinner(this.getPlayers());
        InputManager.getInstance().closeScanner();
    }


    /**
     * Get a coordinate from the player, and keep asking until the coordinate is valid.
     *
     * @param player the player whose turn it is.
     * @return a valid coordinate.
     */
    private Coordinate getValidCoordinate(OthelloPlayer player){
        Coordinate coordinate;
        do{
            coordinate = player.insertCoordinate();
        }
        while(!this.getGameBoard().checkIfCoordinateIsValid(coordinate));
        return coordinate;
    }

    @Override
    public void setupGame(){
        this.setupPlayers();
        this.setGamePieces(createPieces());
        this.setupBoard();
        this.setupRules();
    }

    /**
     * This method sets up the rules to play Othello: a ChangeColorRule and an InsertPieceRule.
     */
    private void setupRules(){
        ChangeColorRule changeColorRule = new ChangeColorRule();
        InsertPieceRule insertPieceRule = new InsertPieceRule();
        this.addRule(changeColorRule);
        this.addRule(insertPieceRule);
    }

    /**
     * This method sets up the two players to play Othello, one that plays with the dark pieces and one with the light ones.
     */
    private void setupPlayers(){
        OthelloPlayer player1 = new OthelloPlayer("Black", Colors.DARK, 2, this.getDefaultCoordinateMapper());
        OthelloPlayer player2 = new OthelloPlayer("White", Colors.LIGHT,2, this.getDefaultCoordinateMapper());
        this.addPlayer(player1);
        this.addPlayer(player2);
    }

    /**
     * This method sets up the game board and insert the first four pieces (two for the DARK player and two for the LIGHT one).
     */
    private void setupBoard() {
        this.setGameBoard(new OthelloBoard(8,8,1));
        Coordinate[] coordinates = {
                new Coordinate(4, 4),
                new Coordinate(5, 5),
                new Coordinate(5, 4),
                new Coordinate(4, 5)
        };
        Colors[] colors = {Colors.LIGHT, Colors.LIGHT, Colors.DARK, Colors.DARK};
        for (int i = 0; i < coordinates.length; i++) {
            Piece piece = this.getGamePieces().remove(0);
            piece.setColor(colors[i]);
            this.getGameBoard().replacePieceInCell(coordinates[i], Optional.of(piece));
        }
    }

    /**
     * This method creates 64 BASECOLOR pieces and returns them in an ArrayList.
     *
     * @return An ArrayList of Piece objects.
     */
    private ArrayList<Piece> createPieces(){
        ArrayList<Piece> playerPieces = new ArrayList<>();
        for(int i=0; i<64;i++){
            Piece piece = new Piece(Colors.BASECOLOR, 1, "piece");
            playerPieces.add(piece);
        }
        return  playerPieces;
    }



    @Override
    public void updatePlayersScore() {
        for(OthelloPlayer player : this.getPlayers()){
            int score = 0;
            for (Cell ignored : this.getGameBoard().getCellsWithPiecesOfOneColor(player.getColor())) {
                score += 1;
            }
            player.setScore(score);
        }
    }

    /**
     * Given an OthelloPlayer, returns true if the player can make at least one action and false otherwise.
     *
     * @param player player to check if he can play.
     * @return true if the player can make at least one action and false otherwise.
     */
    protected boolean playerCanPlayTurn(OthelloPlayer player){
        if(this.getGamePieces().size() == 0){
            return false;
        }
        Piece playerPiece = this.getGamePieces().get(0);
        playerPiece.setColor(player.getColor());
        for(Cell cell: this.getGameBoard().getBoard()){
            OthelloBoard tempBoard = cloneOthelloBoard(this.getGameBoard());
            if(getGameRules().stream()
                    .allMatch(x -> x.applyRule(playerPiece, tempBoard, cell.getCoordinate()))){
                return true;
            }
        }
        return false;
    }

    /**
     * Given a board to clone, returns a deep clone of the board.
     *
     * @param boardToCopy a board to clone.
     * @return the OthelloBoard cloned.
     */
    private OthelloBoard cloneOthelloBoard(OthelloBoard boardToCopy){
        OthelloBoard othelloBoard = new OthelloBoard(8,8,1);
        for(Cell cell: boardToCopy.getBoard()){
            Optional<Piece> optionalPiece;
            if(cell.hasPiece()){
                Piece piece = new Piece(cell.getPieceOptional().get().getColor(), cell.getPieceOptional().get().getValue(), cell.getPieceOptional().get().getName());
                optionalPiece = Optional.of(piece);
            }else{
                optionalPiece = Optional.empty();
            }
            Cell tempCell = new Cell(cell.getCoordinate(),cell.getColor(), optionalPiece);
            othelloBoard.getBoard().set(boardToCopy.getBoard().indexOf(cell), tempCell);
        }
        return othelloBoard;
    }

}
