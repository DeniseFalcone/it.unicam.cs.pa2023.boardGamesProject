package it.unicam.cs.pa2023.boardGamesLibrary;

//foto di ogni turno del gioco
public class GameState<B extends Board, P extends Player> {

    private B board;
    private P player;
    private int turnNumber;

    /**
     * GameState constructor that creates a game state of the game, that saves the board state and the next player
     * of the turn given.
     *
     * @param board board state.
     * @param player player that has to play.
     * @param turnNumber turn of the game.
     */
    public GameState(B board, P player, int turnNumber) {
        this.board = board;
        this.player = player;
        this.turnNumber = turnNumber;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "board=" + board.toString()
                + ", player=" + player.getName() +
                ", turnNumber=" + turnNumber +
                '}';
    }

    /**
     * This method returns the board of the game state.
     *
     * @return the board saved in this game state.
     */
    public B getBoard() {
        return board;
    }

    /**
     * This method sets the board.
     */
    public void setBoard(B board) {
        this.board = board;
    }

    /**
     * This method returns the player saved in this game state.
     *
     * @return the board saved in this game state.
     */
    public P getPlayer() {
        return player;
    }

    /**
     * This method sets the player.
     */
    public void setPlayer(P player) {
        this.player = player;
    }

    /**
     * This method returns the turn number saved in this game state.
     *
     * @return the turn.
     */
    public int getTurnNumber() {
        return turnNumber;
    }

    /**
     * This method sets the turn.
     */
    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }
}
