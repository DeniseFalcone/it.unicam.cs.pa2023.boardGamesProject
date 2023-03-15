package it.unicam.cs.pa2023.boardGamesLibrary;

/**
 * This class is used to create a game-state object that saves the board of that turn and the next player.
 * It has three attributes: board (the board-state to save), player (the player of the next turn) and turnNumber (the turn saved).
 *
 * @param <B> A class that extends the Board interface.
 * @param <P> A class that extends the Player interface.
 */
public class GameState<B extends Board, P extends Player> {

    private B board;
    private P player;
    private int turnNumber;

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

    public B getBoard() {
        return board;
    }

    public void setBoard(B board) {
        this.board = board;
    }

    public P getPlayer() {
        return player;
    }

    public void setPlayer(P player) {
        this.player = player;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }
}
