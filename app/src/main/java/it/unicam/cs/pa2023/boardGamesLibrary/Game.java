package it.unicam.cs.pa2023.boardGamesLibrary;

public interface Game<T extends Player, K extends Rule, B extends Board> {

    boolean playGame(T player);

    void setupGame();

    boolean getStatistics(T player);

    boolean addPlayer(T player);

    boolean deletePlayer(T player);

    boolean addRule(K rule);

    boolean changeRule(K rule);

    boolean deleteRule(K rule);

    boolean addGameState(GameState<B,T> gameState);

    boolean removeLastGameState();

    boolean addPlayerPiece(Piece piece, T player);

    boolean removePlayerPiece(Piece piece, T player);

    boolean updatePlayerScore(T player);

    String getGameName();
}
