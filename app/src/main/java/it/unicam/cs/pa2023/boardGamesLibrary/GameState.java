package it.unicam.cs.pa2023.boardGamesLibrary;

//foto di ogni turno del gioco
public class GameState<B extends DefaultBoard, P extends Player> {

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
                "board=" + board +
                ", player=" + player +
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
