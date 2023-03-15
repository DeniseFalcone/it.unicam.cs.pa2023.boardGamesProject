package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Default implementation of the Game interface.
 * It has eight attributes: gameRules (a list with the game rules), players (a list with the players of the game),
 * gameName (the name of the game), gameBoard (the chessboard used to play the game), gamePieces (the pieces used to play
 * the game), turn (the turn of the game), gameStateHistory (the board-states of the whole game) and a defaultCoordinateMapper
 * used to map the coordinates.
 *
 * @param <T> A class that extends the DefaultPlayer.
 * @param <K> A class that extends the DefaultRule.
 * @param <B> A class that extends the DefaultBoard.
 * @param <D> A class that extends the DefaultCoordinateMapper.
 */
public abstract class DefaultGame<T extends DefaultPlayer<D>, K extends DefaultRule<B>, B extends DefaultBoard, D extends DefaultCoordinateMapper> implements Game<T, K, B> {
    private ArrayList<K> gameRules;
    private ArrayList<Piece> gamePieces;
    private ArrayList<T> players;
    private String gameName;
    private B gameBoard;
    private int turn = 0;
    private ArrayList<GameState<B,T>> gameStateHistory;
    private D defaultCoordinateMapper;

    public DefaultGame(){
        this.gameRules = new ArrayList<>();
        this.players = new ArrayList<>();
        this.gameName = "";
        this.gameBoard = null;
        this.gamePieces = new ArrayList<>();
        this.gameStateHistory = new ArrayList<>();
        this.defaultCoordinateMapper = null;
    }

    @Override
    public abstract void setupGame();

    @Override
    public abstract void playGame();

    @Override
    public boolean addPlayer(T player) {
        return this.getPlayers().add(player);
    }

    @Override
    public boolean deletePlayer(T player) {
        return this.getPlayers().remove(player);
    }

    @Override
    public boolean addRule(K rule) {
        return this.getGameRules().add(rule);
    }

    @Override
    public boolean deleteRule(K rule) {
        return this.getGameRules().remove(rule);
    }

    @Override
    public boolean addGameState(GameState<B,T> gameState) {
        return this.gameStateHistory.add(gameState);
    }

    @Override
    public boolean removeLastGameState() {
        return this.getGameStateHistory().remove(this.getGameStateHistory().get(this.getGameStateHistory().size()-1));
    }

    @Override
    public abstract void updatePlayersScore();


    public ArrayList<K> getGameRules() {
        return gameRules;
    }

    public void setGameRules(ArrayList<K> gameRules) {
        this.gameRules = gameRules;
    }

    public ArrayList<T> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<T> players) {
        this.players = players;
    }

    @Override
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public B getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(B gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultGame<?, ?, ?, ?> that = (DefaultGame<?, ?, ?, ?>) o;
        return getTurn() == that.getTurn() && Objects.equals(getGameRules(), that.getGameRules()) && Objects.equals(getPlayers(), that.getPlayers()) && Objects.equals(getGameName(), that.getGameName()) && Objects.equals(getGameBoard(), that.getGameBoard()) && Objects.equals(gameStateHistory, that.gameStateHistory) && Objects.equals(getDefaultCoordinateMapper(), that.getDefaultCoordinateMapper());
    }

    public void setGameStateHistory(ArrayList<GameState<B,T>> gameStateHistory) {
        this.gameStateHistory = gameStateHistory;
    }

    public ArrayList<GameState<B,T>> getGameStateHistory() {
        return this.gameStateHistory;
    }

    public D getDefaultCoordinateMapper() {
        return defaultCoordinateMapper;
    }

    public void setDefaultCoordinateMapper(D defaultCoordinateMapper) {
        this.defaultCoordinateMapper = defaultCoordinateMapper;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameRules(), getGameName());
    }

    @Override
    public String toString() {
        return "Game" + gameName;
    }

    public ArrayList<Piece> getGamePieces() {
        return gamePieces;
    }

    public void setGamePieces(ArrayList<Piece> gamePieces) {
        this.gamePieces = gamePieces;
    }

    @Override
    public T switchPlayer(T player) {
        int newIndex = this.getPlayers().indexOf(player)+1;
        if(newIndex == this.getPlayers().size()){
            newIndex = 0;
        }
        return getPlayers().get(newIndex);
    }
}
