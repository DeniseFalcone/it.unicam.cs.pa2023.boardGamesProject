package it.unicam.cs.pa2023.boardGamesLibrary;

public interface Game<T extends Player, K extends Rule, B extends Board> {

    void playGame();

    void setupGame();

    void getStatistics();

    boolean addPlayer(T player);

    boolean deletePlayer(T player);

    boolean addRule(K rule);

    boolean changeRule(K rule);

    boolean deleteRule(K rule);

    boolean addGameState(GameState<B,T> gameState);

    boolean removeLastGameState();

    void updatePlayersScore();

    String getGameName();

    T switchPlayer(T player);
}
