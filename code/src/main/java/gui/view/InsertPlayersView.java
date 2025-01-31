package src.main.java.gui.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import src.main.java.View;
import src.main.java.gamecomponents.Player;

/**
 * This is an abstract class that implements the view interface. it is the
 * splitter for the graphic and the console for the insert players page.
 */
public abstract class InsertPlayersView implements View {

	private String input;

	private ArrayList<Player> inseredPlayers = new ArrayList<>();

	/**
	 * Those are all the actions declaration.
	 */
	public ActionListener actionReturnMainPage;

	public ActionListener actionInsertPlayer;

	public ActionListener actionInitGame;

	/**
	 * This is a setter for the input.
	 * 
	 * @param input
	 */
	public void setInput(String input) {
		this.input = input;
	}

	/**
	 * This is the getter for the input.
	 * 
	 * @return input
	 */
	public String getInput() {
		return this.input;
	}

	public ArrayList<Player> getInseredPlayers() {
		return inseredPlayers;
	}

	/**
	 * This method add a player into the list
	 * 
	 * @param playerToInsert
	 */
	public void insertPlayers(Player playerToInsert) {
		inseredPlayers.add(playerToInsert);
	}

	/**
	 * Those methods are all warnings and they are abstract because the override of
	 * the method is in the graphic or in the console.
	 */

	public abstract void showTooFewPlayersWarning();

	public abstract void showTooManyPlayersWarning();

	public abstract void showDoublePlayersWarning();

	public abstract void showInvalidInputWarning();

	public abstract void showInseredPlayer();

}