package src.main.java;

import javax.sound.sampled.LineUnavailableException;

import src.main.java.gameComponents.GameManager;

/**
 * Interface to handle the user interaction with the program both input and
 * output.
 */
public interface UI {

	/**
	 * Visualize the main page.
	 *
	 * @param model is the reference to the game manager component. It is used to
	 *              link the controller to the game manager to allow state changes.
	 * @throws LineUnavailableException
	 */
	void showMainPage(GameManager model);

	/**
	 * Visualize the insert player page.
	 *
	 * @param model is the reference to the game manager component. It is used to
	 *              link the controller to the game manager to allow state changes.
	 */
	void showInsertPlayersPage(GameManager model);

	/**
	 * Visualize the game stage page.
	 *
	 * @param model is the reference to the game manager component. It is used to
	 *              link the controller to the game manager to allow state changes.
	 */
	void showGameStagePage(GameManager model);

	/**
	 * Visualize the points page.
	 *
	 * @param model is the reference to the game manager component. It is used to
	 *              link the controller to the game manager to allow state changes.
	 */
	void showWinnerPage(GameManager model);

}