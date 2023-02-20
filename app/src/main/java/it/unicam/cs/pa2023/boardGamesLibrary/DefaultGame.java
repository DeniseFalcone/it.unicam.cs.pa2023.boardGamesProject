package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.Objects;

public abstract class DefaultGame<T extends DefaultPlayer<D>, K extends DefaultRule, B extends DefaultBoard, D extends DefaultCoordinateMapper> implements Game<T, K, B> {

    private ArrayList<K> gameRules;
    private ArrayList<T> players;
    private String gameName;
    private B gameBoard;
    private int turn;
    private ArrayList<GameState<B,T>> gameStateHistory;
    private D defaultCoordinateMapper;

    public DefaultGame(ArrayList<K> gameRules, ArrayList<T> players, String gameName, B gameBoard) {
        this.gameRules = gameRules;
        this.players = players;
        this.gameName = gameName;
        this.gameBoard = gameBoard;
        this.turn = 0;
        this.gameStateHistory = new ArrayList<>();
        this.defaultCoordinateMapper = null;
    }

    public DefaultGame(ArrayList<K> gameRules, ArrayList<T> players, String gameName, B gameBoard, D defaultCoordinateMapper) {
        this.gameRules = gameRules;
        this.players = players;
        this.gameName = gameName;
        this.gameBoard = gameBoard;
        this.turn = 0;
        this.gameStateHistory = new ArrayList<>();
        this.defaultCoordinateMapper = defaultCoordinateMapper;
    }

    @Override
    public abstract void setupGame();

    @Override
    public abstract void playGame(T player);

    @Override
    public abstract boolean getStatistics(T player);

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

    //TODO
    @Override
    public boolean changeRule(K rule){
        return false;
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
    public boolean addPlayerPiece(Piece piece, T player) {
        return player.getPlayersPieces().add(piece);
    }

    @Override
    public boolean removePlayerPiece(Piece piece, T player) {
        return player.getPlayersPieces().remove(piece);
    }

    @Override
    public abstract boolean updatePlayerScore(T player);

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
}
