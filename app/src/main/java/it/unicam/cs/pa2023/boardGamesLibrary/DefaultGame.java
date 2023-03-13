package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public abstract class DefaultGame<T extends DefaultPlayer, K extends DefaultRule, B extends DefaultBoard, D extends DefaultCoordinateMapper> implements Game<T, K, B> {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<K> gameRules;
    private ArrayList<Piece> gamePieces;
    private ArrayList<T> players;
    private String gameName;
    private B gameBoard;
    private int turn = 0;
    private ArrayList<GameState<B,T>> gameStateHistory;
    private D defaultCoordinateMapper;

    /**
     * DefaultGame constructor creates a default game with all values set to null or "".
     */
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

    /**
     * This method returns the game rules.
     *
     * @return ArrayList of the game rules.
     */
    public ArrayList<K> getGameRules() {
        return gameRules;
    }

    /**
     * This method sets the game rules.
     */
    public void setGameRules(ArrayList<K> gameRules) {
        this.gameRules = gameRules;
    }

    /**
     * This method returns the players.
     *
     * @return ArrayList of the players.
     */
    public ArrayList<T> getPlayers() {
        return players;
    }

    /**
     * This method sets the players.
     */
    public void setPlayers(ArrayList<T> players) {
        this.players = players;
    }

    /**
     * This method returns the game name.
     *
     * @return the name of the game.
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * This method sets the game name.
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * This method returns the game board.
     *
     * @return the game board.
     */
    public B getGameBoard() {
        return gameBoard;
    }

    /**
     * This method sets the game board.
     */
    public void setGameBoard(B gameBoard) {
        this.gameBoard = gameBoard;
    }

    /**
     * This method returns the actual turn.
     *
     * @return turn.
     */
    public int getTurn() {
        return turn;
    }

    /**
     * This method sets the game turn.
     */
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
