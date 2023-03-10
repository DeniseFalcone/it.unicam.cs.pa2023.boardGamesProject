package it.unicam.cs.pa2023.OthelloGameImplementation;

import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules.ChangeColorRule;
import it.unicam.cs.pa2023.OthelloGameImplementation.OthelloRules.InsertPieceRule;
import it.unicam.cs.pa2023.boardGamesLibrary.*;

import java.util.*;

public class OthelloGame extends DefaultGame<OthelloPlayer, OthelloRule, OthelloBoard, OthelloCoordinateMapper> {

    public OthelloGame() {
        super();
        this.setDefaultCoordinateMapper(new OthelloCoordinateMapper(new HashMap<>()));
        this.setGameName("Othello");
        this.setupGame();

    }

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
        this.getGameStateHistory().add(gameState);
        updatePlayersScore();
        OthelloOutputManager.getInstance().printScore(this.getPlayers());
        return true;
    }

    /**
     * The game is played until one player can't play a turn, then the other player is checked to see if they can play a
     * turn. If they can't, the game is over.
     */
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
        OthelloPlayer player1 = new OthelloPlayer("Black", Colors.DARK, 2, this.getDefaultCoordinateMapper());
        OthelloPlayer player2 = new OthelloPlayer("White", Colors.LIGHT,2, this.getDefaultCoordinateMapper());
        this.addPlayer(player1);
        this.addPlayer(player2);
    }

    private void setupBoard() {
        this.setGameBoard(new OthelloBoard(8,8,1));
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
     * @return An ArrayList of Piece objects.
     */
    private ArrayList<Piece> createPieces(){
        ArrayList<Piece> playerPieces = new ArrayList<>();
        for(int i=0; i<64;i++){
            Piece piece = new Piece(Colors.DARK, Integer.valueOf(1), "piece");
            playerPieces.add(piece);
        }
        return  playerPieces;
    }



    @Override
    public void updatePlayersScore() {
        for(OthelloPlayer player : this.getPlayers()){
            int score = 0;
            for (Cell cell : this.getGameBoard().getCellsWithPiecesOfOneColor(player.getColor())) {
                score += 1;
            }
            player.setScore(score);
        }
    }


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

    private OthelloBoard cloneOthelloBoard(OthelloBoard boardToCopy){
        OthelloBoard othelloBoard = new OthelloBoard(8,8,1);
        for(Cell cell: boardToCopy.getBoard()){
            Optional<Piece> optionalPiece;
            if(cell.getPieceOptional().isPresent()){
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
