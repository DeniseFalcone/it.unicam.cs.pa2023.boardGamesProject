package it.unicam.cs.pa2023.boardGamesLibrary;

public interface Game<T extends Player, K extends Rule, B extends Board> {

    /**
     * This method is used to play the game.
     */
    void playGame();

    /**
     * This method is used to make the setup of the game.
     */
    void setupGame();

    /**
     * Adds a player to the game.
     *
     * @param player The player to add to the game.
     * @return true if the player is correctly added to the game and false otherwise.
     */
    boolean addPlayer(T player);

    /**
     * Deletes the player from the game.
     *
     * @param player The player to delete.
     * @return true if the player is correctly removed from the game and false otherwise.
     */
    boolean deletePlayer(T player);

    /**
     * Adds a rule to the game.
     *
     * @param rule The rule to add to the set of rules.
     * @return true if the rule is correctly added to the game and false otherwise.
     */
    boolean addRule(K rule);

    /**
     * Deletes the rule from the game.
     *
     * @param rule The rule to delete.
     * @return true if the rule is correctly removed from the game and false otherwise.
     */
    boolean deleteRule(K rule);

    /**
     * Adds a game state to the list of game states
     *
     * @param gameState The GameState to add to the GameStateManager.
     * @return true if the game state is correctly added to the game and false otherwise.
     */
    boolean addGameState(GameState<B,T> gameState);

    /**
     * Removes the last game state from the stack
     *
     * @return true id the last game state is successfully removed from the game and false otherwise.
     */
    boolean removeLastGameState();

    /**
     * This method updates the players score during the game.
     */
    void updatePlayersScore();

    /**
     * This method returns the name of the game.
     *
     * @return the name of the game.
     */
    String getGameName();

    /**
     * Given a player, return the other player.
     *
     * @param player The current player.
     * @return The next player.
     */
    T switchPlayer(T player);
}
