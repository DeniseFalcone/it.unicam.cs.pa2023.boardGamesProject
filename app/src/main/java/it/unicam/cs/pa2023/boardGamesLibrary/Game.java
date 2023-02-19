package it.unicam.cs.pa2023.boardGamesLibrary;

public interface Game<T extends DefaultPlayer, K extends DefaultRule> {

    //gestisce la dinamicita' del gioco
    void playGame(T player);

    void setupGame();

    boolean getStatistics(T player);

    boolean addPlayer(T player);

    boolean deletePlayer(T player);

    boolean addRule(K rule);

    boolean changeRule(K rule);

    boolean deleteRule(K rule);

    boolean addGameState(GameState gameState);

    boolean removeLastGameState();

    boolean addPlayerPiece(Piece piece, T player);

    boolean removePlayerPiece(Piece piece, T player);

    boolean updatePlayerScore(T player);
}
