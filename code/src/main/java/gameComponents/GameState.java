
package src.main.java.gameComponents;

/**
 * Represents the various states the game can be in: STARTING (players place
 * workers), RUNNING (standard game loop), ENDED (game has a winner).
 */
public enum GameState {
	/**
	 * Represents the starting phase of the game.
	 */
	HOME,
	// STARTING,
	INIT_GAME, INSERT_PLAYERS, GAME_STAGE, CONTROLS,
	/**
	 * Represents the main gameplay phase of the game.
	 */
	// RUNNING,
	/**
	 * Represents the end of the game.
	 */
	ENDED, EXIT, IDLE,
}